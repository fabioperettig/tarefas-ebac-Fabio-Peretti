package com.fabioperettig.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name="Produto", description="Produto")
public class Produto {

    @Id
    @Schema(description ="Identificador único")
    private String id;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description = "Nome", minLength = 1, maxLength = 50, nullable = false)
    private String nome;

    @NotNull
    @Indexed(unique = true)
    @Schema(description = "Código", nullable = false)
    private String codigo;

    @NotNull
    @Size(min = 1, max = 200)
    @Schema(description = "Descrição", minLength = 1, maxLength = 200, nullable = false)
    private String descr;

}
