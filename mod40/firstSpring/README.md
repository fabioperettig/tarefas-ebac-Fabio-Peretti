![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![WildFly](https://img.shields.io/badge/WildFly-%23f0473e.svg?style=for-the-badge&logo=redhat&logoColor=white)
![Curso EBAC](https://img.shields.io/badge/Curso--EBAC-f2f0ef?style=for-the-badge)

# 📚☕️ Tarefa módulo 40 - Introdução Spring Boot

Primeiro projeto DAO persistência PostgreSQL, implementado com Spring Boot.


## 🧠 Properties

Lorem Ipsum.

```properties
spring.application.name=firstSpring

# ===============================
# DATA SOURCE — PostgreSQL
# ===============================
spring.datasource.url=${DB_URL:jdbc:postgresql://localhost:5432/postgres}
spring.datasource.username=${DB_USER:Admin}
spring.datasource.password=${DB_PASSWORD}

# ===============================
# JPA / HIBERNATE — desenvolvimento
# ===============================
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=update
```

## 👤 Dominio

Lorem

<details><summary>Entidade Cliente</summary>

```java
package com.fabioperettig.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_CLIENTE")
@Getter
@Setter
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
```

</details>

## ⚙️ DAO com Spring Boot

Agora com o uso do Spring Boot

```java

```

------

**Fabio Peretti Guimarães | tarefa Ebac mod 40 | OUT 2026**