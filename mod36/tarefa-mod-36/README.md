![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)
![Curso EBAC](https://img.shields.io/badge/Curso--EBAC-f2f0ef?style=for-the-badge)

# 📚☕️ Tarefa Módulo 36

Este projeto simples serve como introdução para projetos DAO que utilizam dois databases diferentes para a persistência de Entidades.
Para isso, escolhi utilizar os BD PostgreSQL como Banco Relacional e MongoDB como Banco Não Relacional.

| objetivo                                            | Observações                                       |
|-----------------------------------------------------|---------------------------------------------------|
| Cadastrar uma Entidade em dois databases diferentes | Provavelmente DAOs dedicados para cada DB         |
| Trabalahr com SQl e NoSQL                           | PostgreSQL e MongoDB                              |
| Integrar databases via Docker                       | Praticar Docker via .yml com variávis de ambiente |
| Integrar databases via Docker                       |                                                   |

## Entidade Interface e Concretas

Escolhi trabalhar com uma entidade simples `ClienteJPA` estruturada no padrão de anotações `Jakarta Persistence`
com identificador `Long` para o PostgreSQL, e também no padrão de anotações `Morphia` com identificador `ObjectId`
para o Mongo, mas ambas implementando a mesma interface `ICliente<ID>`.

```java
import jakarta.persistence.*;

@Entity
@Table(name = "TB_CLIENTE")
public class ClienteJPA implements ICliente<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    @SequenceGenerator(name = "cliente_seq", sequenceName = "sq_cliente", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "CPF", nullable = false, unique = true)
    private Long cpf;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    ///getter e setters {...}
}
```

```java
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import org.bson.types.ObjectId;

@Entity("clientes")
public class ClienteMorphia implements ICliente<ObjectId> {

    @Id
    private ObjectId id;
    private String nome;
    private Long cpf;
    private String email;
    
    ///getter e setters {...}
}
```

## 🐳 Docker

Em Construção

------

**Fabio Peretti Guimarães | tarefa Ebac mod 36 | OUT 2026**