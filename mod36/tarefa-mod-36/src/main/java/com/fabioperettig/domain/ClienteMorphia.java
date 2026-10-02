package com.fabioperettig.domain;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import org.bson.types.ObjectId;

@Entity("clientes")
public class ClienteMorphia implements ICliente<ObjectId> {

    @Id
    private ObjectId id;
    private String nome;
    private Long cpf;
    private String email;

    @Override
    public ObjectId getId() {
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
