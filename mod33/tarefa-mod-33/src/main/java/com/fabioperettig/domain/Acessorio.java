package com.fabioperettig.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_ACESSORIO")
public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c.seq")
    @SequenceGenerator(name = "c.seq", sequenceName = "sq_c", initialValue = 1, allocationSize = 1)
    private long id;

    @Column(name = "CODIGO", nullable = false, unique = true)
    private String codigo;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "VALOR", nullable = false)
    private double valor;

    @Column(name = "CATEGORIA", nullable = false)
    private String categoria;

    @OneToOne(optional = false)
    @JoinColumn(name = "carro_id",
            foreignKey = @ForeignKey(name = "fk_carro_acessorio"),
            unique = true, nullable = false)
    private Carro carro;

    ///getter_setter
    public long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
