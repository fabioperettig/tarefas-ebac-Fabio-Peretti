![SQL](https://img.shields.io/badge/SQL-005687?style=for-the-badge&logo=ibm&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

# Sistema de Vendas - PostgreSQL
Este projeto foi desenvolvido como exercício de modelagem de banco de dados utilizando PostgreSQL.

O objetivo foi criar uma estrutura simples de um sistema de vendas, contemplando a criação de tabelas relacionadas, inserção de dados e consultas utilizando JOIN.

## Organização

Em vez de concentrar todo o código em um único arquivo SQL, optei por dividir o projeto em múltiplos arquivos **.sql**, por dois objetivos principais:

* manter o projeto mais organizado, separando cada responsabilidade em seu próprio arquivo;
* praticar a utilização do comando \i do psql, responsável por importar e executar scripts SQL.

<details>
<summary><b><u>Estrutura do projeto</b></u></summary>

[Cliente.sql]()<br>
[Produto.sql]()<br>
[Venda.sql]()<br>
[Inserts.sql]()<br>
[Consultas.sql]()<br>
</details>
<br>
Além de facilitar a manutenção, essa abordagem torna o processo de criação do banco mais próximo da forma como projetos reais costumam ser organizados.
<br><br>

> Como o foco da lição são prints que mostram a manipulação acontecendo fora de IDE/README, é possível conferir resumidamente todos os prints abaixo:

[Print 01 DDL – Criação da tabela Produto](https://github.com/fabioperettig/tarefas-ebac-Fabio-Peretti/blob/main/mod27/SQL-tabela-produto/img/001.png);<br>
[Print 02 DDL – Alteração da tabela Produto](https://github.com/fabioperettig/tarefas-ebac-Fabio-Peretti/blob/main/mod27/SQL-tabela-produto/img/002.png);<br>
[Print 03 DDL – Exclusão da tabela Produto](https://github.com/fabioperettig/tarefas-ebac-Fabio-Peretti/blob/main/mod27/SQL-tabela-produto/img/003.png);<br>
[Print 04 DML – Inserção de dados à tabela](https://github.com/fabioperettig/tarefas-ebac-Fabio-Peretti/blob/main/mod27/SQL-tabela-produto/img/004.png);<br>
[Print 05 DML – Atualização de dados específicos](https://github.com/fabioperettig/tarefas-ebac-Fabio-Peretti/blob/main/mod27/SQL-tabela-produto/img/005.png);<br>
[Print 06 DML – Exclusão de dados sob condicionais](https://github.com/fabioperettig/tarefas-ebac-Fabio-Peretti/blob/main/mod27/SQL-tabela-produto/img/006.png).<br>

## Estrutura das tabelas

A tabela Cliente armazena os dados dos clientes cadastrados, com algumas regras de checagem como aceitar apenas os caractéres "M" e "F" na coluna 'sexo' e CPF definido como ***UNIQUE***, impedindo o cadastro de clientes duplicados.

````SQL
CREATE TABLE Cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    sexo CHAR(1) CHECK (sexo IN ('M', 'F')),
    cpf VARCHAR(11) NOT NULL UNIQUE,
    endereco VARCHAR(255)
);
````

A tabela Produto possui regras de checagem para impedir valores negativos de 'preço' e 'estoque'

````SQL
CREATE TABLE Produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    valor NUMERIC(12,2) NOT NULL CHECK (valor >= 0),
    qtd_estoque INT NOT NULL DEFAULT 0 CHECK (qtd_estoque >= 0),
    em_estoque BOOLEAN DEFAULT TRUE,
    em_oferta BOOLEAN DEFAULT FALSE
);
````

A tabela vendas possui os principais diferenciais deste estudo, pois ela não armazena apenas informações próprias, mas também faz referência ao cliente responsável pela compra e ao produto vendido.

````SQL
CREATE TABLE Venda (
    id SERIAL PRIMARY KEY,
    cliente_id INT NOT NULL,
    produto_id INT NOT NULL,
    qtd INT NOT NULL CHECK (qtd > 0),
    valor_unitario NUMERIC(12,2) NOT NULL CHECK (valor_unitario >= 0),
    percentual_desconto NUMERIC(5,2) DEFAULT 0
        CHECK (percentual_desconto BETWEEN 0 AND 100),
    data_venda TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_venda_cliente FOREIGN KEY (cliente_id) REFERENCES Cliente(id),
    CONSTRAINT fk_venda_produto FOREIGN KEY (produto_id) REFERENCES Produto(id)
);
````

Como ideia para um projeto posterior: o valor unitário é armazenado diretamente na venda para preservar o histórico da transação, mesmo que o preço do produto seja alterado futuramente.

## 🔑 Chaves Primárias (PKs) e Estrangeiras (FKs)

Cada tabela possui uma chave primária ***(PRIMARY KEY)***, responsável por identificar unicamente cada registro e garantindo que nunca existirão dois registros com o mesmo ID.

A tabela **Venda** utiliza duas chaves estrangeiras (***FOREIGN KEY***):

* cliente_id
* produto_id

Essas chaves estabelecem o relacionamento entre as tabelas, onde cada venda “aponta” para um cliente e para um produto já existentes no banco de dados. Isso garante a integridade das informações e impede, por exemplo, que uma venda seja cadastrada para um cliente inexistente.

## JOINs

Após os ***INSERTS*** terem sido realizados corretamente, foi realizada uma consulta utilizando ***INNER JOIN***, reunindo informações que estão distribuídas entre todas as tabelas do projeto.

## Bônus – inicializando .sql via terminal

Por mais que a interface pgAdmin cubra perfeitamente a criação e manipulação de dados e, ainda, de uma forma bastante visual e intuitiva, escolhi ter este projeto desenvolvido em VSCode com .sql separados e executados via PSQL no terminal. Assim, me mantenho em constante contato com a estrutura de um projeto Back-end e fico menos dependente de interfaces.

Após criar o banco de dados **(CREATE DATABASE meu_database)**, os scripts podem ser executados na seguinte ordem:

````sql
\i Cliente.sql
\i Produto.sql
\i Venda.sql
\i Inserts.sql
\i Consultas.sql
````

Assim o projeto pode ser executado de forma padronizada, a visualização se torna menos poluída e comandos importantes podem ser invocados sem a necessidade de reescrever o código.

----

### Fabio peretti Guimarães | Ebac mod 28 | JUL 2026