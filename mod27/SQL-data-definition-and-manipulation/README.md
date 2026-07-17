![SQL](https://img.shields.io/badge/SQL-005687?style=for-the-badge&logo=ibm&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

# Exemplo Database SQL – DDL e DML
Este é um pequeno estudo de comandos básicos de Structured Query Language (SQL), dividindo o estudo entre DDL (Data Definition Language) e DML (Data Manipulation Language).

## 📖 Data Definition Language
DDL é a categoria de comandos que **cuidam da estrutura do banco de dados**, interagindo diretamente com objetos e tabelas do banco. São comandos que definem onde e como as informações serão armazenadas, preparando o terreno para os comandos do tipo DML.

* **CREATE:** Usado para criar novos objetos, como tabelas, bancos de dados e índices;
* **ALTER:** Modifica a estrutura de um objeto existente (adicionando uma nova coluna);
* **DROP:** Remove um objeto do banco de dados permanentemente.

Um pequeno exemplo da criação de uma tabela, após o comando ***CREATE DATABASE meu_database***:
````SQL
CREATE TABLE Clientes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    idade INT CHECK (idade > 0 AND idade < 120),
    sexo VARCHAR (10),
    email VARChAR(255) NOT NULL,
    data_nascimento DATE,
    cadastro_ativo BOOLEAN DEFAULT TRUE
);
````
Note que a tabela criada contém o dado 'sexo' no estilo VARCHAR de até 10 caracteres, onde a ideia era escrever 'Masculino' ou 'Feminino'. Mas, para otimizar o preenchimento do DB e evitar dados desnecessariamente extensos, determinou-se a troca do TYPE para CHAR(1).

São para mudanças como esta que o comando **ALTER** serve, evitando a exclusão completa da tabela através do comando ***DROP TABLE Clientes***, com todos os dados sendo perdidos permanentemente e refazer todo o trabalho com o TYPE novo.
````SQL
ALTER TABLE Clientes
ALTER COLUMN sexo CHAR(1);
````

## 📝 Data Manipulation Language

Já os comandos DMLs focam em gerenciar as informações, registros e conteúdos armazenados, após um DDL bem feito.

* INSERT: Adiciona novos registros nas tabelas;
* UPDATE: Altera dados existentes;
* DELETE: Remove cadastros completos ou dados específicos de uma coluna.

Um pequeno exemplo da inserção de dados, após o comando ***CREATE TABLE Clientes***:
````SQL
-- Exemplo de INSERT unitário
INSERT INTO Clientes (nome, idade, sexo, email, data_nascimento)
VALUES ('Fabio Peretti', 33, 'M', 'fabio@mail.com', '1992-10-31');

-- Exemplo de múltiplos INSERTs
INSERT INTO Clientes (nome, idade, sexo, email, data_nascimento)

VALUES
('João Novato', 38, 'M', 'jNewbie@tsmail.com', '1988-09-23'),
('Laura Caixão', 45, 'F', 'bGoth@tsmail.com', '1981-10-31'),
('Don Lotário', 38, 'M', 'dLothario@tsmail.com', '1996-06-12'),
('Dina Caliente', 38, 'M', 'dCaliente@tsmail.com', '1997-08-08');
````
Note que alguns dados inseridos não foram preenchidos corretamente. A princípio, a intuição seria: apagar os cadastros com dados errados e preenchê-los novamente um a um, demandando esforço e gasto de tempo desnecessário.

São para cenários como este que o comando ***UPDATE*** mostra a facilidade e a necessidade de saber um bom repertório DML para o seu database SQL.
````SQL
UPDATE Clientes SET email = 'fabio@tsmail.com'
WHERE nome = 'Fabio Peretti';

-- Busca apenas clientes do sexo feminino
SELECT * FROM Clientes WHERE sexo = 'F' ;

-- Busca todas as pessoas cujo nome
-- começa com "D" em idade decrescente
SELECT nome, email FROM Clientes
WHERE nome LIKE 'D%' ORDER BY idade DESC;

UPDATE Clientes SET sexo = 'F', idade = 29
WHERE nome = 'Dina Caliente';
````
Mas utilizar o comando **"UPDATE Clientes SET email = ..."** sem uma condição pode comprometer todo o database, pois todos os dados seriam atualizados com o mesmo valor. Por isso que é tão importante o uso da condicional ***WHERE*** que limita a mudança de dados apenas em condições específicas.

Sendo esta a estrutura básica para a atualização de dados:
````SQL
UPDATE nome_da_tabela
SET coluna1 = novo_valor1, coluna2 = novo_valor2
WHERE condicao;
````
O comando ***WHERE*** aceita inúmeros tipos de informação para usar como condicional:
* **=** Igual a;
* **<> ou !=**: Diferente de;
* **>** Maior que;
* **<** Menor que;
* **>=** Maior ou igual a;
* **<=** Menor ou igual a;

Além de operadores lógicos como **OR**, **AND**, **NOT**, **BETWEEN**. Um operador bastante útil também é o comando **LIKE** que busca dados não exatamente iguais, mas que **possuem algo**, como no exemplo anterior **"SELECT nome, email FROM Clientes WHERE nome LIKE 'D%'"**

Agora, caso a intenção seja realmente apagar os dados, basta usar o comando ***DELETE*** junto com a condicional ***WHERE***
````SQL
DELETE FROM Clientes WHERE nome = 'Don Lotário';
````
