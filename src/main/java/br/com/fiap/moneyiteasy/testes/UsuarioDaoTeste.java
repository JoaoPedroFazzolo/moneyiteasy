package br.com.fiap.moneyiteasy.testes;

import br.com.fiap.moneyiteasy.dao.interfaces.UsuarioDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.factory.DaoFactory;
import br.com.fiap.moneyiteasy.model.Usuario;

public class UsuarioDaoTeste {
    public static void main(String[] args) throws DBException {
        UsuarioDao usuarioDao = DaoFactory.getUsuarioDao();

        Usuario usuario = usuarioDao.buscarNomeUsuario("teste@email.com");


        System.out.println(usuario.getNome());

    }
}
