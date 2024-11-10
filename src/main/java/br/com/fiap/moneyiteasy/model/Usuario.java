package br.com.fiap.moneyiteasy.model;

import br.com.fiap.moneyiteasy.util.CriptografiaUtils;

import java.time.LocalDate;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String cpf;
    LocalDate dateCriacaoUser;
    private Login login;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nome, String cpf, LocalDate dateCriacaoUser, Login login) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.dateCriacaoUser = dateCriacaoUser;
        this.login = login;
    }

    public Usuario(int idUsuario, String nome, String cpf) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.cpf = cpf;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
