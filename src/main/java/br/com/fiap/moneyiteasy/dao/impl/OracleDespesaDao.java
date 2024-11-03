package br.com.fiap.moneyiteasy.dao.impl;

import br.com.fiap.moneyiteasy.dao.interfaces.DespesaDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.model.Despesa;

import java.util.List;

public class OracleDespesaDao implements DespesaDao {
    @Override
    public void cadastraDespesa(Despesa despesa) throws DBException {

    }

    @Override
    public void atualizaDespesa(Despesa despesa) throws DBException {

    }

    @Override
    public void removerDespesa(int codigo) throws DBException {

    }

    @Override
    public Despesa buscar(int codigo) throws DBException {
        return null;
    }

    @Override
    public List<Despesa> listaDespesas() throws DBException {
        return List.of();
    }
}
