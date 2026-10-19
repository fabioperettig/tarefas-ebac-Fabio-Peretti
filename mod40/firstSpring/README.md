![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Curso EBAC](https://img.shields.io/badge/Curso--EBAC-f2f0ef?style=for-the-badge)

# 📚☕️ Tarefa módulo 40 - Introdução Spring Boot

Projeto de estudo desenvolvido no módulo 40 da EBAC para praticar persistência de clientes com Java 17, Spring Boot,
Spring Data JPA, Hibernate e PostgreSQL. O Lombok simplifica a construção dos objetos e os métodos de acesso aos atributos.

## 🧠 Properties

O `application.properties` configura a conexão com PostgreSQL, dá acesso ao Hibernate de criar manipular as tabelas
e faz a busca das variáveis de ambiente definidas no `.env`, oferecendo também valores default, caso não as encontre.

```properties
spring.application.name=firstSpring
spring.config.import=file:./.env[.properties]

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

## 👤 Entidade

A classe `Cliente` possui uma construção idêntica a projetos DAO construídos puramente com
`Jakarta Persistence`.

<details><summary>Classe Cliente</summary>

```java
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
```
</details>

## ⚙️ DAO Spring Data JPA

Aqui é onde o código mais se diferencia de projetos DAO construídos com JPA puro. Não há implementação CRUD, pois
**todas já estão embutidas nativamente no `Spring Data`**. A lógica desta camada é: criar uma interface
`IClienteRepository` com anotação `@Repository` e estender a interface Spring `JpaRepository<Cliente, Long>`.

````java
package com.fabioperettig.repository;

import com.fabioperettig.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
````

## ▶️  Classe de aplicação

Esta classe é o coração de toda a aplicação Spring Boot, sendo responsável por inicializar o projeto, configurar
as regras de leitura e executar o código de teste. Também é crucial que o topo da classe contenha anotações que
direcionam o Spring pelos diretórios do projeto.

```java
@SpringBootApplication
@EntityScan("com.fabioperettig.domain")
@EnableJpaRepositories(basePackages = "com.fabioperettig.repository")
@ComponentScan(basePackages = "com.fabioperettig")
public class FirstSpringApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(FirstSpringApplication.class);

    /// Injeção de dependência
    @Autowired
    private IClienteRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(FirstSpringApplication.class, args);
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        log.info("StartApplication");
        Cliente cliente = createClient();
        repository.save(cliente);


        /// teste de busca Criteria
        repository.buscaCriteria("Fabio", null).forEach(encontrado -> log.info(
                "Cliente consultado: id={}, nome={}", encontrado.getId(), encontrado.getNome()));
    }

    /// auxiliar - pattern BUILDER

    private Cliente createClient() {
        return Cliente.builder()
                .nome("Fabio Peretti")
                .cpf(12345678901L)
                .idade(33)
                .contato("fabioperettig@mail.com")
                .build();
    }
}
```

> Como a classe principal está no pacote `com.fabioperettig.firstSpring`, o Spring não conseguiria enxergar os
> diretórios `.domain` e `.repository` sem as anotações em seu topo.

| Anotação                | Função                                                                                                      |
|-------------------------|-------------------------------------------------------------------------------------------------------------|
| @SpringBootApplication  | Transforma a classe em uma aplicação Spring Boot, ativando recursos vitais em segundo plano                 |
| @EntityScan             | Avisa ao Spring para mapear a Classe dentro do repositório `.domain`                                        |
| @EnableJpaRepositories  | Diz ao Spring Data JPA onde estão as interfaces de repositório, gerando a implementação automática do CRUD  |
| @ComponentScan          | Garante que qualquer classe anotada com @Component, @Service, @Repository ou @RestController seja detectada e gerenciada|


## ⭐️ Extra: consulta com Criteria API

Além das operações fornecidas pelo Spring Data, testei como seria implementar métodos customizados no DAO, como
por exemplo uma consulta por Criteria, já que o CRUD não está em uma Classe concreta e nem é implementada no projeto.

A solução que encontrei para a união do CRUD ao Criteria foi: criar uma interface customizada como
`IClienteRepositoryCriteria` que define o método `buscaCriteria()`.

````java
package com.fabioperettig.repository;
import com.fabioperettig.domain.Cliente;
import java.util.List;

public interface IClienteRepositoryCriteria {
    List<Cliente> buscaCriteria(String nome, String email);
}
````

Depois, criar uma classe concreta que implementasse o método e **injetar o EntityManager** através da anotação
`@PersistenceContext`.

```java
public class IClienteRepositoryCriteriaImpl implements IClienteRepositoryCriteria {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cliente> buscaCriteria(String nome, String contato) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> querry = cb.createQuery(Cliente.class);
        Root<Cliente> cRoot = querry.from(Cliente.class);

        List<Predicate> predicateList = new ArrayList<>();

        if (nome != null && !nome.isEmpty()) {
            predicateList.add(cb.like(cRoot.get("nome"), "%" + nome + "%"));
        }
        if (contato != null && !contato.isEmpty()) {
            predicateList.add(cb.equal(cRoot.get("contato"), contato));
        }

        querry.where(predicateList.toArray(new Predicate[0]));
        return entityManager.createQuery(querry).getResultList();
    }
}
```
> É IMPRESCINDÍVEL que o nome desta classe termine com o sufixo `Impl` para que o Spring consiga fazer a associação.
> A boa prática é que o nome da Classe seja EXATAMENTE igual ao nome da Interface + o sufixo "Impl".

Por fim, extenda também a Interface customizada à Interface Repository

````java
package com.fabioperettig.repository;

import com.fabioperettig.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long>, IClienteRepositoryCriteria {

}
````

Assim, a aplicação continua com a praticidade da Interface JpaRepository do Spring Data, mas abre espaço para métodos
customizados para a Entidade.

---

**Fabio Peretti Guimarães | tarefa EBAC mod 40 | OUT 2026**
