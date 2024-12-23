package br.com.fiap.moneyiteasy.dao.impl;

import br.com.fiap.moneyiteasy.dao.ConnectionManager;
import br.com.fiap.moneyiteasy.dao.interfaces.CategoriaDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleCategoriaDao implements CategoriaDao {
    private Connection conexao;

    @Override
    public void cadastrarCategoria(Categoria categoria) throws DBException {
        PreparedStatement stmt = null;
        try{
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "INSERT INTO TB_CATEGORIA_FINTECH (ID_CATEGORIA, NOME_CATEGORIA, TIPO) VALUES (SQ_TB_CATEGORIA_FINTECH.nextval, ?, ?)";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, categoria.getNome().toLowerCase());
            stmt.setString(2, categoria.getTipo().toUpperCase());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao cadastrarTbUsuario categoria");
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
    public void editarCategoria(Categoria categoria) throws DBException {
        PreparedStatement stmt = null;
        try {
            conexao = ConnectionManager.getInstance().getConnection();
            String sql = "UPDATE TB_CATEGORIA_FINTECH SET NOME_CATEGORIA = ?, TIPO = ? WHERE ID_CATEGORIA = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, categoria.getNome().toLowerCase());
            stmt.setString(2, categoria.getTipo().toUpperCase());
            stmt.setInt(3, categoria.getCodigo());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new DBException("Categoria não encontrada ou não foi possível atualizar.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Erro ao atualizar categoria.");
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    public List<Categoria> listar(String tipo) {
        List<Categoria> lista = new ArrayList<Categoria>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conexao = ConnectionManager.getInstance().getConnection();
            stmt = conexao.prepareStatement("SELECT * FROM TB_CATEGORIA_FINTECH WHERE TIPO = ?");
            stmt.setString(1, tipo.toUpperCase());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("ID_CATEGORIA");
                String nome = rs.getString("NOME_CATEGORIA");
                String tipoCategoria = rs.getString("TIPO");
                Categoria categoria = new Categoria(codigo, nome, tipoCategoria);
                lista.add(categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;

    }


}
