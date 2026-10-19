package com.fabioperettig.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_CLIENTE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_sq")
    @SequenceGenerator(name = "client_sq", sequenceName = "sq_client", initialValue = 1, allocationSize = 1)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "CPF", nullable = false, unique = true)
    private Long cpf;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "IDADE", nullable = false)
    private Integer idade;

    @Column(name = "CONTATO", nullable = false)
    private String contato;
}
