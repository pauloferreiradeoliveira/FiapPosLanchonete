package br.com.lanchonete.core.domain.entities;

public class Cliente {
    private String nome;
    private String email;
    private String cpf;


    public Cliente(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf.replaceAll("[-.]", "").trim();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }
}
