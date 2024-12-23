package br.com.fiap.moneyiteasy.factory;

import br.com.fiap.moneyiteasy.bo.EmailBo;
import br.com.fiap.moneyiteasy.dao.impl.*;
import br.com.fiap.moneyiteasy.dao.interfaces.*;

public class DaoFactory {

    public static UsuarioDao getUsuarioDao() {return new OracleUsuarioDao();}

    public static LoginDao getLoginDao() {
        return new OracleLoginDao();
    }

    public static CategoriaDao getCategoriaDao() {return new OracleCategoriaDao();}

    public static ReceitaDao getReceitaDao() {return new OracleReceitaDao();}

    public static DespesaDao getDespesaDao() {return new OracleDespesaDao();}

    public static CalculosDao getCalculosDao() {return new OracleCalculosDao();}

    public static EmailBo getEmailBo() {return new EmailBo();}
}
