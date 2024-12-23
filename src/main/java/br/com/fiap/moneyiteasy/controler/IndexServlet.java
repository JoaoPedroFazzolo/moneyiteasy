package br.com.fiap.moneyiteasy.controler;

import br.com.fiap.moneyiteasy.dao.interfaces.CalculosDao;
import br.com.fiap.moneyiteasy.dao.interfaces.DespesaDao;
import br.com.fiap.moneyiteasy.dao.interfaces.ReceitaDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.factory.DaoFactory;
import br.com.fiap.moneyiteasy.model.Despesa;
import br.com.fiap.moneyiteasy.model.Receita;
import br.com.fiap.moneyiteasy.model.Usuario;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    CalculosDao dao;
    ReceitaDao daoReceita;
    DespesaDao daoDespesa;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dao = DaoFactory.getCalculosDao();
        daoReceita = DaoFactory.getReceitaDao();
        daoDespesa = DaoFactory.getDespesaDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        totaisTransacoes(req);
        try {
            listarReceita(req);
            listarDespesa(req);
        } catch (DBException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    private void totaisTransacoes(HttpServletRequest req) throws ServletException, IOException {
        try{
            Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioObjeto");
            double totalDespesa = dao.totalDespesa(usuario.getIdUsuario());
            double totalReceita = dao.totalReceita(usuario.getIdUsuario());
            double saldoTotal = totalReceita - totalDespesa;
            req.setAttribute("totalDespesa", totalDespesa);
            req.setAttribute("totalReceita", totalReceita);
            req.setAttribute("saldoTotal", saldoTotal);

        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private void listarReceita(HttpServletRequest req) throws ServletException, IOException, DBException {
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioObjeto");
        List<Receita> receitas = daoReceita.listaReceita(usuario.getIdUsuario());
        req.setAttribute("receitas", receitas);
    }

    private void listarDespesa(HttpServletRequest req) throws ServletException, IOException, DBException {
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioObjeto");
        List<Despesa> despesas = daoDespesa.listaDespesa(usuario.getIdUsuario());
        req.setAttribute("despesas", despesas);
    }


}
