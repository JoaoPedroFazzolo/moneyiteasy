package br.com.fiap.moneyiteasy.model.base;

import java.time.LocalDate;

public abstract class Transacao {
    private int idTransacao;
    private double valor;
    private LocalDate date;

    public Transacao() {
    }

    public Transacao(int idTransacao, double valor, LocalDate date) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.date = date;
    }

    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public abstract String getTipoTransacao();
}
