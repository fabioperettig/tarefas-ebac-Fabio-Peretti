![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Static Badge](https://img.shields.io/badge/microservices-brightgreen?style=for-the-badge&logo=moleculer&logoColor=white)
![Curso EBAC](https://img.shields.io/badge/Curso--EBAC-f2f0ef?style=for-the-badge)

# 📚☕️ Tarefa módulo 42 - Vendas Online em Arquitetura de Microsserviços

Este é meu primeiro projeto DAO, com cadastro e manipulaçõa de entidades e persistência de dados, construído
em uma arquitetura de `Microsserviços`.

## 🧩 Estrutura e tecnologias

O projeto é composto por dois microsserviços com métodos CRUD completos, que cadastram, buscam, alteram e excluem dados.
Sendo um para manipulação de `Clientes` e outro para `Produtos`.

Além disso, o projeto ainda conta com um `microsserviço` primordial para agregar ambos numa mesma interface `Swagger`.

O projeto foi construído sob os frameworks `Spring Boot` e `Spring Data MongoDB`, além de libraries
mais utilitárias como `Lombok`.

| Microsserviços                                                   | Descrição                                                  | Porta |
|------------------------------------------------------------------|------------------------------------------------------------|-------|
| [ClienteService](ClienteService/src/main/java/com/fabioperettig) | Cadastro e manipulação de `Cliente`                        | 8081  |
| [ProdutoService](ProdutoService/src/main/java/com/fabioperettig) | Cadastro e manipulação de `Produto`                        | 8082  |
| [ConfigServer](ConfigServer/src/main/java/com/fabioperettig)     | Agregador de portas tanto de `Cleinte` quanto de `Produto` | 8888  |

## 🔍 Detalhes de cada microsserviço

 Dentro de cada microsserviço é possível conferir mais detalhes de sua implementação Spring, seu mapeamento de controle
 e sua configuração YML.

| Microsserviço  | Detalhes                              |
|----------------|---------------------------------------|
| ClienteService | [README.md](ClienteService/README.md) |
| ProdutoService | [README.md](ProdutoService/README.md) |

---

**Fabio Peretti Guimarães | tarefa EBAC mod 42 | NOV 2026**
