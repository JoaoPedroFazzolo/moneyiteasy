package br.com.fiap.moneyiteasy.dao;

import br.com.fiap.moneyiteasy.model.Login;

public interface LoginDao {
    boolean validarLogin(Login login);
}
