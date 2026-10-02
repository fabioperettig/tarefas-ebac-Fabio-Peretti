package com.fabioperettig.domain;

public interface ICliente {
    public Long getId();
    public String getNome();
    public void setNome(String nome);
    public Long getCpf();
    public void setCpf(Long cpf);
    public String getEmail();
    public void setEmail(String email);
}
