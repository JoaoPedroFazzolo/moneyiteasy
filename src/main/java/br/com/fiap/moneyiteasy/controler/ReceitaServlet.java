package br.com.fiap.moneyiteasy.controler;

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

@WebServlet("/receita")
public class ReceitaServlet extends HttpServlet {

    private ReceitaDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dao = DaoFactory.getReceitaDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            double valor = Double.parseDouble(req.getParameter("incomeValue"));
            LocalDate date = LocalDate.parse(req.getParameter("incomeDate"));
            int idCategoria = Integer.parseInt(req.getParameter("idCategoria"));
            String nomeCategoria = req.getParameter("incomeCategory");
            String tipoCategoria = "RECEITA";
            Categoria categoria = new Categoria(idCategoria, nomeCategoria, tipoCategoria);
            Receita receita = new Receita(0, valor, date, categoria);

            dao.cadastraReceita(receita);
            req.setAttribute("receita", "Receita cadastrada com sucesso");
        }catch (DBException db) {
            db.printStackTrace();
            req.setAttribute("receita", "Erro ao cadastrar receita");
        }catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("receita", "Por favor, valide os dados");
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }

}
