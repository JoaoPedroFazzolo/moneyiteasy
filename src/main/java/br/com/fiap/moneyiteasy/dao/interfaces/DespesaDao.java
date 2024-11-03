package br.com.fiap.moneyiteasy.dao.interfaces;

import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.model.Despesa;

import java.util.List;

public interface DespesaDao {
    void cadastraDespesa(Despesa despesa) throws DBException;
    void atualizaDespesa(Despesa despesa) throws DBException;
    void removerDespesa(int codigo) throws DBException;
    Despesa buscar(int codigo) throws DBException;
    List<Despesa> listaDespesas() throws DBException;
}
