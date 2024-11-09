package br.com.fiap.moneyiteasy.controler;

import br.com.fiap.moneyiteasy.dao.interfaces.LoginDao;
import br.com.fiap.moneyiteasy.dao.interfaces.UsuarioDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.factory.DaoFactory;
import br.com.fiap.moneyiteasy.model.Login;
import br.com.fiap.moneyiteasy.model.Usuario;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;


@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
    private UsuarioDao usuarioDao;
    private LoginDao loginDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        loginDao = DaoFactory.getLoginDao();
        usuarioDao = DaoFactory.getUsuarioDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomeUsuario = req.getParameter("nomeUsuario");
        String cpfUsuario = req.getParameter("cpfUsuario");
        String emailUsuario = req.getParameter("emailusuario");
        String senhaUsuario = req.getParameter("senhaUsuario");
        LocalDate localDate = LocalDate.now();
        Login loginUsuario = new Login(emailUsuario, senhaUsuario);
        Usuario usuario = new Usuario(0, nomeUsuario, cpfUsuario, localDate, loginUsuario);
        try {
            loginDao.cadastrarLogin(loginUsuario);
            usuarioDao.cadastrar(usuario);
        } catch (DBException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("login.jsp");
    }



    //doPost
    //dao cadastrologin
    //dao casdastrousuario

}
