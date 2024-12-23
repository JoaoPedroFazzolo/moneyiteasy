package br.com.fiap.moneyiteasy.testes;


import br.com.fiap.moneyiteasy.dao.interfaces.CalculosDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.factory.DaoFactory;

public class CalculoSomaDaoTeste {
    public static void main(String[] args) throws DBException {
        CalculosDao dao = DaoFactory.getCalculosDao();

        dao.totalDespesa(3);
        dao.totalReceita(4);
    }
}
