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

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "ANO", nullable = false)
    private int ano;

    @Column(name = "MODELO", nullable = false)
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "nome_marca_fk", foreignKey = @ForeignKey(name = "fk_marca_carro"),
    referencedColumnName = "NOME", nullable = false)
    private Marca marca;

    @OneToOne
    @JoinColumn(name = "nome_acessorio_fk", foreignKey = @ForeignKey(name = "fk_acessorio_carro"),
            referencedColumnName = "NOME", nullable = false)
    private Acessorio acessorio;


    ///getter_setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Acessorio getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(Acessorio acessorio) {
        this.acessorio = acessorio;
    }
}
