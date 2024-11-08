package br.com.fiap.moneyiteasy.dao.interfaces;

import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.model.Usuario;

import java.util.List;

public interface UsuarioDao {
    void cadastrar(Usuario usuario) throws DBException;
    void atualizar(Usuario usuario) throws DBException;
    void remover(int codigo) throws DBException;
    Usuario buscarNomeUsuario(String email) throws DBException;
}
