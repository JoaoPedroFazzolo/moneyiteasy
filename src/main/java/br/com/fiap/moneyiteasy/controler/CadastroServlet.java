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

        // Valida se a ação é nula
        if (acao == null || acao.isEmpty()) {
            resp.sendRedirect("erro.jsp");
            return;
        }

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
            default:
                resp.sendRedirect("erro.jsp");
                break;
        }
    }

    private void cadastrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomeUsuario = req.getParameter("nomeUsuario");
        String cpfUsuario = req.getParameter("cpfUsuario");
        String emailUsuario = req.getParameter("emailusuario");
        String senhaUsuario = req.getParameter("senhaUsuario");

        // Validar se os campos obrigatórios foram preenchidos
        if (nomeUsuario == null || cpfUsuario == null || emailUsuario == null || senhaUsuario == null) {
            req.setAttribute("usuario", "Por favor, preencha todos os campos obrigatórios.");
            req.getRequestDispatcher("cadastro").forward(req, resp);
            return;
        }

        LocalDate localDate = LocalDate.now();
        Login loginUsuario = new Login(emailUsuario, senhaUsuario);
        Usuario usuario = new Usuario(0, nomeUsuario, cpfUsuario, localDate, loginUsuario);
        try {
            // Cadastrar login e usuário em uma única transação
            usuarioDao.cadastrar(usuario);
            loginDao.cadastrarLogin(loginUsuario);

            req.setAttribute("usuario", "Usuario cadastrado com sucesso");
            resp.sendRedirect("index");
        } catch (DBException db) {
            db.printStackTrace();
            req.setAttribute("usuario", "Erro ao cadastrar usuario: " + db.getMessage());
            req.getRequestDispatcher("cadastro").forward(req, resp);
        }
    }

    private void atualizar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int idUsuario = Integer.parseInt(req.getParameter("idUsuario"));
            String nomeUsuario = req.getParameter("nomeUsuario");
            String senhaUsuario = req.getParameter("senhaUsuario");

            if (nomeUsuario == null || senhaUsuario == null) {
                req.setAttribute("usuario", "Por favor, preencha todos os campos.");
                req.getRequestDispatcher("atualizar.jsp").forward(req, resp);
                return;
            }

            Usuario usuario = usuarioDao.buscarUsuarioPorId(idUsuario);
            if (usuario != null) {
                usuario.setNome(nomeUsuario);
                usuario.getLogin().setSenha(senhaUsuario);
                usuarioDao.atualizar(usuario);

                req.setAttribute("usuario", "Usuario atualizado com sucesso");
                resp.sendRedirect("index.jsp");
            } else {
                req.setAttribute("usuario", "Usuario não encontrado.");
                req.getRequestDispatcher("atualizar.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("usuario", "Erro ao atualizar usuario");
            req.getRequestDispatcher("atualizar.jsp").forward(req, resp);
        }
    }

    private void excluir(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int idUsuario = Integer.parseInt(req.getParameter("codigoExcluir"));
            usuarioDao.remover(idUsuario);
            req.setAttribute("msg", "Usuario removido com sucesso");
            resp.sendRedirect("login.jsp");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            req.setAttribute("msg", "ID de usuário inválido");
            req.getRequestDispatcher("erro.jsp").forward(req, resp);
        } catch (DBException e) {
            e.printStackTrace();
            req.setAttribute("msg", "Erro ao excluir usuario");
            req.getRequestDispatcher("erro.jsp").forward(req, resp);
        }
    }
}