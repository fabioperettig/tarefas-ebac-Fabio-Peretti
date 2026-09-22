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
    private String code;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

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
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
