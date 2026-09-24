package com.fabioperettig.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_CARRO")
public class Carro {

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

    private Marca marca;

    private Acessorio acessorio;

}
