package br.com.fiap.moneyiteasy.testes;

import br.com.fiap.moneyiteasy.dao.interfaces.CategoriaDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.factory.DaoFactory;
import br.com.fiap.moneyiteasy.model.Categoria;

import java.util.List;

public class CategoriaDaoTeste {

    public static void main(String[] args) throws DBException {
        CategoriaDao dao = DaoFactory.getCategoriaDao();

        List<Categoria> lista = dao.listar("receita");
        for (Categoria categorias : lista) {
            System.out.println(categorias.getCodigo() + " " + categorias.getNome());
        }
    }
}