package br.com.fiap.moneyiteasy.dao.interfaces;

import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.model.Receita;
import br.com.fiap.moneyiteasy.model.Usuario;

import java.util.List;

public interface ReceitaDao {
    void cadastraReceita(Receita receita) throws DBException;
    void atualizaReceita(Receita receita) throws DBException;
    void removerReceita(int codigo) throws DBException;
    Receita buscar(int codigo) throws DBException;
    List<Receita> listaReceita() throws DBException;
}
