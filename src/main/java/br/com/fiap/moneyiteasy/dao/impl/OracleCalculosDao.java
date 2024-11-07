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
    public double totalDespesa() throws DBException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double totalDespesa = 0;
        try{
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT SUM(VALOR_DESPESA) FROM TB_DESPESA";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                totalDespesa = rs.getDouble(1); // Obtém o valor da primeira coluna
                System.out.println("Total das despesas: " + totalDespesa);
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
    public double totalReceita() throws DBException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double totalReceita = 0;
        try{
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT SUM(VALOR_RECEITA) FROM TB_RECEITA";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                totalReceita = rs.getDouble(1); // Obtém o valor da primeira coluna
                System.out.println("Total das receitas: " + totalReceita);
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
