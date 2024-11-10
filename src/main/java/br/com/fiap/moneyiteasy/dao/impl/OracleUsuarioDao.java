package br.com.fiap.moneyiteasy.dao.impl;

import br.com.fiap.moneyiteasy.dao.ConnectionManager;
import br.com.fiap.moneyiteasy.dao.interfaces.UsuarioDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.model.Login;
import br.com.fiap.moneyiteasy.model.Usuario;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class OracleUsuarioDao implements UsuarioDao {

    private Connection conexao;

    @Override
    public void cadastrar(Usuario usuario) throws DBException {
        PreparedStatement stmt = null;

        conexao = ConnectionManager.getInstance().getConnection();


        String sql = "INSERT INTO TB_USUARIO (ID_USUARIO, NOME_USUARIO, NR_CPF, CRIACAO_USER, DS_EMAIL)" +
                "VALUES (SQ_TB_USUARIO.NEXTVAL, ?, ?, ?, ?)";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setDate(3, Date.valueOf(usuario.getDateCriacaoUser()));
            stmt.setString(4, usuario.getLogin().getEmail());
            stmt.executeUpdate();
            System.out.println("Usuario cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar usuario");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void atualizar(Usuario usuario) throws DBException {
        PreparedStatement stmt = null;
        try{
            conexao = ConnectionManager.getInstance().getConnection();
            String sqlUsuario = "UPDATE TB_USUARIO SET NOME_USUARIO = ? WHERE ID_USUARIO = ?";
            stmt = conexao.prepareStatement(sqlUsuario);
            stmt.setString(1, usuario.getNome());
            stmt.executeUpdate();

            String sqlLogin = "UPDATE TB_LOGIN SET DS_SENHA = ? WHERE DS_EMAIL = ?";
            stmt = conexao.prepareStatement(sqlLogin);
            stmt.setString(1, usuario.getLogin().getSenha());
            stmt.executeUpdate();

            System.out.println("Usuario atualizado com sucesso!");
        } catch (SQLException e) {
           e.printStackTrace();
            throw new DBException("Erro ao atualizar usuario");
        } finally {
            try{
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void remover(int codigo) throws DBException {
        PreparedStatement stmt = null;
        try{
            conexao = ConnectionManager.getInstance().getConnection();
            String sqlLogin  = "DELETE FROM TB_LOGIN WHERE DS_EMAIL = (SELECT DS_EMAIL FROM TB_USUARIO WHERE ID_USUARIO = ?)";
            stmt = conexao.prepareStatement(sqlLogin );
            stmt.setInt(1, codigo);
            stmt.executeUpdate();

            String sqlUsuario = "DELETE FROM TB_USUARIO WHERE ID_USUARIO = ?";
            stmt = conexao.prepareStatement(sqlUsuario);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();

            System.out.println("Usuario e dados de login removidos com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao remover usuario");
        }finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Usuario buscarUsuario(String email) throws DBException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        Login login = new Login();
        try{
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM TB_USUARIO WHERE DS_EMAIL = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            if(rs.next()){
                int id = rs.getInt("ID_USUARIO");
                String nome = rs.getString("NOME_USUARIO");
                String cpf = rs.getString("NR_CPF");
                LocalDate data = rs.getDate("CRIACAO_USER").toLocalDate();
                String emailBd = rs.getString("DS_EMAIL");
                login.setEmail(emailBd);
                usuario = new Usuario(id, nome, cpf, data, login);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                stmt.close();
                rs.close();
                conexao.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return usuario;
    }
}
