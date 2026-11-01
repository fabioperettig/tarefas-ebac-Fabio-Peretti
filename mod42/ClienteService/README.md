![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Static Badge](https://img.shields.io/badge/microservices-brightgreen?style=for-the-badge&logo=moleculer&logoColor=white)
![Curso EBAC](https://img.shields.io/badge/Curso--EBAC-f2f0ef?style=for-the-badge)

# 📚☕️ Cliente Service

Microsserviço responsável pelo cadastro de clientes no projeto [Vendas Online em Arquitetura de Microsserviços](../README.md),
desenvolvido para o módulo 42 do curso. Esta microsserviço contém a inicialização da aplicação, o modelo `Cliente` e a
interface de persistência `ClienteRepository`.

> **Em desenvolvimento:**  regras de negócio e endpoints HTTP ainda serão construídos nas próximas etapas. 🚧

## Tecnologias e estrutura atual

O microsserviço foi desenolvido com Java 17, Spring Boot e Spring Data MongoDB. Portanto, o projeto executa persistência
de forma não relacional.

```text
com.fabioperettig
├── domain
|   └── Cliente   
├── repository
|   └──ClienteRepository
└── ClienteServiceApplication
```

## Spring, persistência e microsserviços

| Conceito            | Papel no projeto                                                                                                          |
|---------------------|---------------------------------------------------------------------------------------------------------------------------|
| Spring Framework    | Gerencia componentes e fornece suas dependências. Um objeto gerenciado pelo Spring é um **bean**.                         |
| Spring Boot         | Facilita a inicialização e configura recursos automaticamente conforme as dependências e outras condições.                |
| Spring Data MongoDB | Integra os objetos Java ao MongoDB e fornece suporte a repositórios.                                                      |
| Persistência        | Grava dados no banco para recuperá-los depois.                                                                            |
| Microsserviços      | Organiza o sistema em aplicações com responsabilidades delimitadas, que podem ser executadas e implantadas separadamente. |

`ClienteService` é a aplicação inteira. Uma futura classe com `@Service` será um componente de regras de negócio dentro
dela. **A anotação `@Service` não transforma uma classe em microsserviço.** A arquitetura depende da separação e da
autonomia das aplicações.

O Maven resolve as **dependências** declaradas no `pom.xml`. Um **starter** reúne bibliotecas para uma funcionalidade.
Um **import** permite usar um tipo pelo nome curto; não baixa nem ativa bibliotecas. Uma **anotação** fornece informações
que o compilador ou uma biblioteca interpreta.

## 1. Inicialização da aplicação

Na [`ClienteServiceApplication`](src/main/java/com/fabioperettig/ClienteServiceApplication.java), duas partes trabalham
juntas:

```java
@SpringBootApplication
```

Reúne a configuração da aplicação, a procura por componentes no pacote da classe e nos subpacotes e a configuração
automática. A procura não transforma toda classe encontrada em bean: ela precisa ser reconhecida como componente ou
registrada por outro mecanismo.

```java
SpringApplication.run(ClienteServiceApplication.class, args);
```

Inicia a aplicação Spring Boot usando essa classe como ponto de partida. Durante a inicialização, o Spring prepara o
contexto que administra os beans.

**O código atual também possui:**

| Trecho                                                                                  | Utilidade                                                                                                                 |
|-----------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| excludeName = "org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration" | Exclui a configuração automática de um `DataSource` JDBC, usado com bancos relacionais. Não desativa o acesso ao MongoDB. |
|@RefreshScope| Recurso do Spring Cloud que permite recriar o bean marcado quando um refresh é acionado. Não observa arquivos continuamente nem torna todos os beans atualizáveis por estar na classe principal.                                                                                                                         | 

Esses recursos de configuração não definem a arquitetura de microsserviços.

## 2. Modelo: os dados do cliente

A classe [`Cliente`](src/main/java/com/fabioperettig/domain/Cliente.java) representa os campos `id`, `nome`, `cpf`, `tel` e `email`. Suas anotações têm origens e responsabilidades diferentes:

| Anotação | Origem e função |
| --- | --- |
| `@Document(collection = "cliente")` | Spring Data MongoDB: associa o modelo à coleção `cliente`. |
| `@Id` | Spring Data: identifica o campo mapeado para o `_id` do documento. |
| `@Indexed(unique = true)` | Spring Data MongoDB: declara índices únicos separados para CPF e email. O banco garante a unicidade quando os índices existem. |
| `@Getter`, `@Setter` | Lombok: gera métodos de leitura e alteração durante a compilação. |
| `@NoArgsConstructor`, `@AllArgsConstructor` | Lombok: gera construtores sem argumentos e com todos os campos, respectivamente. |
| `@Builder` | Lombok: permite construir o objeto por etapas, como `Cliente.builder().nome("Fabio").build()`. |
| `@NotNull`, `@Size`, `@Pattern` | Jakarta Validation: declara regras de presença, tamanho e formato. |
| `@Schema` | Swagger/OpenAPI: descreve o modelo na documentação da API. Não executa validações. |

Pontos para lembrar ao reutilizar esse modelo:

- `new Cliente()` e `.build()` criam objetos em memória. Não salvam nem executam as regras de validação por si mesmos.
- `@NotNull` rejeita `null`, mas aceita texto vazio. `@Size(min = 1)` rejeita texto vazio, mas aceita espaços. A validação precisa ser acionada para aplicar as regras.
- A anotação de índice não comprova que ele existe no banco. Sua criação depende da configuração ou de uma ação explícita.

**Um objeto `Cliente` não precisa ser bean para ser persistido.** Gerenciamento pelo Spring e gravação no banco são questões diferentes.

## 3. Repositório: acesso à persistência

A interface [`ClienteRepository`](src/main/java/com/fabioperettig/repository/ClienteRepository.java) oferece operações para trabalhar com os clientes no MongoDB:

```java
package com.fabioperettig.repository;

import com.fabioperettig.domain.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
```

`extends` faz a interface herdar o contrato de `MongoRepository`. Os generics `<Cliente, String>` indicam o tipo de objeto persistido e o tipo do seu identificador. Usamos `String` porque esse é o tipo do campo marcado com `@Id` em `Cliente`.

Mesmo com o corpo vazio, a interface já oferece operações herdadas:

| Operação | Finalidade |
| --- | --- |
| `save(cliente)` | Salvar o cliente, inserindo ou gravando seu estado conforme a identificação do objeto. |
| `findById(id)` | Buscar pelo identificador; retorna um `Optional<Cliente>`, que pode conter um cliente ou estar vazio. |
| `findAll()` | Buscar todos os clientes. |
| `deleteById(id)` | Excluir pelo identificador. |

A infraestrutura do Spring Data cria um objeto que implementa esse contrato e o registra como bean. Não precisamos escrever uma implementação manual para essas operações nem colocar `@Repository` nessa interface.

Com a configuração automática padrão do Boot, o starter de Spring Data MongoDB e o pacote abaixo de `com.fabioperettig`, também não é necessário adicionar `@EnableMongoRepositories` manualmente.

**Declarar o repositório não dispara gravações.** Será necessário chamar suas operações e ter uma conexão válida com o banco. O `save` também não deve ser tratado como execução automática de todas as regras de Jakarta Validation.

A próxima etapa será conectar o repositório à camada de regras de negócio por injeção de dependências.
