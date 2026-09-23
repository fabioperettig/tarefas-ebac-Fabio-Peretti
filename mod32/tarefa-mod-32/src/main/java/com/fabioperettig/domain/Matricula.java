package com.fabioperettig.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "TB_MATRICULA")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mat_sq")
    @SequenceGenerator(name = "mat_sq", sequenceName = "seq_matricula", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "DATA_MATRICULA", nullable = false)
    private Instant dataMatricula = Instant.now();

    @Column(name = "VALOR", nullable = false)
    private Double valor;

    @ColumnDefault("True")
    @Column(name = "STATUS", nullable = false)
    private Boolean status = true;

    @ManyToOne
    @JoinColumn(
            name = "id_curso_fk",
            foreignKey = @ForeignKey(name = "fk_curso_matricula"),
            referencedColumnName = "id", nullable = false)
    private Curso curso;


    ///GETTERS SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Instant getDataMatricula() {
        return dataMatricula;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
