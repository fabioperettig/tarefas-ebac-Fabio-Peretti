package com.fabioperettig.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_CLIENTE")
public class ClienteJPA implements ICliente<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    @SequenceGenerator(name = "cliente_seq", sequenceName = "sq_cliente", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "CPF", nullable = false, unique = true)
    private Long cpf;

    @Column(name = "EMAIL", nullable = false)
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
