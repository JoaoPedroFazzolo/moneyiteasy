package br.com.fiap.moneyiteasy.model;

import br.com.fiap.moneyiteasy.model.base.Transacao;

import java.time.LocalDate;

public class Despesa extends Transacao {
    public Despesa() {
    }

    public Despesa(int idTransacao, double valor, LocalDate date) {
        super(idTransacao, valor, date);
    }

    @Override
    public String getTipoTransacao() {
        return "Despesa";
    }
}
