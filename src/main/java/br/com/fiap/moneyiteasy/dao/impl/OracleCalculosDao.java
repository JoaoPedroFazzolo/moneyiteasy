package br.com.fiap.moneyiteasy.dao.impl;

import br.com.fiap.moneyiteasy.dao.ConnectionManager;
import br.com.fiap.moneyiteasy.dao.interfaces.CalculosDao;
import br.com.fiap.moneyiteasy.exception.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleCalculosDao implements CalculosDao {
    private Connection conexao;
    @Override
    public double totalDespesa(int idUser) throws DBException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double totalDespesa = 0;
        try{
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT SUM(VALOR_DESPESA) FROM TB_DESPESA WHERE ID_USUARIO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idUser);
            rs = stmt.executeQuery();
            if (rs.next()) {
                totalDespesa = rs.getDouble(1); // Obtém o valor da primeira coluna
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return totalDespesa;
    }

    @Override
    public double totalReceita(int idUser) throws DBException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double totalReceita = 0;
        try{
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT SUM(VALOR_RECEITA) FROM TB_RECEITA WHERE ID_USUARIO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idUser);
            rs = stmt.executeQuery();
            if (rs.next()) {
                totalReceita = rs.getDouble(1); // Obtém o valor da primeira coluna
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return totalReceita;
    }
}
