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
    public void cadastrarTbUsuario(Usuario usuario) throws DBException {
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
            throw new DBException("Erro ao cadastrarTbUsuario usuario");
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
            String sqlUsuario = "UPDATE TB_USUARIO SET NOME_USUARIO = ?, NR_CPF = ? WHERE ID_USUARIO = ?";
            stmt = conexao.prepareStatement(sqlUsuario);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setInt(3, usuario.getIdUsuario());
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
    public void removerUsuario(Usuario usuario) throws DBException {
        PreparedStatement stmt = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql1 = "DELETE FROM TB_RECEITA WHERE ID_USUARIO = ?";
            stmt = conexao.prepareStatement(sql1);
            System.out.println("sql1");
            stmt.setInt(1, usuario.getIdUsuario());
            stmt.executeUpdate();

            String sql2 = "DELETE FROM TB_DESPESA WHERE ID_USUARIO = ?";
            stmt = conexao.prepareStatement(sql2);
            System.out.println("sql2");
            stmt.setInt(1, usuario.getIdUsuario());
            stmt.executeUpdate();

            String sql3 = "DELETE FROM TB_USUARIO WHERE ID_USUARIO = ?";
            stmt = conexao.prepareStatement(sql3);
            System.out.println("sql3");
            stmt.setInt(1, usuario.getIdUsuario());
            stmt.executeUpdate();

            String sql4 = "DELETE FROM TB_LOGIN WHERE DS_EMAIL = ?";
            stmt = conexao.prepareStatement(sql4);
            System.out.println("sql4");
            stmt.setString(1, usuario.getLogin().getEmail());
            stmt.executeUpdate();

            System.out.println("Todos dados do usuario foram removidos com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao remover usuario");
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
