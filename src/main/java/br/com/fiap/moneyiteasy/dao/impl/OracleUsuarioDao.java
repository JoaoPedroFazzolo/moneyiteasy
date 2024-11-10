package br.com.fiap.moneyiteasy.dao.impl;

import br.com.fiap.moneyiteasy.dao.ConnectionManager;
import br.com.fiap.moneyiteasy.dao.interfaces.UsuarioDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.model.Login;
import br.com.fiap.moneyiteasy.model.Usuario;

import java.sql.*;
import java.time.LocalDate;

public class OracleUsuarioDao implements UsuarioDao {

    @Override
    public void cadastrar(Usuario usuario) throws DBException {
        String sql = "INSERT INTO TB_USUARIO (ID_USUARIO, NOME_USUARIO, NR_CPF, CRIACAO_USER, DS_EMAIL) " +
                "VALUES (SQ_TB_DESPESA.NEXTVAL, ?, ?, ?, ?)";

        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setDate(3, Date.valueOf(usuario.getDateCriacaoUser()));
            stmt.setString(4, usuario.getLogin().getEmail());
            stmt.executeUpdate();

            System.out.println("Usuario cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar usuario", e);
        }
    }

    @Override
    public void atualizar(Usuario usuario) throws DBException {
        String sqlUsuario = "UPDATE TB_USUARIO SET NOME_USUARIO = ? WHERE ID_USUARIO = ?";
        String sqlLogin = "UPDATE TB_LOGIN SET DS_SENHA = ? WHERE DS_EMAIL = ?";

        try (Connection conexao = ConnectionManager.getInstance().getConnection()) {

            // Atualizar usuário
            try (PreparedStatement stmtUsuario = conexao.prepareStatement(sqlUsuario)) {
                stmtUsuario.setString(1, usuario.getNome());
                stmtUsuario.setInt(2, usuario.getIdUsuario());
                stmtUsuario.executeUpdate();
            }

            // Atualizar login
            try (PreparedStatement stmtLogin = conexao.prepareStatement(sqlLogin)) {
                stmtLogin.setString(1, usuario.getLogin().getSenha());
                stmtLogin.setString(2, usuario.getLogin().getEmail());
                stmtLogin.executeUpdate();
            }

            System.out.println("Usuario atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar usuario", e);
        }
    }

    @Override
    public void remover(int codigo) throws DBException {
        String sqlLogin = "DELETE FROM TB_LOGIN WHERE DS_EMAIL = (SELECT DS_EMAIL FROM TB_USUARIO WHERE ID_USUARIO = ?)";
        String sqlUsuario = "DELETE FROM TB_USUARIO WHERE ID_USUARIO = ?";

        try (Connection conexao = ConnectionManager.getInstance().getConnection()) {

            // Remover login
            try (PreparedStatement stmtLogin = conexao.prepareStatement(sqlLogin)) {
                stmtLogin.setInt(1, codigo);
                stmtLogin.executeUpdate();
            }

            // Remover usuário
            try (PreparedStatement stmtUsuario = conexao.prepareStatement(sqlUsuario)) {
                stmtUsuario.setInt(1, codigo);
                stmtUsuario.executeUpdate();
            }

            System.out.println("Usuario e dados de login removidos com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao remover usuario", e);
        }
    }

    @Override
    public Usuario buscarUsuario(String email) throws DBException {
        String sql = "SELECT * FROM TB_USUARIO WHERE DS_EMAIL = ?";
        Usuario usuario = null;

        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("ID_USUARIO");
                    String nome = rs.getString("NOME_USUARIO");
                    String cpf = rs.getString("NR_CPF");
                    LocalDate data = rs.getDate("CRIACAO_USER").toLocalDate();

                    Login login = new Login();
                    login.setEmail(email);

                    usuario = new Usuario(id, nome, cpf, data, login);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao buscar usuario", e);
        }
        return usuario;
    }

    @Override
    public Usuario buscarUsuarioPorId(int idUsuario) throws DBException {
        String sql = "SELECT * FROM TB_USUARIO WHERE ID_USUARIO = ?";
        Usuario usuario = null;

        try (Connection conexao = ConnectionManager.getInstance().getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nome = rs.getString("NOME_USUARIO");
                    String cpf = rs.getString("NR_CPF");
                    LocalDate data = rs.getDate("CRIACAO_USER").toLocalDate();
                    String email = rs.getString("DS_EMAIL");

                    Login login = new Login();
                    login.setEmail(email);

                    usuario = new Usuario(idUsuario, nome, cpf, data, login);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao buscar usuario", e);
        }
        return usuario;
    }
}