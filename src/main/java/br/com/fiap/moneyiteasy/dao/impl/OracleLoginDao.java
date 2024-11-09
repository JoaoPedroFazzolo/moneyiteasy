package br.com.fiap.moneyiteasy.dao.impl;
import br.com.fiap.moneyiteasy.dao.ConnectionManager;
import br.com.fiap.moneyiteasy.dao.interfaces.LoginDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.model.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleLoginDao implements LoginDao {

    private Connection conexao;

    @Override
    public boolean validarLogin(Login login) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conexao = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM TB_LOGIN WHERE DS_EMAIL = ? and DS_SENHA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, login.getEmail());
            stmt.setString(2, login.getSenha());
            rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public void cadastrarLogin(Login login) throws DBException {

        PreparedStatement stmt = null;
        conexao = ConnectionManager.getInstance().getConnection();

        String sql = "INSERT INTO TB_LOGIN" +
                "(DS_EMAIL, DS_SENHA) VALUES (?,?)";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, login.getEmail());
            stmt.setString(2, login.getSenha());
            stmt.executeUpdate();
            System.out.println("Login cadastrado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar o login.");
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
