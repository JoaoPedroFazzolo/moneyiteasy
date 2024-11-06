package br.com.fiap.moneyiteasy.dao.interfaces;

import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.model.Categoria;

import java.util.List;

public interface CategoriaDao {

    void cadastrarCategoria(Categoria categoria) throws DBException;

    void editarCategoria(Categoria categoria) throws DBException;

    List<Categoria> listar(String tipo) throws DBException;
}
