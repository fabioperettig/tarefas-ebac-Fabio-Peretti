package com.fabioperettig.domain;

public class ClienteJPA implements ICliente {

    private Long id;
    private String nome;
    private Long cpf;
    private String email;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public Long getCpf() {
        return cpf;
    }

    @Override
    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
}
