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
import java.sql.SQLException;
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
        String acao = req.getParameter("acao");
        switch (acao) {
            case "cadastroUsuario":
                cadastrarUsuario(req, resp);
                break;
            case "editarUsuario":
                try {
                    editarUsuario(req, resp);
                } catch (DBException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
                case "excluirUsuario":
                    try {
                        excluirUsuario(req, resp);
                    } catch (DBException e) {
                        throw new RuntimeException(e);
                    }
                    break;
        }

    }

    private void excluirUsuario(HttpServletRequest req, HttpServletResponse resp) throws DBException, ServletException, IOException {
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioObjeto");
        System.out.println(usuario.getLogin().getEmail());
        usuarioDao.removerUsuario(usuario);
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    private void editarUsuario(HttpServletRequest req, HttpServletResponse resp) throws DBException, SQLException, ServletException, IOException {
        try {
            Usuario usuarioSession = (Usuario) req.getSession().getAttribute("usuarioObjeto");
            int idUsuario = usuarioSession.getIdUsuario();
            Login loginSession = (Login) req.getSession().getAttribute("loginObjeto");
            String email = loginSession.getEmail();
            String nome = req.getParameter("nomeUsuario");
            String cpf = req.getParameter("cpfUsuario");
            String senha = req.getParameter("senhaUsuario");
            Usuario usuario = new Usuario(idUsuario, nome, cpf);
            Login login = new Login(email, senha);
            usuarioDao.atualizar(usuario);
            loginDao.atualizarTbLogin(login);
            String primeiroNome = usuario.getNome().trim().split(" ")[0];
            req.getSession().setAttribute("primeiroNome", primeiroNome);
            req.getSession().setAttribute("loginObjeto", login);
            req.getSession().setAttribute("usuarioObjeto", usuario);
            resp.sendRedirect("index");
        } catch (DBException e) {
            req.getRequestDispatcher("erro-editar-usuario.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        switch (acao) {
            case "editarUsuario":
                formEditarUsuario(req, resp);
                break;
        }
    }

    private void formEditarUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Login login = (Login) req.getSession().getAttribute("loginObjeto");
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioObjeto");
        req.setAttribute("loginObjeto", login);
        req.setAttribute("usuarioObjeto", usuario);
        req.getRequestDispatcher("editar-usuario.jsp").forward(req, resp);
    }

    private void cadastrarUsuario(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String nomeUsuario = req.getParameter("nomeUsuario");
        String cpfUsuario = req.getParameter("cpfUsuario");
        String emailUsuario = req.getParameter("emailusuario");
        String senhaUsuario = req.getParameter("senhaUsuario");
        LocalDate localDate = LocalDate.now();
        Login loginUsuario = new Login(emailUsuario, senhaUsuario);
        Usuario usuario = new Usuario(0, nomeUsuario, cpfUsuario, localDate, loginUsuario);
        try {
            loginDao.cadastrarTbLogin(loginUsuario);
            usuarioDao.cadastrarTbUsuario(usuario);
        } catch (DBException e) {
            req.setAttribute("erroCadastro", "Preencha todos os campos!");
            req.getRequestDispatcher("cadastro.jsp").forward(req, resp);
        }
        resp.sendRedirect("login.jsp");

    }
}


