![Java](https://img.shields.io/badge/Java-EA526F?style=for-the-badge&logo=openjdk&logoColor=white)
![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)
![Curso EBAC](https://img.shields.io/badge/Curso--EBAC-070600?style=for-the-badge)


# 📚☕️ Tarefa Módulo 37 - Projeto Tomcat

Projeto DAO monolítico, implementado em padrão JPA, com persistência PostgreSQL, interatividade JSF e servidor Tomcat.
 
## Contruindo Tomcat com [docker-compose](docker-compose.yaml)

```yaml
services:
  tomcat:
    build: .
    ports:
      - "8080:8080"
```
| Trecho | Função                                       |
|--------|----------------------------------------------|
|services| Lista os serviços que o Compose vai executar |
|tomcat| Nome que você deu ao serviço                 |
|build: .|Constrói a imagem usando o Dockerfile desta pasta|
|"8080:8080"|Conecta a porta 8080 do seu computador à porta 8080 do container|

> A tag `build` sempre aponta para uma pasta, tbm chamado `contexto de construção`, e procurará um Dockerfille presente
> neste contexto/pasta. Como o Dockerfille está na raiz do projeto, usa-se "." para marcar o atual diretório/contexto.

Caso o Dockerfille estiver em um sub diretório, a escrita se torna mais explicita;

```shell
projeto/
├── docker-compose.yaml
└── docker/
    ├── tomcat9/
    │   └── Dockerfile
    └── tomcat11/
        └── Dockerfile
```
No compose:

```yaml
services:
  tomcat:
    build:
      context: .
      dockerfile: docker/tomcat11/Dockerfile
    ports:
      - "8080:8080"
```


------

**Fabio Peretti Guimarães | tarefa Ebac mod 39 | OUT 2026**