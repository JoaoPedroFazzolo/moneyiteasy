package br.com.fiap.moneyiteasy.model;

import br.com.fiap.moneyiteasy.model.base.Transacao;

import java.time.LocalDate;

public class Receita extends Transacao {
    public Receita() {
    }

    public Receita(int idTransacao, double valor, LocalDate date, Categoria categoria) {
        super(idTransacao, valor, date, categoria);
    }


    @Override
    public String getTipoTransacao() {
        return "RECEITA";
    }
}
