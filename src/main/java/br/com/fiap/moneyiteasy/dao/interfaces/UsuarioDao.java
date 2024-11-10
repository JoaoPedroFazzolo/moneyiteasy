package br.com.fiap.moneyiteasy.dao.interfaces;

import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.model.Usuario;

public interface UsuarioDao {
    void cadastrar(Usuario usuario) throws DBException;
    void atualizar(Usuario usuario) throws DBException;
    void remover(int codigo) throws DBException;
    Usuario buscarUsuario(String email) throws DBException;
}
