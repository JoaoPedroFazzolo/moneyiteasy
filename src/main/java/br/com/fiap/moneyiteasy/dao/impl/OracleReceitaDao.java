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
    public void cadastraReceita(Receita receita) throws DBException {

        PreparedStatement stmt = null;
        conexao = ConnectionManager.getInstance().getConnection();

        String sql = "INSERT INTO TB_RECEITA" +
        "(ID_RECEITA, VALOR_RECEITA, DT_RECEITA, ID_USUARIO, ID_CATEGORIA) " +
        "VALUES (SQ_TB_RECEITA.NEXTVAL, ?, ?, ?, ?)";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, receita.getValor());
            stmt.setDate(2, Date.valueOf(receita.getDate()));
            stmt.setInt(3, 3);
            stmt.setInt(4, receita.getCategoria().getCodigo());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar receita");
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
            stmt.setDate(2, Date.valueOf(receita.getDate()));
            stmt.setInt(3, receita.getCategoria().getCodigo());
            stmt.setInt(4, receita.getIdTransacao());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar receita");
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
    public void removerReceita(int codigo) throws DBException {

    }

    @Override
    public Receita buscar(int codigo) throws DBException {
        return null;
    }

    @Override
    public List<Receita> listaReceita() throws DBException {
        List<Receita> listaReceita = new ArrayList<Receita>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM TB_RECEITA " +
                    "INNER JOIN TB_CATEGORIA_FINTECH ON (TB_RECEITA.ID_CATEGORIA = TB_CATEGORIA_FINTECH.ID_CATEGORIA)";

            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_RECEITA");
                double valor = rs.getInt("VALOR_RECEITA");
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
