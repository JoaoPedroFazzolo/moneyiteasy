package br.com.fiap.moneyiteasy.controler;

import br.com.fiap.moneyiteasy.bo.EmailBo;
import br.com.fiap.moneyiteasy.dao.interfaces.LoginDao;
import br.com.fiap.moneyiteasy.dao.interfaces.UsuarioDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.factory.DaoFactory;
import br.com.fiap.moneyiteasy.model.Login;

import br.com.fiap.moneyiteasy.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private LoginDao dao;
    private EmailBo bo;
    private Usuario usuario;
    private UsuarioDao usuarioDao;

    public LoginServlet() {
        dao = DaoFactory.getLoginDao();
        bo = new EmailBo();
        usuario = new Usuario();
        usuarioDao = DaoFactory.getUsuarioDao();
    }

    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        Login login = new Login(email, senha);

        if (dao.validarLogin(login)) {
            try {;
                usuario = usuarioDao.buscarUsuario(email);
            } catch (DBException e) {
                throw new RuntimeException(e);
            }
            HttpSession session = req.getSession();
            session.setAttribute("user", email);
            String mensagem = "Um login foi realizado na plataforma em " + LocalDate.now();
            String primeiroNome = usuario.getNome().trim().split(" ")[0];
            session.setAttribute("primeiroNome", primeiroNome);
            session.setAttribute("loginObjeto", login);
            session.setAttribute("usuarioObjeto", usuario);
            resp.sendRedirect("index");
//            try {
//                bo.enviarEmail(email, "Login Realizado", mensagem);
//            } catch (EmailException e) {
//                e.printStackTrace();
//            }
        } else {
            req.setAttribute("erroLogin", "Usuário e/ou senha inválidos");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
