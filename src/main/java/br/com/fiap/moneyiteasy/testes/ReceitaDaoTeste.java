package br.com.fiap.moneyiteasy.testes;

import br.com.fiap.moneyiteasy.dao.interfaces.ReceitaDao;
import br.com.fiap.moneyiteasy.exception.DBException;
import br.com.fiap.moneyiteasy.factory.DaoFactory;
import br.com.fiap.moneyiteasy.model.Receita;

import java.util.List;

public class ReceitaDaoTeste {
    public static void main(String[] args) throws DBException {
        ReceitaDao dao = DaoFactory.getReceitaDao();

        List<Receita> receitas = dao.listaReceita();
        for (Receita receita : receitas) {
            System.out.println(receita.getIdTransacao() + " " + receita.getDate() + " " + receita.getValor());
            System.out.println(receita.getTipoTransacao() + " "+ receita.getCategoria().getNome() + " " + receita.getCategoria().getCodigo());
        }


    }
}
