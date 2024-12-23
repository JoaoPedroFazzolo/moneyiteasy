package br.com.fiap.moneyiteasy.dao.interfaces;

import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.model.Login;

import java.sql.SQLException;

public interface LoginDao {
    boolean validarLogin(Login login);
    void cadastrarTbLogin(Login login) throws DBException;
    Login buscarTbLogin(Login login) throws DBException;
    void atualizarTbLogin(Login login) throws DBException, SQLException;
}
