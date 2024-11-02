package br.com.fiap.moneyiteasy.testes;

import br.com.fiap.moneyiteasy.util.CriptografiaUtils;

public class CriptografiaTeste {
    public static void main(String[] args) {
        try{
            System.out.println(CriptografiaUtils.criptografar("123456"));
            System.out.println(CriptografiaUtils.criptografar("123456"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
