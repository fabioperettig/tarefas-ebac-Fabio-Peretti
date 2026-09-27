![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![ApacheCassandra](https://img.shields.io/badge/cassandra-%231287B1.svg?style=for-the-badge&logo=apache-cassandra&logoColor=white)
![Redis](https://img.shields.io/badge/redis-%23DD0031.svg?style=for-the-badge&logo=redis&logoColor=white)
![Curso EBAC](https://img.shields.io/badge/Curso--EBAC-235789?style=for-the-badge)

# 📚☕️ Tarefa Módulo 34 - Banco de dados Não Relacional

## 🎲 Relacional vs Não Relacional

Um Banco de Dados **Relacional**, organiza os dados em tabelas com linhas e colunas tendo como principais recursos de busca as ***Chaves Primárias*** e, para relação de tables, as ***Chaves Estrangeiras***. O exemplo mais conhecido de Banco de Dados relacional, utilizado no curso até então, é o `PostgreSQL`.

### | TB_PRODUTO |

| codigo | id | nome | valor | qtd_estoque |
| --- | --- | --- | --- | --- |
| PROD001 | 1 | Cama King | 799.00 | 8 |
| PROD002 | 2 | Mesa de Jantar | 450.00 | 15 | 

>O foco principal é ter um Banco de Dados "rígido" e organizado na melhor estrutura possível, garantindo que os dados estejam 100% corretos e evitando quaisquer duplicações.

---

Já um Banco de Dados **Não Relacional**, ou ***NoSQL***, é um sistema que persiste e organiza dados **sem usar o formato tradicional de tabelas com linhas e colunas**.

Por isso, ele funciona sem um esquema fixo, sendo possível salvar dados de diferentes formas sem definir uma estrutura rígida. Os dados de um DB NoSQL podem persistir como arquivos JSON, pares de chave-valor, ou grafos. 

Graças a essa característica, são facilmente espalhados por servidores diferentes quando o volume de dados cresce muito.

### Exemplo de um tipo de dadoNoSQL persistido (JSON)

```sql
{
  "_id": "user_98765",
  "nome": "Fabio Peretti",
  "email": "fabioperettig@mail.com",
  "ativo": true,
  "perfil": {
    "idade": 34,
    "cidade": "São Paulo",
    "interesses": ["Java", "COBOL", "Jakarta Persistence"]
  }
}
```
>Aqui, o foco principal é a escalabilidade do Banco de Dados e a velocidade de leitura dos dados peristidos.

## Redis

O `Redis` (Remote Dictionary Server) é uma estrutura de dados que trabalha principalmente **em memória RAM**, ao contrário dos Bancos de Dados tradicionais que persistem dados em disco rígido. Por causa de sua estrutura em RAM, é ideal para cenários que exigem **baixa latência**, atuando com **Sistemas de Cache**.

Ele funciona salvando dados associados a uma chave única (padrão CHAVE-VALOR). No entanto, o "valor" não precisa ser apenas um texto simples, mas sim, estruturas complexas como ***strings, listas, hashes e etc***.

- 

Exemplo para executar no `redis-cli`, conectado a um Redis:

```sql
SET cliente:1:nome "Fábio"
GET cliente:1:nome

SET cache:produto:10:preco "59.90" EX 60
GET cache:produto:10:preco
```

> **POSSIBILIDADE DE PERSISTÊNCIA:** Embora funcione na RAM, o Redis pode salvar cópias dos dados no disco, ou registrar cada alteração em um histórico. Isso garante que os dados não sejam totalmente perdidos se o servidor for reiniciado.

## Cassandra

Já o `Apache Cassandra` é um banco de dados NoSQL de alto desempenho, projetado para lidar com **volumes massivos de dados** sem limites de armazenamento, garantindo um bom desempenho com multi-threading.

Essa robustez é graças a uma **arquitetura descentralizada**: os dados são espalhados em ***nodes***, garantindo que o sistema continue operando, caso um node perca a conexão.

A sintaxe do Cassandra (CQL), é bastante parecida com a sintaxe SQL, embora o modelo de modelagem de dados seja diferente.

```sql
///exemplo CQL
CREATE TABLE pedidos_por_cliente (
    cliente_id int,
    pedido_id int,
    total decimal,
    PRIMARY KEY (cliente_id, pedido_id)
);

INSERT INTO pedidos_por_cliente (cliente_id, pedido_id, total)
VALUES (1, 101, 150.00);

SELECT * FROM pedidos_por_cliente WHERE cliente_id = 1;
```

Neste exemplo, a sintaxe é idêntica ao SQL, mas, a Primary Key possui um significado diferente:

#### 🔑 PRIMARY KEY (cliente_id, pedido_id)

- **Postgre (SQL):** a combinação dos dois valores deve ser única, e ambos são obrigatórios. Não distribui automaticamente os dados em partições.

- **Cassandra (CQL):** `cliente_id` é a chave de partição e `pedido_id` é a chave de clustering, que distingue e ordena os pedidos dentro da partição.

Em ambos os DBs, a combinação `cliente_id` e `pedido_id` identifica um registro. Porém, no Cassandra essa definição **também orienta a distribuição e a organização dos dados**.

## ☕ Integração com Java: frameworks e JPA

Os três bancos conseguem trabalhar com **Jakarta Persistence**, mas alguns precisam de módulos extras dedicado.

| Banco | Integração | Uso típico | Compatibilidade com JPA |
| --- | --- | --- | --- |
| **PostgreSQL** | **Spring Data, JPA + Hibernate ORM** | Entidades, relacionamentos e transações em tabelas relacionais. | É o banco mais adequado para trabalhar com JPA puro. |
| **Redis** | **Spring Data Redis** | Chaves e estruturas de dados, cache e repositórios Redis. | Necessita de APIs e mapeamento próprios do módulo Redis. |
| **Cassandra** | **Spring Data Cassandra** | Tabelas distribuídas, consultas CQL e repositórios Cassandra. | Necessita de APIs e mapeamento próprios do módulo Cassandra. |

>O Jakarta Persistence é uma especificação de persistência **relacional**.

>O Hibernate implementa JPA em ótima compatibilidade com PostgreSQL, mas não tão recomendado para Redis e Cassandra.

>O Spring Data é, atualmente, o mais indicado para ambos os tipo de dados, sejam relacionais, sejam não relacionais.


------

**Fabio Peretti Guimarães | tarefa Ebac mod 34 | SET 2026**
