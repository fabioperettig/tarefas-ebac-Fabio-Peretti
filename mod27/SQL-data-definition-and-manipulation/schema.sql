-- CREATE DATABASE EbacDB;

CREATE TABLE Clientes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    idade INT CHECK (idade > 0 AND idade < 120),
    sexo CHAR (1),
    email VARCHAR(255) NOT NULL,
    data_nascimento DATE,
    cadastro_ativo BOOLEAN DEFAULT TRUE
);
