package br.com.fiap.moneyiteasy.dao.interfaces;

import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.model.Usuario;

public interface UsuarioDao {
    void cadastrarTbUsuario(Usuario usuario) throws DBException;
    void atualizar(Usuario usuario) throws DBException;
    void removerUsuario(Usuario usuario) throws DBException;
    Usuario buscarUsuario(String email) throws DBException;
}
