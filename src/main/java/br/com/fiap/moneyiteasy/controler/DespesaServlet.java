package br.com.fiap.moneyiteasy.controler;

import br.com.fiap.moneyiteasy.dao.interfaces.CalculosDao;
import br.com.fiap.moneyiteasy.dao.interfaces.DespesaDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.factory.DaoFactory;
import br.com.fiap.moneyiteasy.model.Categoria;
import br.com.fiap.moneyiteasy.model.Despesa;
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
    private static final String tipoCategoria = "despesa";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        daoDespesa = DaoFactory.getDespesaDao();
        totaisDao = DaoFactory.getCalculosDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            double valor = Double.parseDouble(req.getParameter("valorDespesa"));
            LocalDate date = LocalDate.parse(req.getParameter("dataDespesa"));
            int idCategoria = 5;
            String nomeCategoria = req.getParameter("categoriaDespesa");
            String tipoCategoria = "DESPESA";
            Categoria categoria = new Categoria(idCategoria, nomeCategoria, tipoCategoria);
            Despesa despesa = new Despesa(0, valor, date, categoria);

            daoDespesa.cadastraDespesa(despesa);
            req.setAttribute("despesa", "Despesa cadastrada com sucesso");
        }catch (DBException db) {
            db.printStackTrace();
            req.setAttribute("despesa", "Erro ao cadastrar despesa");
        }catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("despesa", "Por favor, valide os dados");
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            listarDespesa(req);
            totaisTransacoes(req);
            req.getRequestDispatcher("despesa.jsp").forward(req, resp);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    private void listarDespesa(HttpServletRequest req) throws ServletException, IOException, DBException {
        List<Despesa> listaDespesas = daoDespesa.listaDespesas();
        req.setAttribute("listaDespesas", listaDespesas);
    }

    private void totaisTransacoes(HttpServletRequest req) throws ServletException, IOException {
        try{
            double totalDespesa = totaisDao.totalDespesa();
            double totalReceita = totaisDao.totalReceita();
            double saldoTotal = totalReceita - totalDespesa;
            req.setAttribute("totalDespesa", totalDespesa);
            req.setAttribute("saldoTotal", saldoTotal);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

}
