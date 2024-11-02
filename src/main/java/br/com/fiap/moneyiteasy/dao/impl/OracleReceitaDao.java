package br.com.fiap.moneyiteasy.dao.impl;

import br.com.fiap.moneyiteasy.dao.ReceitaDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.model.Receita;
import java.util.List;

public class OracleReceitaDao implements ReceitaDao {
    @Override
    public void cadastraReceita(Receita receita) throws DBException {

    }

    @Override
    public void atualizaReceita(Receita receita) throws DBException {

    }

    @Override
    public void removerReceita(int codigo) throws DBException {

    }

    @Override
    public Receita buscar(int codigo) throws DBException {
        return null;
    }

    @Override
    public List<Receita> listaReceita() throws DBException {
        return List.of();
    }
}
