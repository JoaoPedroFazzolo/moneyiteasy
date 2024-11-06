package br.com.fiap.moneyiteasy.controler;

import br.com.fiap.moneyiteasy.dao.interfaces.CalculosDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.factory.DaoFactory;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    CalculosDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dao = DaoFactory.getCalculosDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        totaisTransacoes(req, resp);
    }

    private void totaisTransacoes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            double totalDespesa = dao.totalDespesa();
            double totalReceita = dao.totalReceita();
            double totalInvestimento = dao.totalInvestimento();
            double saldoTotal = totalReceita - totalInvestimento - totalDespesa;
            req.setAttribute("totalDespesa", totalDespesa);
            req.setAttribute("totalReceita", totalReceita);
            req.setAttribute("totalInvestimento", totalInvestimento);
            req.setAttribute("saldoTotal", saldoTotal);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}
