-- CREATE DATABASE EBACdatabase

CREATE TABLE Produto(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    descrição VARCHAR(255),
    preço INTEGER,
    estoque INTEGER,
    em_estoque BOOLEAN
);