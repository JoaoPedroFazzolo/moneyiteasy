package br.com.fiap.moneyiteasy.factory;

import br.com.fiap.moneyiteasy.dao.impl.OracleCategoriaDao;
import br.com.fiap.moneyiteasy.dao.impl.OracleReceitaDao;
import br.com.fiap.moneyiteasy.dao.interfaces.CategoriaDao;
import br.com.fiap.moneyiteasy.dao.interfaces.LoginDao;
import br.com.fiap.moneyiteasy.dao.interfaces.ReceitaDao;
import br.com.fiap.moneyiteasy.dao.interfaces.UsuarioDao;
import br.com.fiap.moneyiteasy.dao.impl.OracleLoginDao;
import br.com.fiap.moneyiteasy.dao.impl.OracleUsuarioDao;

public class DaoFactory {

    public static UsuarioDao getUsuarioDao() {return new OracleUsuarioDao();}

    public static LoginDao getLoginDao() {
        return new OracleLoginDao();
    }

    public static CategoriaDao getCategoriaDao() {return new OracleCategoriaDao();}

    public static ReceitaDao getReceitaDao() {return new OracleReceitaDao();}
}
