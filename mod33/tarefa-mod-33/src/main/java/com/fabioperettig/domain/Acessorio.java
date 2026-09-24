package com.fabioperettig.domain;

import jakarta.persistence.*;

public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c.seq")
    @SequenceGenerator(name = "c.seq", sequenceName = "sq_c", initialValue = 1, allocationSize = 1)
    private long id;

    @Column(name = "CODIGO", nullable = false, unique = true)
    private String codigo;

    @Column(name = "NOME", nullable = false, unique = true)
    private String nome;

    @Column(name = "NOME", nullable = false)
    private int ano;

    @Column(name = "MODELO", nullable = false)
    private String modelo;
}
