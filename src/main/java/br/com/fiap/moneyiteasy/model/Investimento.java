package br.com.fiap.moneyiteasy.model;

import br.com.fiap.moneyiteasy.model.base.Categoria;
import br.com.fiap.moneyiteasy.model.base.Transacao;

import java.time.LocalDate;

public class Investimento extends Transacao {
    public Investimento() {
    }

    public Investimento(int idTransacao, double valor, LocalDate date, Categoria categoria) {
        super(idTransacao, valor, date, categoria);
    }

    @Override
    public String getTipoTransacao() {
        return "Investimento";
    }
}
