package br.com.fiap.moneyiteasy.dao.impl;

import br.com.fiap.moneyiteasy.dao.ConnectionManager;
import br.com.fiap.moneyiteasy.dao.interfaces.DespesaDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.model.Categoria;
import br.com.fiap.moneyiteasy.model.Despesa;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OracleDespesaDao implements DespesaDao {

    private Connection conexao;

    @Override
    public void cadastraDespesa(Despesa despesa, int idUser) throws DBException {
        PreparedStatement stmt = null;
        conexao = ConnectionManager.getInstance().getConnection();

        String sql = "INSERT INTO TB_DESPESA" +
                "(ID_DESPESA, VALOR_DESPESA, DT_DESPESA, ID_USUARIO, ID_CATEGORIA) " +
                "VALUES (SQ_TB_DESPESA.NEXTVAL, ?, ?, ?, ?)";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, despesa.getValor());
            stmt.setDate(2, Date.valueOf(despesa.getDate()));
            stmt.setInt(3, idUser);
            stmt.setInt(4, despesa.getCategoria().getCodigo());
            stmt.executeUpdate();
            System.out.println("Despesa cadastrada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrarTbUsuario despesa");
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
    public void atualizaDespesa(Despesa despesa) throws DBException {
        PreparedStatement stmt = null;
        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "UPDATE TB_DESPESA SET VALOR_DESPESA = ?, ID_CATEGORIA = ?, DT_DESPESA = ? WHERE ID_DESPESA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, despesa.getValor());
            stmt.setInt(2, despesa.getCategoria().getCodigo());
            stmt.setDate(3, Date.valueOf(despesa.getDate()));
            stmt.setInt(4, despesa.getIdTransacao());
            stmt.executeUpdate();
            System.out.println("Despesa atualizada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar despesa");
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
    public void removerDespesa(int codigo) throws DBException {
        PreparedStatement stmt = null;

        try{
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM TB_DESPESA WHERE ID_DESPESA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
            System.out.println("Despesa removida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao removerUsuario despesa");
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
    public Despesa buscar(int codigo, int idUser) throws DBException {
        Despesa despesa = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM TB_DESPESA INNER JOIN TB_CATEGORIA_FINTECH ON (TB_DESPESA.ID_CATEGORIA = TB_CATEGORIA_FINTECH.ID_CATEGORIA)" +
                    "WHERE ID_DESPESA = ? AND ID_USUARIO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.setInt(2, idUser);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("ID_DESPESA");
                double valor = rs.getDouble("VALOR_DESPESA");
                LocalDate date = rs.getDate("DT_DESPESA").toLocalDate();
                int categoriaId = rs.getInt("ID_CATEGORIA");
                int usuarioId = rs.getInt("ID_USUARIO");
                String nomeCategoria = rs.getString("NOME_CATEGORIA");
                String tipoCategoria = rs.getString("TIPO");
                Categoria categoria = new Categoria(categoriaId, nomeCategoria, tipoCategoria);
                despesa = new Despesa(id, valor, date, categoria);
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
        return despesa;
    }

    @Override
    public List<Despesa> listaDespesa(int idUser) throws DBException {
        List<Despesa> listaDespesa = new ArrayList<Despesa>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM TB_DESPESA " +
                    "INNER JOIN TB_CATEGORIA_FINTECH ON (TB_DESPESA.ID_CATEGORIA = TB_CATEGORIA_FINTECH.ID_CATEGORIA) " +
                    "WHERE ID_USUARIO = ? " +
                    "ORDER BY DT_DESPESA DESC";

            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idUser);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_DESPESA");
                double valor = rs.getInt("VALOR_DESPESA");
                LocalDate data = rs.getDate("DT_DESPESA").toLocalDate();
                int idCategoria = rs.getInt("ID_CATEGORIA");
                String nomeCategoria = rs.getString("NOME_CATEGORIA");
                String tipoCategoria = rs.getString("TIPO");
                Categoria categoria = new Categoria(idCategoria, nomeCategoria, tipoCategoria);
                Despesa despesa = new Despesa(id, valor, data, categoria);
                listaDespesa.add(despesa);
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
        return listaDespesa;
    }
}
