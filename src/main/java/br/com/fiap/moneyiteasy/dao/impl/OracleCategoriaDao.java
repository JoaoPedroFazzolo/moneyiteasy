package br.com.fiap.moneyiteasy.dao.impl;

import br.com.fiap.moneyiteasy.dao.CategoriaDao;
import br.com.fiap.moneyiteasy.model.base.Categoria;

import java.sql.Connection;
import java.util.List;

public class OracleCategoriaDao implements CategoriaDao {
    private Connection conexao;
    @Override
    public List<Categoria> listar() {
        return List.of();
    }
}
