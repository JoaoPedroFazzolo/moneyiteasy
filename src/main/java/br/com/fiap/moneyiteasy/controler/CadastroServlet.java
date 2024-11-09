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
        String acao = req.getParameter("acao");

        switch (acao) {
            case "cadastrar":
                cadastrar(req, resp);
                break;
            case "atualizar":
                atualizar(req, resp);
                break;
            case "excluir":
                excluir(req, resp);
                break;
        }
    }

    private void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            req.setAttribute("usuario", "Usuario cadastrado com sucesso");
        } catch (DBException db) {
            db.printStackTrace();
            req.setAttribute("usuario", "Erro ao cadastrar usuario");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("usuario", "Por favor, valide os dados");
        }
    }

//    Teste
    private void atualizar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String nomeUsuario = req.getParameter("nomeUsuario");
            String senhaUsuario = req.getParameter("senhaUsuario");

//            Usuario usuario = new Usuario(nomeUsuario);
//            Login login = new Login(senhaUsuario);
//            usuario.setLogin(login);
//            usuarioDao.atualizar(usuario);
            req.setAttribute("usuario", "Usuario atualizado com sucesso");
            resp.sendRedirect("index");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void excluir(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idUsuario = Integer.parseInt(req.getParameter("codigoExcluir"));
        System.out.println(idUsuario);
        try{
            usuarioDao.remover(idUsuario);
            req.setAttribute("msg", "Usuario removido com sucesso");
        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("msg", "Erro ao excluir usuario");
        }
        resp.sendRedirect("login");
    }




    //doPost
    //dao cadastrologin
    //dao casdastrousuario

}
