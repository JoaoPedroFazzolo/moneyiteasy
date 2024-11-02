package br.com.fiap.moneyiteasy.model;

import br.com.fiap.moneyiteasy.model.base.Transacao;

import java.time.LocalDate;

public class Receita extends Transacao {
    public Receita() {
    }

    public Receita(int idTrasnsacao, double valor, LocalDate date) {
        super(idTrasnsacao, valor, date);
    }


    @Override
    public String getTipoTransacao() {
        return "Receita";
    }
}
