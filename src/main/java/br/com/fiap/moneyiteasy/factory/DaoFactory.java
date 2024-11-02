package br.com.fiap.moneyiteasy.factory;

import br.com.fiap.moneyiteasy.dao.UsuarioDao;
import br.com.fiap.moneyiteasy.dao.impl.OracleUsuarioDao;

public class DaoFactory {

    public static UsuarioDao getUsuarioDao() {
        return new OracleUsuarioDao();
    }

}
