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
## Anotações de estudo: Compose, portas e conexão com PostgreSQL

### O que pertence ao Dockerfile e ao Compose?

| Arquivo | Responsabilidade | Exemplo neste projeto |
|---|---|---|
| `Dockerfile` | Define como construir uma imagem | Partir de `tomcat:11.0-jdk17` e, depois, incluir o WAR da aplicação com `COPY` |
| `docker-compose.yaml` | Define como executar e conectar os serviços | Tomcat, PostgreSQL, portas, variáveis, volumes e dependências |
| `pom.xml` | Declara as bibliotecas e a construção do projeto Java | Hibernate e driver JDBC do PostgreSQL |

Com apenas `FROM tomcat:11.0-jdk17` no Dockerfile, também seria possível usar `image: tomcat:11.0-jdk17`
no lugar de `build: .` no Compose. Nesse caso, o serviço usaria a imagem pronta diretamente.

### Como ler o mapeamento de portas?

No serviço PostgreSQL:

```yaml
ports:
  - "127.0.0.1:${POSTGRES_PORT:-5433}:5432"
```

Depois da substituição das variáveis, com a porta padrão, a linha equivale a:

```yaml
ports:
  - "127.0.0.1:5433:5432"
```

| Parte | Significado |
|---|---|
| `-` antes das aspas | Marca um item da lista YAML de portas |
| `127.0.0.1` | Publica a porta apenas no endereço local do computador |
| `5433` | Porta pela qual o computador acessa o banco |
| `5432` | Porta em que o PostgreSQL escuta dentro do container |

O caminho é **Mac:5433 → container PostgreSQL:5432**. A porta publicada pode ser diferente da porta interna.
Por exemplo, `9000:8080` publicaria o Tomcat em `localhost:9000`, mantendo o servidor na porta interna `8080`.
Mudar o mapeamento não muda a porta em que o programa escuta dentro do container.

### O que significa o hífen em `${POSTGRES_PORT:-5433}`?

Aqui o `:-` é um **operador de valor padrão**: use `POSTGRES_PORT`; se a variável não estiver definida
ou estiver vazia, use `5433`. Ele é diferente do hífen que marca um item de lista YAML.

| Configuração | Resultado do mapeamento |
|---|---|
| `.env` com `POSTGRES_PORT=5433` | `127.0.0.1:5433:5432` |
| `.env` com `POSTGRES_PORT=5434` | `127.0.0.1:5434:5432` |
| Variável vazia ou ausente de todas as fontes consultadas pelo Compose | `127.0.0.1:5433:5432` |

É possível remover `POSTGRES_PORT` do `.env` e manter a expressão no Compose. Uma variável exportada no terminal
também pode fornecer o valor e tem prioridade sobre o `.env`.

A expressão inteira `${POSTGRES_PORT:-5433}` é substituída pelo valor escolhido. O hífen não faz parte da porta:
`127.0.0.1:-5433:5432` está errado, assim como `${POSTGRES_PORT: 5433}` não é uma expressão válida de valor padrão.
Para fixar a porta sem variável, basta escrever `127.0.0.1:5433:5432`.

### Por que a DB_URL muda entre IntelliJ e Tomcat?

O endereço depende de **onde o Java está executando**. A mesma variável pode ter valores diferentes em cada processo:

| Ambiente | Quem fornece a `DB_URL` | Valor de exemplo |
|---|---|---|
| Teste JUnit no IntelliJ, no Mac | `.env`, lido pelo `Dotenv` | `jdbc:postgresql://localhost:5433/postgresbookdb` |
| Aplicação dentro do container Tomcat | `environment` do serviço no Compose | `jdbc:postgresql://postgres:5432/postgresbookdb` |

O nome `postgres` é o nome do serviço, resolvido na rede do Compose. O teste no Mac usa a porta publicada em `localhost`.
Dentro do container Tomcat, `localhost` apontaria para o próprio container Tomcat, não para o PostgreSQL.

No projeto, o Compose define explicitamente o endereço interno para o Tomcat:

```yaml
environment:
  DB_URL: jdbc:postgresql://postgres:5432/${POSTGRES_DB:?Defina POSTGRES_DB}
```

Já o `.env` usado pelo teste pode conter:

```dotenv
POSTGRES_DB=postgresbookdb
POSTGRES_PORT=5433
DB_URL=jdbc:postgresql://localhost:5433/postgresbookdb
```

Esse trecho ilustra apenas banco, porta e URL; usuário e senha também precisam ser definidos conforme o Compose.
Se mudar a porta publicada para `5434`, atualize também a URL local para `localhost:5434`.
A URL interna do Tomcat continua usando `postgres:5432`.

O `.env` tem dois usos aqui: o Compose o consulta para substituir `${...}`, e o Java o lê por meio da biblioteca
`Dotenv`. O Compose **não envia automaticamente todas as variáveis do `.env` aos containers**; o bloco `environment`
seleciona os valores enviados. A biblioteca `Dotenv` também consulta as variáveis do processo, que têm prioridade
sobre o arquivo. O operador `:?`, usado em `${POSTGRES_DB:?Defina POSTGRES_DB}`, interrompe o Compose se o valor
estiver ausente ou vazio, exibindo a mensagem indicada.

### Por que preciso de PostgreSQL no Compose e no POM?

São componentes diferentes:

| Configuração | O que fornece |
|---|---|
| Compose: `image: postgres:15` | O **servidor PostgreSQL**, que armazena os dados e recebe conexões |
| POM: dependência `org.postgresql:postgresql` | O **driver JDBC**, biblioteca que permite ao Java conversar com o servidor |
| POM: dependência do Hibernate | A implementação JPA que transforma operações como `persist()` em SQL |

```text
DAO → Hibernate → driver JDBC → PostgreSQL no Docker
```

As versões do servidor e do driver são independentes: PostgreSQL `15` não exige um driver de versão `15`.
O driver usa sua própria numeração, como a linha `42.7.x`. O que importa é a compatibilidade entre servidor, driver e Java.
Maven e Compose não escolhem automaticamente versões um a partir do outro.

No projeto anterior com WildFly, o driver não estava no POM porque o Dockerfile copiava o JAR do PostgreSQL
para o servidor, e a aplicação usava um datasource configurado nele. Neste projeto, a aplicação cria a configuração
JPA pelo `ConfigManager`; declarar o driver no POM o disponibiliza também para o JUnit executado fora do servidor.

### Onde o Tomcat participa do teste?

| Execução | Caminho |
|---|---|
| Teste atual, que instancia `LivroDAO` | JUnit no Mac → DAO → Hibernate → PostgreSQL |
| Requisição à aplicação implantada | HTTP → aplicação no Tomcat → DAO → Hibernate → PostgreSQL |

O teste atual não passa pelo Tomcat, mesmo que o servidor esteja aberto. Para executá-lo, é suficiente iniciar o banco:

```bash
docker compose up -d --wait postgres
```

Depois, execute `DaoTest` no IntelliJ. Testar a aplicação implantada no Tomcat é uma verificação adicional,
que envolve o WAR e uma entrada web, como um servlet.

------

**Fabio Peretti Guimarães | tarefa Ebac mod 39 | OUT 2026**
