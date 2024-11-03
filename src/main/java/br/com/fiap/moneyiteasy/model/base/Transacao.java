package br.com.fiap.moneyiteasy.model.base;

import br.com.fiap.moneyiteasy.model.Categoria;

import java.time.LocalDate;

public abstract class Transacao {
    private int idTransacao;
    private double valor;
    private LocalDate date;
    private Categoria categoria;

    public Transacao() {
    }

    public Transacao(int idTransacao, double valor, LocalDate date, Categoria categoria) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.date = date;
        this.categoria = categoria;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public abstract String getTipoTransacao();
}
