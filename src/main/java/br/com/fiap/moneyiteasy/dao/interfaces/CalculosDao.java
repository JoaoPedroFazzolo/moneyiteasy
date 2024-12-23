package br.com.fiap.moneyiteasy.dao.interfaces;

import br.com.fiap.moneyiteasy.exception.DBException;

public interface CalculosDao {
    double totalDespesa(int idUser) throws DBException;

    double totalReceita(int idUser) throws DBException;
}
