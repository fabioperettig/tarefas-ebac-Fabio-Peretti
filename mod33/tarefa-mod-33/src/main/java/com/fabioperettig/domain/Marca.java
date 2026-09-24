package com.fabioperettig.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_MARCA")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m.seq")
    @SequenceGenerator(name = "m.seq", sequenceName = "sq_m", initialValue = 1, allocationSize = 1)
    private long id;

    @Column(name = "CODIGO", nullable = false, unique = true)
    private String codigo;

    @Column(name = "NOME", nullable = false, unique = true)
    private String nome;

    @Column(name = "NOME", nullable = false)
    private int fundada;

    @Column(name = "NOME", nullable = false)
    private String origem;

    @OneToMany(mappedBy = "carro")
    private List<Carro> carros;


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

    public int getFundada() {
        return fundada;
    }

    public void setFundada(int fundada) {
        this.fundada = fundada;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

}
