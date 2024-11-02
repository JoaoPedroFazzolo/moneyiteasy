package br.com.fiap.moneyiteasy.dao.impl;

import br.com.fiap.moneyiteasy.dao.InvestimentoDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.model.Investimento;

import java.util.List;

public class OracleInvestimentoDao implements InvestimentoDao {

    @Override
    public void cadastraInvestimento(Investimento investimento) throws DBException {
        
    }

    @Override
    public void atualizaInvestimento(Investimento investimento) throws DBException {

    }

    @Override
    public void removerInvestimento(int codigo) throws DBException {

    }

    @Override
    public Investimento buscar(int codigo) throws DBException {
        return null;
    }

    @Override
    public List<Investimento> listaInvestimento() throws DBException {
        return List.of();
    }
}
