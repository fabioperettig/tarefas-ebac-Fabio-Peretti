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

## Entidade Interface e DTOs

Escolhi trabalhar com uma entidade simples `ClienteJPA` estruturada no padrão de anotações `Jakarta Persistence`
para o PostgreSQL, e também no padrão de anotações `Morphia` para o Mongo, mas ambas implementando a mesma interface ICliente.

```java
//Padrão Jakarta Persistence
public static void main(String[] args) {
    System.out.println("HelloWorld");
}
```

```java
//Padrão Morphia
public static void main(String[] args) {
    System.out.println("HelloWorld");
}
```

## 🐳 Docker

Em Construção

------

**Fabio Peretti Guimarães | tarefa Ebac mod 36 | OUT 2026**