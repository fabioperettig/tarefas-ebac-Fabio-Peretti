![SQL](https://img.shields.io/badge/SQL-005687?style=for-the-badge&logo=ibm&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

# Exemplo Database SQL – DDL e DML
Este é um pequeno estudo de comandos básicos de Structured Query Language (SQL), dividindo o estudo entre DDL (Data Definition Language) e DML (Data Manipulation Language).

## Data Definition Language
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
MODIFY COLUMN sexo CHAR(1);
````

## Data Manipulation Language

````SQL
-- Exemplo de INSERT unitário
INSERT INTO Clientes (nome, idade, sexo, email, data_nascimento)
VALUES ('Fabio Peretti', 33, 'M', 'fabio@mail.com', '1992-10-31');

-- Exemplo de múltiplos INSERTs
INSERT INTO Clientes (nome, idade, sexo, email, data_nascimento)

VALUES
('João Novato', 38, 'M', 'jNewbie@tsmail.com', '1988-09-23'),
('Laura Caixão', 45, 'F', 'bGoth@tsmail.com', '1981-10-31')
('Don Lotário', 38, 'M', 'dLothario@tsmail.com', '1996-06-12')
('Dina Caliente', 38, 'F', 'dCaliente@tsmail.com', '1997-08-08');
````
