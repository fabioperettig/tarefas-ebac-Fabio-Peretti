package com.fabioperettig.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_FILME")
@Getter @Setter
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filme_seq")
    @SequenceGenerator(name = "filme_seq", sequenceName = "sq_filme", initialValue = 1, allocationSize = 1)
    @Setter(AccessLevel.NONE)
    Long id;

    @Column(name = "CODIGO",  nullable = false, unique = true)
    String codigo;

    @Column(name = "NOME", nullable = false)
    String nome;

    @Column(name = "ANO")
    Integer anoLancamento;

    @Column(name = "CATEGORIA")
    String categoria;

    @Column(name = "TEMPO", nullable = false)
    Integer tempoEmMin;

    @Column(name = "NOTA")
    Double nota;
}
