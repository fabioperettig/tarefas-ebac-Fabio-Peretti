![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Static Badge](https://img.shields.io/badge/microservices-brightgreen?style=for-the-badge&logo=moleculer&logoColor=white)
![Curso EBAC](https://img.shields.io/badge/Curso--EBAC-f2f0ef?style=for-the-badge)
![CLIENTE](https://img.shields.io/badge/Cliente--service-000000?style=for-the-badge)

# 📚☕️ Projeto DAO Microsserviços | cliente-service

Este repositório é um microsserviço integrante do projeto [Vendas Online em Arquitetura de Microsserviços](https://github.com/fabioperettig/tarefas-ebac-Fabio-Peretti/tree/main/mod42).
Este microsserviço cuida do cadastro de clientes.

## Guia de estudo: dependências, imports e anotações

Os exemplos abaixo acompanham a classe [`Cliente`](src/main/java/com/fabioperettig/domain/Cliente.java) e as dependências do [`pom.xml`](pom.xml). O projeto usa Java 17, Spring Boot 4.1.2, Spring Cloud 2025.1.4 e Springdoc 3.2.0.

### Qual é a diferença?

| Conceito | O que significa | Exemplo neste projeto |
| --- | --- | --- |
| Biblioteca (library) | Código pronto que o projeto pode usar. | Lombok oferece geração de getters, setters e construtores. |
| Dependência | Declaração no Maven de algo necessário ao projeto. Pode trazer outras dependências, chamadas transitivas. | A dependência `lombok` está no `pom.xml`. |
| Starter | Dependência do Spring Boot que reúne bibliotecas para uma funcionalidade. | `spring-boot-starter-data-mongodb` traz a integração com Spring Data MongoDB. |
| Pacote | Nome que organiza tipos Java e distingue tipos com nomes iguais. | `org.springframework.data.annotation`. |
| Import | Permite escrever o nome curto de um tipo disponível no projeto. | Com `import org.springframework.data.annotation.Id;`, podemos escrever `@Id`. |
| Anotação (annotation) | Informação marcada com `@`, lida pelo compilador ou por uma biblioteca para orientar algum comportamento. | O Spring Data lê `@Id` para identificar o campo que corresponde ao `_id` do MongoDB. |

Adicionar um `import` não baixa uma biblioteca. O Maven resolve as dependências; o import permite usar seus tipos pelo nome curto. Por isso, um import pode continuar vermelho quando falta a dependência correta.

Este import da classe:

```java
import jakarta.validation.constraints.*;
```

permite usar os tipos desse pacote, como `NotNull`, `Size` e `Pattern`, sem escrever um import para cada um. O `*` não inclui subpacotes nem ativa todas as validações: só as anotações aplicadas ao código declaram regras.

### O que cada biblioteca faz?

| Dependência no `pom.xml` | Papel no projeto | Relação com `Cliente` |
| --- | --- | --- |
| `spring-boot-starter-data-mongodb` | Integra o Spring Data ao MongoDB, com mapeamento de objetos, `MongoTemplate` e suporte a repositórios. | Fornece `@Id`, `@Document` e `@Indexed`. |
| `spring-boot-starter-validation` | Disponibiliza Jakarta Validation e uma implementação para executar suas regras. | Fornece suporte a `@NotNull`, `@Size` e `@Pattern`. |
| `lombok` | Gera código durante a compilação, por meio de um processador de anotações. | Gera getters, setters, construtores e builder. |
| `springdoc-openapi-starter-webmvc-ui` | Gera documentação OpenAPI a partir da aplicação e disponibiliza a interface Swagger UI para consultar e experimentar endpoints. | Traz as anotações Swagger, incluindo `@Schema`. |
| `spring-boot-starter-webmvc` | Fornece Spring MVC e servidor web embarcado para criar endpoints HTTP. | Permitirá receber e devolver dados de clientes nos controllers. |
| `spring-cloud-starter` | Reúne infraestrutura básica do Spring Cloud. | É usado na infraestrutura da aplicação, como o suporte a `@RefreshScope`. |
| `spring-cloud-starter-config` | Permite buscar configurações em um Config Server. | Atua na inicialização; não mapeia campos da classe. |
| `spring-cloud-starter-openfeign` | Permite declarar clientes HTTP por interfaces, para comunicação entre serviços. | Será útil quando este serviço precisar chamar outra API; adicioná-lo não cria chamadas sozinho. |
| `spring-boot-devtools` | Oferece recursos de desenvolvimento, como reinício automático após alterações compiladas. | Ajuda durante o desenvolvimento da aplicação. |
| `spring-boot-starter-mongodb-test` | Reúne suporte de testes para a integração básica com MongoDB. | Está restrito aos testes pelo `scope` `test`; não fornece o mapeamento Spring Data ao código principal. |
| `spring-boot-starter-validation-test` | Reúne suporte para testar validação. | Pode ajudar a verificar regras dos campos. |
| `spring-boot-starter-webmvc-test` | Reúne suporte para testar a camada web. | Pode ajudar a verificar requisições e respostas dos controllers. |

O starter `spring-boot-starter-mongodb` fornece a integração básica com o MongoDB. Para os recursos do Spring Data usados na classe, escolhemos `spring-boot-starter-data-mongodb`. A distinção está na [lista oficial de starters](https://docs.spring.io/spring-boot/reference/using/build-systems.html).

O `spring-boot-starter-parent` gerencia versões e configurações do Maven. O `spring-cloud-dependencies` é um BOM: uma lista de versões compatíveis de dependências do Spring Cloud. Eles não são imports Java. Os plugins do Maven, como `maven-compiler-plugin` e `spring-boot-maven-plugin`, executam tarefas de compilação, execução e empacotamento.

O Springdoc 3.2.0 está na faixa compatível com Spring Boot 4.1, conforme a [matriz oficial](https://springdoc.org/#what-is-the-compatibility-matrix-of-springdoc-openapi-with-spring-boot).

### Quais imports pertencem a cada biblioteca?

| Pacote importado em `Cliente` | Biblioteca responsável | Tipos usados |
| --- | --- | --- |
| `org.springframework.data.annotation` | Spring Data Commons, trazido pelo starter de Spring Data MongoDB. | `Id` |
| `org.springframework.data.mongodb.core.index` | Spring Data MongoDB. | `Indexed` |
| `org.springframework.data.mongodb.core.mapping` | Spring Data MongoDB. | `Document` |
| `jakarta.validation.constraints` | Jakarta Validation. | `NotNull`, `Size`, `Pattern` |
| `lombok` | Lombok. | `Getter`, `Setter`, `AllArgsConstructor`, `NoArgsConstructor`, `Builder` |
| `io.swagger.v3.oas.annotations.media` | Anotações Swagger/OpenAPI, trazidas pelo Springdoc. | `Schema` |

O pacote completo importa: `org.springframework.stereotype.Indexed` e `org.springframework.data.mongodb.core.index.Indexed` são anotações diferentes. A segunda é a usada para índices de CPF e email.

### O que cada anotação de `Cliente` faz?

| Anotação | Quem a interpreta e quando | Efeito neste código |
| --- | --- | --- |
| `@Document(collection = "cliente")` | Spring Data MongoDB, no mapeamento. | Associa a classe à coleção `cliente`. A coleção armazena documentos, correspondentes aos objetos persistidos. |
| `@Id` | Spring Data MongoDB, na leitura e gravação. | Mapeia `id` para o identificador `_id` do documento. |
| `@Indexed(unique = true)` | Spring Data descreve o índice; o MongoDB aplica a restrição quando o índice existe. | Declara índices únicos separados para CPF e email, para impedir valores repetidos em cada campo. |
| `@Getter` | Lombok, durante a compilação. | Gera métodos de leitura, como `getNome()` e `getCpf()`. |
| `@Setter` | Lombok, durante a compilação. | Gera métodos de alteração, como `setNome(String nome)`. |
| `@NoArgsConstructor` | Lombok, durante a compilação. | Gera `new Cliente()`, sem argumentos. Os campos começam com seus valores padrão, neste caso `null`. |
| `@AllArgsConstructor` | Lombok, durante a compilação. | Gera um construtor com todos os campos, na ordem da declaração: `id`, `nome`, `cpf`, `tel` e `email`. |
| `@Builder` | Lombok, durante a compilação. | Gera a construção por etapas, como `Cliente.builder().nome("Fabio").build()`. |
| `@NotNull` | Jakarta Validation, quando a validação é executada. | Rejeita `null`; não verifica sozinho se uma string está vazia ou contém apenas espaços. |
| `@Size(min = 1, max = 50)` | Jakarta Validation, quando a validação é executada. | Em `nome` e `email`, exige de 1 a 50 caracteres. Sozinha, aceita `null`; por isso está combinada com `@NotNull`. |
| `@Pattern(...)` | Jakarta Validation, quando a validação é executada. | Exige que o email corresponda à expressão regular. `message` define a mensagem de violação. |
| `@Schema(...)` | Springdoc/Swagger, ao gerar a documentação. | Descreve o modelo e os campos da API. `name` nomeia o modelo; `description` o explica; os demais atributos descrevem suas características. |

Referências: [mapeamento do Spring Data](https://docs.spring.io/spring-data/mongodb/reference/mongodb/mapping/mapping.html), [regras Jakarta Validation](https://jakarta.ee/specifications/bean-validation/3.1/apidocs/jakarta/validation/constraints/package-summary.html), [getters e setters](https://projectlombok.org/features/GetterSetter), [construtores](https://projectlombok.org/features/constructor), [builder](https://projectlombok.org/features/Builder) e [Springdoc/OpenAPI](https://springdoc.org/).

### Exemplo: as etapas de criação, validação e gravação

```java
Cliente cliente = Cliente.builder()
        .nome("Fabio")
        .cpf(12345678901L)
        .tel(11999999999L)
        .email("fabio@example.com")
        .build();

String nome = cliente.getNome(); // Método gerado pelo @Getter.
cliente.setNome("Fabio Peretti"); // Método gerado pelo @Setter.
```

Nesse trecho, o builder cria um objeto em memória. Ainda não houve validação nem gravação no MongoDB. O `id` pode continuar `null` antes da persistência.

Quando um controller receber um objeto com `@Valid @RequestBody Cliente cliente`, o Spring MVC poderá executar as regras de validação antes de chamar o método. Também é possível validar explicitamente com a API `Validator`. Apenas chamar `new Cliente()`, um setter ou `.build()` não executa as regras de Jakarta Validation. Veja a [validação no Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-validation.html).

Ao salvar o objeto por um repositório ou pelo `MongoTemplate`, o Spring Data faz o mapeamento para o documento. Não se deve presumir que salvar por um repositório executará automaticamente todas as regras de Jakarta Validation: isso depende da integração de validação configurada.

### Detalhes para acompanhar a aula

| Situação | Como interpretar |
| --- | --- |
| `@Schema(nullable = false)` e `@NotNull` aparecem juntos. | O primeiro descreve a API; o segundo declara uma regra executável de validação. A documentação não bloqueia dados inválidos sozinha. |
| `nome` recebe `"   "`. | Passa em `@NotNull` e em `@Size(min = 1, max = 50)`. Para rejeitar texto composto só de espaços, existe `@NotBlank`. |
| `cpf` recebe qualquer número não nulo. | A regra atual não verifica quantidade de dígitos nem os dígitos verificadores do CPF. |
| O email passa em `@Pattern`. | O padrão atual faz uma checagem simples de formato, com texto antes e depois de `@` e de um ponto. Não comprova que o endereço existe. Jakarta Validation também oferece `@Email`. |
| CPF e telefone são `Long`. | É o formato atual da aula. Em outro projeto, vale avaliar `String`: esses valores são identificadores, podem conter zeros à esquerda e não representam quantidades para cálculo. |
| A classe possui `@Indexed(unique = true)`. | O índice precisa existir no MongoDB para garantir unicidade. A criação automática de índices vem desabilitada por padrão no Spring Data desde a versão 3.0; pode ser habilitada ou feita explicitamente. A anotação sozinha não comprova que o índice foi criado. |

A criação de índices está explicada na [documentação oficial do Spring Data MongoDB](https://docs.spring.io/spring-data/mongodb/reference/mongodb/mapping/mapping-index-management.html). Esses pontos servem para entender o comportamento atual; os exemplos não exigem mudar o modelo da aula agora.
