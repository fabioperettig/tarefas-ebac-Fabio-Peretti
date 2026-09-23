package com.fabioperettig.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_sq")
    @SequenceGenerator(
            name = "prod_sq",
            sequenceName = "sq_produto",
            initialValue = 1,
            allocationSize = 1)
    private long id;

    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "NAME", length = 50, nullable = false)
    private String nome;

    @Column(name = "VALUE", nullable = false)
    private double value;


    ///GETTERS SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return codigo;
    }

    public void setCode(String codigo) {
        this.codigo = codigo;
    }

    public String getName() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
