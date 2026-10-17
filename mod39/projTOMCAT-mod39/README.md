![Java](https://img.shields.io/badge/Java-EA526F?style=for-the-badge&logo=openjdk&logoColor=white)
![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)
![Curso EBAC](https://img.shields.io/badge/Curso--EBAC-070600?style=for-the-badge)


# 📚☕️ Tarefa Módulo 39 - Projeto Tomcat

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

> Na forma curta, `build` aponta para uma pasta, chamada **contexto de construção**, onde o Docker procura
> um arquivo chamado `Dockerfile`. O `.` indica a pasta do Compose, que neste projeto também é a raiz do projeto.

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
## 📚 Anotações de estudo: Compose, portas e conexão com PostgreSQL

### O que pertence ao Dockerfile e ao Compose?

| Arquivo | Responsabilidade | Exemplo neste projeto |
|---|---|---|
| `Dockerfile` | Define como construir uma imagem | Partir de `tomcat:11.0-jdk17` e, depois, incluir o WAR da aplicação com `COPY` |
| `docker-compose.yaml` | Define como executar e conectar os serviços | Tomcat, PostgreSQL, portas, variáveis, volumes e dependências |
| `pom.xml` | Declara as bibliotecas e a construção do projeto Java | Hibernate e driver JDBC do PostgreSQL |


### Mapeamento de portas

No serviço PostgreSQL:

```yaml
ports:
  - "127.0.0.1:${POSTGRES_PORT:-5433}:5432"
```

Aqui o sinal `:-` é um **operador de valor padrão**. Ou seja: use `POSTGRES_PORT`, mas caso a variável não esteja
definida ou for vazia, use `5433`.

Sem a variável `${POSTGRES_PORT:-5433}` no `.env`, a sintaxe de ***ports*** seria:

```yaml
ports:
  - "127.0.0.1:5433:5432"
```

| Parte | Significado                                                         |
|---|---------------------------------------------------------------------|
| `127.0.0.1` | Publica a porta apenas no endereço local do computador              |
|`${POSTGRES_PORT:-5433}`| Indicador de variável de porta Postgre com valor padrão alternativo |
| `5433` | Porta pela qual o computador acessa o banco                         |
| `5432` | Porta em que o PostgreSQL escuta dentro do container                |

> A porta publicada **pode ser diferente da porta interna**.
Por exemplo: `9000:8080` publicaria o Tomcat em `localhost:9000`, mantendo o servidor na porta interna `8080`.
Mudar o mapeamento não muda a porta em que o programa escuta dentro do container.


### DB_URL com valores para IntelliJ e para Tomcat

O endereço de `DB_URL` pode ter valores diferentes em cada processo:

| Ambiente                                           | Quem fornece a `DB_URL` | Valor de exemplo |
|----------------------------------------------------|---|---|
| 🖥️ Teste JUnit no IntelliJ (interno)               | `.env`, lido pelo `Dotenv` | `jdbc:postgresql://localhost:5433/postgresbookdb` |
| 📡 Aplicação dentro do container Tomcat (servidor) | `environment` do serviço no Compose | `jdbc:postgresql://postgres:5432/postgresbookdb` |

O nome `postgres` é o nome do serviço, **definido na rede do Compose**. O teste local usa a porta publicada em `localhost`
e o Tomcat, `localhost` usa a porta `PostgreSQL`.

No projeto, o Compose define explicitamente o endereço interno para o Tomcat:

```yaml
environment:
  DB_URL: jdbc:postgresql://postgres:5432/${POSTGRES_DB:?Defina POSTGRES_DB}
```


------

**Fabio Peretti Guimarães | tarefa Ebac mod 39 | OUT 2026**
