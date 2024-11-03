package br.com.fiap.moneyiteasy.dao.impl;

import br.com.fiap.moneyiteasy.dao.ConnectionManager;
import br.com.fiap.moneyiteasy.dao.interfaces.InvestimentoDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.model.Categoria;
import br.com.fiap.moneyiteasy.model.Investimento;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OracleInvestimentoDao implements InvestimentoDao {
    private Connection conexao;

    @Override
    public void cadastraInvestimento(Investimento investimento) throws DBException {
        PreparedStatement stmt = null;
        conexao = ConnectionManager.getInstance().getConnection();

        String sql = "INSERT INTO TB_INVESTIMENTO" +
                "(ID_INVESTIMENTO, VALOR_INVESTIMENTO, DT_INVESTIMENTO, ID_USUARIO, ID_CATEGORIA) " +
                "VALUES (SQ_TB_INVESTIMENTO.NEXTVAL, ?, ?, ?, ?)";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, investimento.getValor());
            stmt.setDate(2, Date.valueOf(investimento.getDate()));
            stmt.setInt(3, 3);
            stmt.setInt(4, investimento.getCategoria().getCodigo());
            stmt.executeUpdate();
            System.out.println("Investimento cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar investimento");
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
    public void atualizaInvestimento(Investimento investimento) throws DBException {
        PreparedStatement stmt = null;
        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "UPDATE TB_INVESTIMENTO SET VALOR_INVESTIMENTO = ?, ID_CATEGORIA = ?, DT_INVESTIMENTO = ? WHERE ID_INVESTIMENTO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, investimento.getValor());
            stmt.setDate(2, Date.valueOf(investimento.getDate()));
            stmt.setInt(3, investimento.getCategoria().getCodigo());
            stmt.setInt(4, investimento.getIdTransacao());
            stmt.executeUpdate();
            System.out.println("Investimento atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar investimento");
        } finally {
            try{
                stmt.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void removerInvestimento(int codigo) throws DBException {
        PreparedStatement stmt = null;

        try{
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM TB_INVESTIMENTO WHERE ID_INVESTIMENTO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
            System.out.println("Investimento removida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao remover investimento");
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
    public Investimento buscar(int codigo) throws DBException {
        Investimento investimento = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM TB_INVESTIMENTO INNER JOIN TB_CATEGORIA_FINTECH ON (TB_INVESTIMENTO.ID_CATEGORIA = TB_CATEGORIA_FINTECH.ID_CATEGORIA)" +
                    "WHERE ID_INVESTIMENTO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("ID_INVESTIMENTO");
                double valor = rs.getDouble("VALOR_INVESTIMENTO");
                LocalDate date = rs.getDate("DT_INVESTIMENTO").toLocalDate();
                int categoriaId = rs.getInt("ID_CATEGORIA");
                int usuarioId = rs.getInt("ID_USUARIO");
                String nomeCategoria = rs.getString("NOME_CATEGORIA");
                String tipoCategoria = rs.getString("TIPO_CATEGORIA");
                Categoria categoria = new Categoria(categoriaId, nomeCategoria, tipoCategoria);
                investimento = new Investimento(id, valor, date, categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                stmt.close();
                rs.close();
                conexao.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return investimento;
    }

    @Override
    public List<Investimento> listaInvestimento() throws DBException {
        List<Investimento> listaInvestimento = new ArrayList<Investimento>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM TB_INVESTIMENTO " +
                    "INNER JOIN TB_CATEGORIA_FINTECH ON (TB_INVESTIMENTO.ID_CATEGORIA = TB_CATEGORIA_FINTECH.ID_CATEGORIA)";

            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_INVESTIMENTO");
                double valor = rs.getInt("VALOR_INVESTIMENTO");
                LocalDate data = rs.getDate("DT_INVESTIMENTO").toLocalDate();
                int idCategoria = rs.getInt("ID_CATEGORIA");
                String nomeCategoria = rs.getString("NOME_CATEGORIA");
                String tipoCategoria = rs.getString("TIPO");
                Categoria categoria = new Categoria(idCategoria, nomeCategoria, tipoCategoria);
                Investimento investimento = new Investimento(id, valor, data, categoria);
                listaInvestimento.add(investimento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                stmt.close();
                rs.close();
                conexao.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaInvestimento;
    }
}
