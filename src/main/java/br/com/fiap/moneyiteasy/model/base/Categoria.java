package br.com.fiap.moneyiteasy.model.base;

public abstract class Categoria {
    private int id;
    private String nome;
    private TipoCategoria tipo;

    public enum TipoCategoria {
        DESPESA,
        RECEITA,
        INVESTIMENTO
    }

    public Categoria() {
    }

    public Categoria(int id, String nome, TipoCategoria tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCategoria getTipo() {
        return tipo;
    }

    public void setTipo(TipoCategoria tipo) {
        this.tipo = tipo;
    }
}
