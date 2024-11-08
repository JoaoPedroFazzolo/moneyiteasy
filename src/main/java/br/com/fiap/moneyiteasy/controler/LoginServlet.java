package br.com.fiap.moneyiteasy.controler;

import br.com.fiap.moneyiteasy.bo.EmailBo;
import br.com.fiap.moneyiteasy.bo.EmailException;
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
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Login login = new Login(email, senha);

        if (dao.validarLogin(login)) {
            try {
                usuario.setNome(String.valueOf(usuarioDao.buscarNomeUsuario(email)));
                System.out.println(usuario.getNome());
            } catch (DBException e) {
                throw new RuntimeException(e);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user", email);
            String mensagem =
                    "Um login foi realizado na plataforma em " + LocalDate.now();
            String primeiroNome = usuario.getNome().trim().split(" ")[0];
            System.out.println(primeiroNome);
            request.setAttribute("nomeUsuario",primeiroNome);
            response.sendRedirect("index");
            try {
                bo.enviarEmail(email, "Login Realizado", mensagem);
            } catch (EmailException e) {
                e.printStackTrace();
            }

        }else {
            request.setAttribute("erro", "Usuário e/ou senha inválidos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
