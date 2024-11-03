package br.com.fiap.moneyiteasy.dao.interfaces;

import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.model.Investimento;

import java.util.List;

public interface InvestimentoDao {
    void cadastraInvestimento(Investimento investimento) throws DBException;
    void atualizaInvestimento(Investimento investimento) throws DBException;
    void removerInvestimento(int codigo) throws DBException;
    Investimento buscar(int codigo) throws DBException;
    List<Investimento> listaInvestimento() throws DBException;
}
