package com.fabioperettig.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
    @SequenceGenerator(
            name = "client_seq",
            sequenceName = "sq_client",
            initialValue = 1,
            allocationSize = 1)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CPF", nullable = false)
    private Long cpf;

    @Column(name = "MAIL", nullable = false)
    private String mail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
