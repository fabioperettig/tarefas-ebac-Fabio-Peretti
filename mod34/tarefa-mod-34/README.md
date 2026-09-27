![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![ApacheCassandra](https://img.shields.io/badge/cassandra-%231287B1.svg?style=for-the-badge&logo=apache-cassandra&logoColor=white)
![Redis](https://img.shields.io/badge/redis-%23DD0031.svg?style=for-the-badge&logo=redis&logoColor=white)
![Curso EBAC](https://img.shields.io/badge/Curso--EBAC-235789?style=for-the-badge)

# 📚☕️ Tarefa Módulo 34 - Banco de dados Não Relacional

## Relacional vs Não Relacional

Um banco **relacional**, como o PostgreSQL, organiza dados em tabelas com linhas e colunas. Chaves primárias identificam registros; chaves estrangeiras podem ligar tabelas e garantir que essas referências sejam válidas. Usamos SQL para consultar e manipular os dados. [Conceitos do PostgreSQL](https://www.postgresql.org/docs/16/tutorial-concepts.html).

Imagine uma loja com duas tabelas:

| clientes: id | nome |
| --- | --- |
| 1 | Fábio |

| pedidos: id | cliente_id | total |
| --- | --- | --- |
| 101 | 1 | 150.00 |
| 102 | 1 | 80.00 |

O nome fica em `clientes`, e os pedidos fazem referência ao cliente. Separar informações assim ajuda a evitar repetição: é uma ideia da **normalização**. Um `JOIN` reúne os dados na consulta:

```sql
SELECT c.nome, p.id, p.total
FROM clientes c
JOIN pedidos p ON p.cliente_id = c.id;
```

**NoSQL** é um termo usado para diferentes modelos não relacionais, frequentemente interpretado como “Not Only SQL”. Não é um único tipo de banco: existem modelos de chave-valor, documentos, grafos e famílias de colunas.

Neste estudo, veremos Redis, com chaves associadas a estruturas de dados, e Cassandra, com tabelas distribuídas modeladas conforme as consultas. **NoSQL não significa ausência de estrutura:** Cassandra tem tabelas e tipos definidos, mas não oferece o modelo de relacionamentos do PostgreSQL. [Tipos do Redis](https://redis.io/docs/latest/develop/data-types/) e [modelagem do Cassandra](https://cassandra.apache.org/doc/stable/cassandra/developing/data-modeling/intro.html).

## 2. PostgreSQL: transações e relacionamentos

Além das consultas com relacionamentos, o PostgreSQL oferece transações: várias operações podem formar uma unidade que é confirmada com `COMMIT` ou desfeita com `ROLLBACK`.

Por exemplo, registrar um pedido e atualizar seu estoque dentro da mesma transação permite confirmar as duas alterações juntas. Se houver um problema antes da confirmação, elas podem ser desfeitas.

As propriedades **ACID** descrevem garantias de transações:

- **Atomicidade:** todas as operações da transação são confirmadas, ou nenhuma.
- **Consistência:** as regras de integridade definidas no banco são preservadas.
- **Isolamento:** controla a interação entre transações simultâneas; há diferentes níveis.
- **Durabilidade:** alterações confirmadas devem persistir, conforme as garantias e configurações do banco.

Isso não significa que todo NoSQL seja incapaz de oferecer transações: as garantias variam entre produtos e operações. [Transações no PostgreSQL](https://www.postgresql.org/docs/current/tutorial-transactions.html).

## 3. Redis: acesso rápido por chave

O Redis trabalha principalmente com dados **em memória RAM**, favorecendo operações de baixa latência. Pense em uma chave como `cliente:1:nome` associada ao valor `Fábio`. Ele também oferece estruturas como hashes, listas, conjuntos e conjuntos ordenados. [Visão geral do Redis](https://redis.io/about/) e [tipos de dados](https://redis.io/docs/latest/develop/data-types/).

Exemplo para executar no `redis-cli`, conectado a um Redis:

```text
SET cliente:1:nome "Fábio"
GET cliente:1:nome

SET cache:produto:10:preco "59.90" EX 60
GET cache:produto:10:preco
```

O primeiro `GET` retorna o nome. No segundo exemplo, `EX 60` faz a chave expirar após 60 segundos: esse prazo é chamado de **TTL** (*Time To Live*). Após expirar, a chave não será encontrada. [Comando SET](https://redis.io/docs/latest/commands/set/).

Aplicações típicas incluem cache, sessões de usuários, contadores e rankings. Um **cache** guarda uma cópia temporária de uma informação para acelerar acessos repetidos. Exemplo didático:

1. A aplicação Java procura o preço no Redis.
2. Se encontrar, utiliza o valor armazenado.
3. Se não encontrar, consulta o PostgreSQL e guarda uma cópia no Redis com TTL.

É preciso decidir como atualizar ou invalidar esse cache quando o preço mudar: até lá, a cópia pode estar desatualizada.

**Redis não é apenas cache e não significa “nunca salva em disco”.** Pode usar snapshots RDB e registro de operações AOF. A possibilidade de perder alterações em uma falha depende da configuração de persistência. [Persistência do Redis](https://redis.io/docs/latest/operate/oss_and_stack/management/persistence/).

## 4. Cassandra: dados distribuídos em grande escala

O Apache Cassandra é um banco NoSQL de **famílias de colunas** (*wide-column*), projetado para distribuir dados entre servidores. Cada instância é um **nó**; o conjunto forma um **cluster**. Replicação mantém cópias dos dados em diferentes nós.

Seu foco inclui grandes volumes, muitas escritas e disponibilidade. Crescer adicionando máquinas é chamado de **escalabilidade horizontal**. A continuidade durante falhas depende da replicação e das configurações de leitura e escrita. [Introdução oficial ao Cassandra](https://cassandra.apache.org/_/cassandra-basics).

No Cassandra, começamos pela pergunta: **“Quais consultas a aplicação precisa fazer?”** A estrutura é desenhada para atendê-las. Não há `JOIN` nem chaves estrangeiras; repetir dados entre tabelas pode ser intencional, prática chamada **desnormalização**.

Ele usa **CQL**, uma linguagem parecida com SQL. Exemplo didático, supondo um *keyspace* (espaço que agrupa tabelas) já selecionado:

```sql
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

Aqui, `cliente_id` é a **chave de partição**: agrupa pedidos e determina sua distribuição. `pedido_id` é a **chave de clustering**: distingue e ordena pedidos dentro da partição.

Essa tabela atende à consulta por cliente. Consultar apenas por `pedido_id` pode exigir outra modelagem. Em produção, também é preciso limitar o crescimento das partições, por exemplo agrupando por cliente e período. [Modelagem e chaves no Cassandra](https://cassandra.apache.org/doc/stable/cassandra/developing/data-modeling/intro.html).

O Cassandra permite configurar o **nível de consistência** por operação: quantas réplicas precisam responder. Isso influencia latência, disponibilidade e visibilidade dos dados recentes. Aqui, “consistência” trata da concordância entre réplicas, diferente da consistência das regras de integridade em ACID. [Consistência no Cassandra](https://cassandra.apache.org/_/cassandra-basics).

## 5. Comparação para fixar

| Aspecto | PostgreSQL | Redis | Cassandra |
| --- | --- | --- | --- |
| Modelo principal | Relacional | Chave-valor com estruturas de dados | Famílias de colunas |
| Acesso básico | SQL | Comandos como `SET` e `GET` | CQL |
| Organização | Tabelas, relações e restrições | Chaves e valores de diferentes tipos | Tabelas organizadas por partições |
| Destaque | Relacionamentos e transações | Operações rápidas em memória | Distribuição e grande volume de escritas |
| Exemplo de uso | Clientes, pedidos e estoque | Cache de produtos e sessões | Histórico massivo de eventos |

A tabela sintetiza as características das documentações citadas acima; os usos são exemplos, não regras exclusivas.

**Não existe um vencedor universal.** NoSQL não é automaticamente mais rápido, e um banco relacional também pode crescer e atender muitos usuários. O resultado depende das consultas, do modelo, da infraestrutura e das garantias necessárias.

Em um exemplo de loja, PostgreSQL poderia guardar pedidos, Redis acelerar consultas e Cassandra armazenar um grande histórico de eventos. Não é obrigatório usar os três: cada banco acrescenta trabalho de operação e manutenção.

## 6. Perguntas de revisão

1. Como uma chave estrangeira ajuda a manter a integridade dos dados?
2. O que acontece quando uma chave com TTL expira no Redis?
3. Por que um preço em cache pode ficar desatualizado?
4. Por que precisamos conhecer as consultas antes de modelar no Cassandra?
5. Qual é a diferença entre uma chave de partição e uma chave de clustering?

Se você consegue explicar essas respostas com suas palavras, já tem uma boa base para começar a praticar!
