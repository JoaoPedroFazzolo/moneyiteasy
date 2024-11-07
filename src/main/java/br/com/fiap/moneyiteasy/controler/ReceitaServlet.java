package br.com.fiap.moneyiteasy.controler;

import br.com.fiap.moneyiteasy.dao.interfaces.CalculosDao;
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
    private static final String tipoCategoria = "receita";


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        daoReceita = DaoFactory.getReceitaDao();
        totaisDao = DaoFactory.getCalculosDao();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        switch (acao) {
            case "cadastrarReceita":
                cadastrarReceita(req, resp);
                break;
            case "editarReceitas":

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            listarReceita(req);
            totaisTransacoes(req);
            req.getRequestDispatcher("receita.jsp").forward(req, resp);
        } catch (DBException e) {
            throw new RuntimeException(e);
        }
    }

    private void cadastrarReceita(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double valor = Double.parseDouble(req.getParameter("valorReceita"));
        LocalDate date = LocalDate.parse(req.getParameter("dataReceita"));
        int idCategoria = Integer.parseInt(req.getParameter("listaCategoriaReceita"));
        Categoria categoria = new Categoria();
        categoria.setCodigo(idCategoria);

        Receita receita = new Receita(0, valor, date, categoria);
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
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }


    private void editarReceita(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("idReceita"));
        double valor = Double.parseDouble(req.getParameter("valorReceita"));
        LocalDate date = LocalDate.parse(req.getParameter("dataReceita"));
    }


    private void listarReceita(HttpServletRequest req) throws ServletException, IOException, DBException {
        List<Receita> receitas = daoReceita.listaReceita();
        req.setAttribute("receitas", receitas);
    }

    private void totaisTransacoes(HttpServletRequest req) throws ServletException, IOException {
        try{
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

