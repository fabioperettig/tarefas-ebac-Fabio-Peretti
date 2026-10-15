package com.fabioperettig.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_LIVRO")
@Getter @Setter
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "l_sq")
    @SequenceGenerator(name = "l_sq", sequenceName = "sq_livro", initialValue = 1, allocationSize = 1)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "CODIGO", nullable = false, unique = true)
    private Long codigo;

    @Column(name = "TITULO", nullable = false)
    private String titulo;

    @Column(name = "AUTOR", nullable = false)
    private String autor;

    @Column(name = "SINOPSE")
    private String sinopse;

    @Column(name = "NOTA")
    private Double nota = 1.0;
}
