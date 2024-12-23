package br.com.fiap.moneyiteasy.model;

import br.com.fiap.moneyiteasy.util.CriptografiaUtils;

public class Login {
    private String email;
    private String senha;

    public Login() {
    }

    public Login(String email, String senha) {
        this.email = email;
        try {
            this.senha = CriptografiaUtils.criptografar(senha);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        try {
            this.senha = CriptografiaUtils.criptografar(senha);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
