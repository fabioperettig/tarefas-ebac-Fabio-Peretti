CREATE TABLE Cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    sexo CHAR(1) CHECK (sexo IN ('M', 'F')),
    cpf VARCHAR(11) NOT NULL UNIQUE,
    endereco VARCHAR(255)
);