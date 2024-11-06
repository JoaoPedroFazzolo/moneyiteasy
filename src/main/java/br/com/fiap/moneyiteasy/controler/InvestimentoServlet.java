package br.com.fiap.moneyiteasy.controler;

import br.com.fiap.moneyiteasy.dao.interfaces.CalculosDao;
import br.com.fiap.moneyiteasy.dao.interfaces.InvestimentoDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.factory.DaoFactory;
import br.com.fiap.moneyiteasy.model.Categoria;
import br.com.fiap.moneyiteasy.model.Despesa;
import br.com.fiap.moneyiteasy.model.Investimento;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/investimento")
public class InvestimentoServlet extends HttpServlet {

    private InvestimentoDao dao;
    private CalculosDao totaisDao;
    private static final String tipoCategoria = "despesa";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dao = DaoFactory.getInvestimentoDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            double valor = Double.parseDouble(req.getParameter("valorInvestimento"));
            LocalDate date = LocalDate.parse(req.getParameter("dataInvestimento"));
            int idCategoria = 11;
            String nomeCategoria = req.getParameter("categoriaInvestimento");
            String tipoCategoria = "INVESTIMENTO";
            Categoria categoria = new Categoria(idCategoria, nomeCategoria, tipoCategoria);
            Investimento investimento = new Investimento(0, valor, date, categoria);

            dao.cadastraInvestimento(investimento);
            req.setAttribute("investimento", "Investimento cadastrada com sucesso");
        }catch (DBException db) {
            db.printStackTrace();
            req.setAttribute("investimento", "Erro ao cadastrar investimento");
        }catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("investimento", "Por favor, valide os dados");
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            listarInvestimento(req, resp);
        } catch (DBException e) {
            throw new RuntimeException(e);
        }
    }

    private void listarInvestimento(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, DBException {
        List<Investimento> investimentos = dao.listaInvestimento();
        req.setAttribute("investimentos", investimentos);
        req.getRequestDispatcher("investimento.jsp").forward(req, resp);

    }

}
