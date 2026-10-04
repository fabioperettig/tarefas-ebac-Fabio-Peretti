![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Maven](https://img.shields.io/badge/apachemaven-%23C71A36.svg?style=for-the-badge&logo=apachemaven&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-%232c2c2c.svg?style=for-the-badge&logo=Hibernate&logoColor=white)
![Curso EBAC](https://img.shields.io/badge/Curso--EBAC-f2f0ef?style=for-the-badge)

# 📚☕️ Tarefa Módulo 37

Este projeto apresenta mais um sistema DAO simples, mas com uma bilbioteca mais expandida para mostrar a capacidade
do de gerenciamento de depencências via `Maven` e das possibilidades que as `libraries` oferecem.

## Maven

Escolhi trabalhar com uma entidade simples `ClienteJPA` estruturada no padrão de anotações `Jakarta Persistence`
com identificador `Long` para o PostgreSQL, e também no padrão de anotações `Morphia` com identificador `ObjectId`
para o Mongo, mas ambas implementando a mesma interface `ICliente<ID>`.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.fabioperettig</groupId>
    <artifactId>tarefa-mod-37</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- Source: https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-core -->
        <dependency>
            <groupId>org.hibernate.orm</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>7.4.10.Final</version>
            <scope>compile</scope>
        </dependency>
        <!-- Source: https://mvnrepository.com/artifact/org.postgresql/postgresql -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.7.13</version>
            <scope>compile</scope>
        </dependency>
        <!-- Source: https://mvnrepository.com/artifact/io.github.cdimascio/dotenv-java -->
        <dependency>
            <groupId>io.github.cdimascio</groupId>
            <artifactId>dotenv-java</artifactId>
            <version>3.2.0</version>
            <scope>compile</scope>
        </dependency>
        <!-- Source: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>6.1.3</version>
            <scope>test</scope>
        </dependency>
        <!-- Source: https://mvnrepository.com/artifact/org.projectlombok/lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.46</version>
            <scope>compile</scope>
        </dependency>
    </dependencies>

</project>
```

Com as dependências escolhidas, é possível construir um projeto seguro, com estrutura robusta e evitar Boilerplates,
cada dependência possui um papel fundamental e podem ser analisadas mais a fundo logo abaixo da tabela.


| 📚 Dependência | 🎯 Utilidade                                                                                                                                      |
|--------------------|---------------------------------------------------------------------------------------------------------------------------------------------------|
| Hibernate ORM      | Implementa o mapeamento objeto-relacional através da JPA, permitindo persistir e recuperar objetos `Filme no banco de dados.                      |
| Lombok             | Reduz código repetitivo na entidade, gerando automaticamente métodos como `Getters` e `Setters`.                                                  |
| PostgreSQL         | Permite a comunicação entre a aplicação Java e o banco de dados `PostgreSQL utilizado para persistência dos filmes.                               |
| Dotenv             | Carrega configurações sensíveis, como usuário, senha e URL do banco, a partir de `Variáveis de Ambiente`.                                         |
| JUnit              | Permite criar `Testes` automatizados para validar métodos e comportamentos da aplicação durante o desenvolvimento.                                |
| PicoCLI            | Estrutura a interface de linha de comando, permitindo criar comandos, opções e parâmetros sem depender de menus manuais com `Scanner` e `Switch`. |

<details>
<summary>Detalhes sobre cada dependência</summary>

### Hibernate ORM + @Lombok 📚 < /dependency>

Usando as dependências `Hibernate` e `Lombok`, é possivel implementar uma Entidade de forma bastante dinâmica, não
só com a agilidade do Hibernate, mas também Getters e Setters adicionados dinamicamente através com Lombok (com a 
possibilidade de evitar setters que compromentam a estrutura como o caso do atributo Id).

```java
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
```

</details>


------

**Fabio Peretti Guimarães | tarefa Ebac mod 37 | OUT 2026**