![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Static Badge](https://img.shields.io/badge/microservices-brightgreen?style=for-the-badge&logo=moleculer&logoColor=white)
![Curso EBAC](https://img.shields.io/badge/Curso--EBAC-f2f0ef?style=for-the-badge)

# 📚☕️ Cliente Service

Este é um Microsserviço responsável pelo cadastro e manipulação de dados de Clientes no projeto [Vendas Online em Arquitetura de Microsserviços](../README.md),
desenvolvido para o módulo 42 do curso.

Este é um microsserviço simples porém completo, conténdo a inicialização da aplicação, o modelo `Cliente` e a
interface de persistência `IClienteRepository`.

## 🧩 Estrutura e tecnologias

O microsserviço `ClienteService` foi construído sob os frameworks `Spring Boot` e `Spring Data MongoDB`, além de libraries
mais utilitárias como `Lombok`.

```text
com.fabioperettig
├── controller
|   └── ClienteController
├── domain
|   └── Cliente
├── repository
|   └── IClienteRepository
└── ClienteServiceApplication
```

Apesar de se tratar de um projeto Spring com arquitetura de Microsserviço, ele possui uma estrutura central ainda familiar
a outros projetos DAO. Suas maiores mudanças são na forma de trabalhar na camada de persistência e na camada de controle.

### 🖋️ Persistência com interfaces

O uso do Spring permite trabalharmos com extensão de interfaces que já possuam um sistema de métodos CRUD pronto,
delegando ao framework toda a manipulação do ciclo de vida do objeto via `IOC (Inversion of Control)`.

Assim, o que antes seria uma camada DAO completa (via JPA/Hibernate) se resume a uma extensão com a interface do banco
de dados escolhido. Sendo, neste caso, o `MongoRepository`.

```java
package com.fabioperettig.repository;

import com.fabioperettig.domain.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IClienteRepository extends MongoRepository<Cliente, String> {

    Optional<Cliente> findByCpf(Long cpf);

}
```

### 🖥️ Camada de controlle e mapeamento

Aqui o código tem a mudança mais visivel em todo o projeto. Tanto o uso do `Springboot` quando a escolha de arquitetura
em `microservices` possuem influência direta sobre o código, usando menos sintaxe Java e mais o uso de `@Annotations`.

```java
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@Valid @RequestBody Cliente cliente) {
        Cliente clienteCadastro = clienteService.cadastrar(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCadastro);
    }

    @GetMapping(value = "/id/{id}")
    @Operation(summary = "Busca um cliente pelo id")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable(value = "id", required = true) String id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @GetMapping(value = "/cpf/{cpf}")
    @Operation(summary = "Busca um cliente pelo cpf")
    public ResponseEntity<Cliente> buscarPorCpf(@PathVariable(value = "cpf", required = true) Long cpf) {
        return ResponseEntity.ok(clienteService.buscarPorCpf(cpf));
    }

    @GetMapping
    public ResponseEntity<Page<Cliente>> buscarTodos(Pageable pageable) {
        return ResponseEntity.ok(clienteService.buscarTodos(pageable));
    }

    @PutMapping
    @Operation(summary = "Atualiza um cliente")
    public ResponseEntity<Cliente> atualizar(@Valid @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.atualizar(cliente));
    }

    @DeleteMapping(value = "/delete/{id}")
    @Operation(summary = "Remove um cliente pelo id")
    public ResponseEntity<String> remover(@PathVariable(value = "id") String id) {
        clienteService.deletarPorId(id);
        return ResponseEntity.ok("Cliente removido");
    }
}
```

| Anotação        | Papel no projeto                                               |
|-----------------|----------------------------------------------------------------|
| @RestController | Cria APIs RESTful de forma simples e direta                    |
| @RequestMapping | Mapeia os métodos da camada de controle para requisições `HTTP`|

| Anotação de Mapeamento | Função                                                      | Método requisitado               |
|------------------------|-------------------------------------------------------------|----------------------------------|
| @PostMapping           | Salvar novos dados no database                              | insert(entity)                   |
| @GetMapping            | Buscar um dado espefícico ou todos os dados do servidor     | findById(id) / findAll(pageable) |
| @PutMapping            | Atualizar um ou mais dados de um cadastro existente         | save(entity)                     |
| @DeleteMapping         | Deletar um cadastro do database, geralmente através do `id` | deleteById(id)                   |


## 🚀 Execução

Para executar este microsserviço, primeiro é necessário executar o [ConfigServerApplication](../ConfigServer/src/main/java/com/fabioperettig/ConfigServerApplication.java),
que fornece configurações centralizadas para `ClienteService` e `ProdutoService`. Cada microsserviço continua sendo uma
aplicação independente, iniciada separadamente.

```yaml
server:
  port: 8081
  wait-time-in-ms-when-sync-empty: 3000

spring:
  mongodb:
    host: 127.0.0.1
    port: 27017
    database: cliente
    authentication-database: admin
    username: ${MONGO_INITDB_ROOT_USERNAME}
    password: ${MONGO_INITDB_ROOT_PASSWORD}
  data:
    mongodb:
      auto-index-creation: true

application-version: 1.0
```

> `cliente-service.yml` agregado em `ConfigServer`

---

**Fabio Peretti Guimarães | tarefa EBAC mod 42 | NOV 2026**
