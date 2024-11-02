package br.com.fiap.moneyiteasy.model;

import java.time.LocalDate;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String cpf;
    LocalDate dateCriacaoUser;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nome, String cpf, LocalDate dateCriacaoUser) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.dateCriacaoUser = dateCriacaoUser;
    }

    public int getId() {
        return idUsuario;
    }

    public void setId(int id) {
        this.idUsuario = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDateCriacaoUser() {
        return dateCriacaoUser;
    }

    public void setDateCriacaoUser(LocalDate dateCriacaoUser) {
        this.dateCriacaoUser = dateCriacaoUser;
    }
}
