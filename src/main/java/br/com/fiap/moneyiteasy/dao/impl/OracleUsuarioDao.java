package br.com.fiap.moneyiteasy.dao.impl;

import br.com.fiap.moneyiteasy.dao.interfaces.UsuarioDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.model.Usuario;

import java.sql.Connection;
import java.util.List;

public class OracleUsuarioDao implements UsuarioDao {

    private Connection conexao;

    @Override
    public void cadastrar(Usuario usuario) throws DBException {


    }

    @Override
    public void atualizar(Usuario usuario) throws DBException {

    }

    @Override
    public void remover(int codigo) throws DBException {

    }

    @Override
    public Usuario buscar(int codigo) throws DBException {
        return null;
    }

    @Override
    public List<Usuario> listar() throws DBException {
        return List.of();
    }
}
