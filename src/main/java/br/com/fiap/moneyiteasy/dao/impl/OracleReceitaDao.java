package br.com.fiap.moneyiteasy.dao.impl;

import br.com.fiap.moneyiteasy.dao.ConnectionManager;
import br.com.fiap.moneyiteasy.dao.interfaces.ReceitaDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.model.Categoria;
import br.com.fiap.moneyiteasy.model.Receita;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OracleReceitaDao implements ReceitaDao {

    private Connection conexao;

    @Override
    public void cadastraReceita(Receita receita, int idUser) throws DBException {

        PreparedStatement stmt = null;
        conexao = ConnectionManager.getInstance().getConnection();

        String sql = "INSERT INTO TB_RECEITA" +
        "(ID_RECEITA, VALOR_RECEITA, DT_RECEITA, ID_USUARIO, ID_CATEGORIA) " +
        "VALUES (SQ_TB_RECEITA.NEXTVAL, ?, ?, ?, ?)";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, receita.getValor());
            stmt.setDate(2, Date.valueOf(receita.getDate()));
            stmt.setInt(3, idUser);
            System.out.println(receita.getCategoria().getCodigo());
            stmt.setInt(4, receita.getCategoria().getCodigo());
            stmt.executeUpdate();
            System.out.println("Receita cadastrada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar TbUsuario receita");
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
    public void atualizaReceita(Receita receita) throws DBException {
        PreparedStatement stmt = null;
        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "UPDATE TB_RECEITA SET VALOR_RECEITA = ?, ID_CATEGORIA = ?, DT_RECEITA = ? WHERE ID_RECEITA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, receita.getValor());
            stmt.setInt(2, receita.getCategoria().getCodigo());
            stmt.setDate(3, Date.valueOf(receita.getDate()));
            stmt.setInt(4, receita.getIdTransacao());
            stmt.executeUpdate();
            System.out.println("Receita atualizada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar receita");
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
    public void removerReceita(int codigo) throws DBException {
        PreparedStatement stmt = null;

        try{
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "DELETE FROM TB_RECEITA WHERE ID_RECEITA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
            System.out.println("Receita removida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao removerUsuario receita");
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
    public Receita buscar(int codigo, int idUser) throws DBException {
        Receita receita = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "SELECT * FROM TB_RECEITA INNER JOIN TB_CATEGORIA_FINTECH ON (TB_RECEITA.ID_CATEGORIA = TB_CATEGORIA_FINTECH.ID_CATEGORIA)" +
                    "WHERE ID_RECEITA = ? AND ID_USUARIO = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.setInt(2, idUser);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("ID_RECEITA");
                double valor = rs.getDouble("VALOR_RECEITA");
                LocalDate date = rs.getDate("DT_RECEITA").toLocalDate();
                int categoriaId = rs.getInt("ID_CATEGORIA");
                int usuarioId = rs.getInt("ID_USUARIO");
                String nomeCategoria = rs.getString("NOME_CATEGORIA");
                String tipoCategoria = rs.getString("TIPO");
                Categoria categoria = new Categoria(categoriaId, nomeCategoria, tipoCategoria);
                receita = new Receita(id, valor, date, categoria);
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
        return receita;
    }

    @Override
    public List<Receita> listaReceita(int idUser) throws DBException {
        List<Receita> listaReceita = new ArrayList<Receita>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM TB_RECEITA " +
                    "INNER JOIN TB_CATEGORIA_FINTECH ON (TB_RECEITA.ID_CATEGORIA = TB_CATEGORIA_FINTECH.ID_CATEGORIA) " +
                    "WHERE ID_USUARIO = ? " +
                    "ORDER BY DT_RECEITA DESC";

            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idUser);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_RECEITA");
                double valor = rs.getDouble("VALOR_RECEITA");
                LocalDate data = rs.getDate("DT_RECEITA").toLocalDate();
                int idCategoria = rs.getInt("ID_CATEGORIA");
                String nomeCategoria = rs.getString("NOME_CATEGORIA");
                String tipoCategoria = rs.getString("TIPO");
                Categoria categoria = new Categoria(idCategoria, nomeCategoria, tipoCategoria);
                Receita receita = new Receita(id, valor, data, categoria);
                listaReceita.add(receita);
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
        return listaReceita;
    }
}
