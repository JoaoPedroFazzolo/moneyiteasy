package br.com.fiap.moneyiteasy.dao.interfaces;

import br.com.fiap.moneyiteasy.exception.DBException;

public interface CalculosDao {
    double totalDespesa() throws DBException;

    double totalReceita() throws DBException;
}
