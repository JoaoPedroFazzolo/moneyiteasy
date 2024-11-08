package br.com.fiap.moneyiteasy.controler;

import br.com.fiap.moneyiteasy.dao.interfaces.CalculosDao;
import br.com.fiap.moneyiteasy.dao.interfaces.CategoriaDao;
import br.com.fiap.moneyiteasy.dao.interfaces.ReceitaDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.factory.DaoFactory;
import br.com.fiap.moneyiteasy.model.Categoria;
import br.com.fiap.moneyiteasy.model.Receita;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/receita")
public class ReceitaServlet extends HttpServlet {

    private ReceitaDao daoReceita;
    private CalculosDao totaisDao;
    private CategoriaDao categoriaDao;
    private static final String tipoCategoria = "receita";


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        daoReceita = DaoFactory.getReceitaDao();
        totaisDao = DaoFactory.getCalculosDao();
        categoriaDao = DaoFactory.getCategoriaDao();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        switch (acao) {
            case "cadastrarReceitas":
                cadastrarReceita(req, resp);
                break;
            case "editarReceitas":
                editarReceita(req, resp);
                break;
            case "excluirReceitas":
                excluirReceitas(req,resp);
                break;

        }
    }

    private void excluirReceitas(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idReceita = Integer.parseInt(req.getParameter("codigoExcluir"));
        System.out.println(idReceita);
        try{
            daoReceita.removerReceita(idReceita);
            req.setAttribute("msg", "Receita removida com sucesso");
        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("msg", "Erro ao excluir receita");
        }
        resp.sendRedirect("receita?acao=listarReceita");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        switch (acao) {
            case "listarReceita":
                try {
                    listarReceita(req);
                    totaisTransacoes(req);
                    req.getRequestDispatcher("receita.jsp").forward(req, resp);
                    break;
                } catch (DBException e) {
                    throw new RuntimeException(e);
                }
            case "formCadastroReceita":
                try {
                    abrirFormCadastro(req,resp);
                } catch (DBException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "formEditarReceita":
                try {
                    formEditarReceita(req, resp);
                } catch (DBException e) {
                    throw new RuntimeException(e);
                }
                break;

        }


    }

    private void abrirFormCadastro(HttpServletRequest req, HttpServletResponse resp) throws DBException, ServletException, IOException {
        List<Categoria> listaCategorias = categoriaDao.listar(tipoCategoria);
        req.setAttribute("listaCategorias", listaCategorias);
        req.getRequestDispatcher("adicionar-receita.jsp").forward(req, resp);
    }

    private void formEditarReceita(HttpServletRequest req, HttpServletResponse resp) throws DBException, ServletException, IOException {
        List<Categoria> listaCategorias = categoriaDao.listar(tipoCategoria);
        req.setAttribute("listaCategorias", listaCategorias);
        int id = Integer.parseInt(req.getParameter("codigo"));
        Receita receita = daoReceita.buscar(id);
        req.setAttribute("receitaEditar", receita);
        req.getRequestDispatcher("editar-receita.jsp").forward(req, resp);
    }

    private void cadastrarReceita(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double valor = Double.parseDouble(req.getParameter("valorReceita"));
        LocalDate date = LocalDate.parse(req.getParameter("dataReceita"));
        int idCategoria = Integer.parseInt(req.getParameter("categoriaReceita"));
        Categoria categoria = new Categoria();
        categoria.setCodigo(idCategoria);
        System.out.println(categoria.getCodigo());
        Receita receita = new Receita(0, valor, date, categoria);
        System.out.println(receita.getCategoria().getCodigo());
        try {
            daoReceita.cadastraReceita(receita);
            req.setAttribute("receita", "Receita cadastrada com sucesso");
        } catch (DBException db) {
            db.printStackTrace();
            req.setAttribute("receita", "Erro ao cadastrar receita");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("receita", "Por favor, valide os dados");
        }
        resp.sendRedirect("receita?acao=listarReceita");
    }


    private void editarReceita(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("codigo"));
            double valor = Double.parseDouble(req.getParameter("valorReceita"));
            LocalDate date = LocalDate.parse(req.getParameter("dataReceita"));
            int idCategoria = Integer.parseInt(req.getParameter("categoriaReceita"));
            Categoria categoria = new Categoria();
            categoria.setCodigo(idCategoria);
            Receita receita = new Receita(id, valor, date, categoria);
            System.out.println(receita.getCategoria().getCodigo());
            System.out.println(receita.getDate());
            System.out.println(receita.getIdTransacao());
            System.out.println(receita.getValor());
            daoReceita.atualizaReceita(receita);
            req.setAttribute("receita", "Receita atualizada com sucesso");
            resp.sendRedirect("receita?acao=listarReceita");
        } catch (DBException e) {
            throw new RuntimeException(e);
        }
    }


    private void listarReceita(HttpServletRequest req) throws ServletException, IOException, DBException {
        List<Receita> receitas = daoReceita.listaReceita();
        req.setAttribute("receitas", receitas);
    }

    private void totaisTransacoes(HttpServletRequest req) throws ServletException, IOException {
        try {
            double totalReceita = totaisDao.totalReceita();
            double totalDespesa = totaisDao.totalDespesa();
            double saldoTotal = totalReceita - totalDespesa;
            req.setAttribute("totalReceita", totalReceita);
            req.setAttribute("saldoTotal", saldoTotal);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }
}

