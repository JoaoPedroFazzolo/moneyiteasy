package br.com.fiap.moneyiteasy.dao.interfaces;

import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.model.Receita;

import java.util.List;

public interface ReceitaDao {
    void cadastraReceita(Receita receita, int idUser) throws DBException;
    void atualizaReceita(Receita receita) throws DBException;
    void removerReceita(int codigo) throws DBException;
    Receita buscar(int codigo, int idUser) throws DBException;
    List<Receita> listaReceita(int idUser) throws DBException;
}
