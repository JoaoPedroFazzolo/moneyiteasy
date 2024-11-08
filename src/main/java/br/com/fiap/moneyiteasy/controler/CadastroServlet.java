package br.com.fiap.moneyiteasy.controler;

import br.com.fiap.moneyiteasy.dao.interfaces.LoginDao;
import br.com.fiap.moneyiteasy.dao.interfaces.UsuarioDao;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {

    private LoginDao loginDao;
    private UsuarioDao usuarioDao;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    //doPost
    //dao cadastrologin
    //dao casdastrousuario

}
