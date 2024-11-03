package br.com.fiap.moneyiteasy.model;

import br.com.fiap.moneyiteasy.model.base.Transacao;

import java.time.LocalDate;

public class Despesa extends Transacao {
    public Despesa() {
    }

    public Despesa(int idTransacao, double valor, LocalDate date, Categoria categoria) {
        super(idTransacao, valor, date, categoria);
    }

    @Override
    public String getTipoTransacao() {
        return "Despesa";
    }
}
