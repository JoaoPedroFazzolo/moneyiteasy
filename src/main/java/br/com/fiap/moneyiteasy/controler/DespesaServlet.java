package br.com.fiap.moneyiteasy.controler;

import br.com.fiap.moneyiteasy.dao.interfaces.CalculosDao;
import br.com.fiap.moneyiteasy.dao.interfaces.CategoriaDao;
import br.com.fiap.moneyiteasy.dao.interfaces.DespesaDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.factory.DaoFactory;
import br.com.fiap.moneyiteasy.model.Categoria;
import br.com.fiap.moneyiteasy.model.Despesa;
import br.com.fiap.moneyiteasy.model.Usuario;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/despesa")
public class DespesaServlet extends HttpServlet {

    private DespesaDao daoDespesa;
    private CalculosDao totaisDao;
    private CategoriaDao categoriaDao;
    private static final String tipoCategoria = "despesa";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        daoDespesa = DaoFactory.getDespesaDao();
        totaisDao = DaoFactory.getCalculosDao();
        categoriaDao = DaoFactory.getCategoriaDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        switch (acao) {
            case "cadastrarDespesas":
                cadastrarDespesa(req, resp);
                break;
            case "editarDespesas":
                editarDespesa(req, resp);
                break;
            case "excluirDespesas":
                excluirDespesa(req,resp);
                break;

        }
    }

    private void excluirDespesa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idDespesa = Integer.parseInt(req.getParameter("codigoDespesaExcluir"));
        System.out.println(idDespesa);
        try{
            daoDespesa.removerDespesa(idDespesa);
            req.setAttribute("msgDespesa", "Despesa removida com sucesso");
        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("erroDespesa", "Erro ao excluir receita");
        }
        resp.sendRedirect("despesa?acao=listarDespesa");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        switch (acao) {
            case "listarDespesa":
                try {
                    listarDespesa(req);
                    totaisTransacoes(req);
                    req.getRequestDispatcher("despesa.jsp").forward(req, resp);
                } catch (DBException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "formCadastroDespesa":
                try {
                    abrirFormCadastro(req, resp);
                } catch (DBException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "formEditarDespesa":
                try {
                    formEditarDespesa(req, resp);
                } catch (DBException e) {
                    throw new RuntimeException(e);
                }
                break;

        }

    }

    private void abrirFormCadastro(HttpServletRequest req, HttpServletResponse resp) throws DBException, ServletException, IOException {
        List<Categoria> listaCategorias = categoriaDao.listar(tipoCategoria);
        req.setAttribute("listaCategorias", listaCategorias);
        req.getRequestDispatcher("adicionar-despesa.jsp").forward(req, resp);
    }

    private void formEditarDespesa(HttpServletRequest req, HttpServletResponse resp) throws DBException, ServletException, IOException {
        List<Categoria> listaCategorias = categoriaDao.listar(tipoCategoria);
        req.setAttribute("listaCategorias", listaCategorias);
        int idReceita = Integer.parseInt(req.getParameter("codigo"));
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioObjeto");
        Despesa despesa = daoDespesa.buscar(idReceita, usuario.getIdUsuario());
        req.setAttribute("despesaEditar", despesa);
        req.getRequestDispatcher("editar-despesa.jsp").forward(req, resp);
    }


    private void cadastrarDespesa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            double valor = Double.parseDouble(req.getParameter("valorDespesa"));
            LocalDate date = LocalDate.parse(req.getParameter("dataDespesa"));
            int idCategoria = Integer.parseInt(req.getParameter("categoriaDespesa"));
            Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioObjeto");
            Categoria categoria = new Categoria();
            categoria.setCodigo(idCategoria);

            Despesa despesa = new Despesa(0, valor, date, categoria);
            daoDespesa.cadastraDespesa(despesa, usuario.getIdUsuario());
            req.setAttribute("despesa", "Despesa cadastrada com sucesso");
        } catch (DBException db) {
            req.getRequestDispatcher("erro-adicionar-despesa.jsp").forward(req, resp);
        } catch (Exception e) {
            req.getRequestDispatcher("erro-adicionar-despesa.jsp").forward(req, resp);
        }
        resp.sendRedirect("despesa?acao=listarDespesa");
    }


    private void editarDespesa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("codigo"));
            double valor = Double.parseDouble(req.getParameter("valorDespesa"));
            LocalDate date = LocalDate.parse(req.getParameter("dataDespesa"));
            int idCategoria = Integer.parseInt(req.getParameter("categoriaDespesa"));
            Categoria categoria = new Categoria();
            categoria.setCodigo(idCategoria);
            Despesa despesa = new Despesa(id, valor, date, categoria);
            daoDespesa.atualizaDespesa(despesa);
            req.setAttribute("receita", "Despesa atualizada com sucesso");
            resp.sendRedirect("despesa?acao=listarDespesa");
        } catch (DBException e) {
            req.getRequestDispatcher("erro-editar-despesa.jsp").forward(req, resp);
        }
    }

    private void listarDespesa(HttpServletRequest req) throws ServletException, IOException, DBException {
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioObjeto");
        List<Despesa> despesas = daoDespesa.listaDespesa(usuario.getIdUsuario());
        req.setAttribute("despesas", despesas);
    }

    private void totaisTransacoes(HttpServletRequest req) throws ServletException, IOException {
        try{
            Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioObjeto");
            double totalDespesa = totaisDao.totalDespesa(usuario.getIdUsuario());
            double totalReceita = totaisDao.totalReceita(usuario.getIdUsuario());
            double saldoTotal = totalReceita - totalDespesa;
            req.setAttribute("totalDespesa", totalDespesa);
            req.setAttribute("saldoTotal", saldoTotal);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

}