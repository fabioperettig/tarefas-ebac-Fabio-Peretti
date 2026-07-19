CREATE TABLE Produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    valor NUMERIC(12,2) NOT NULL CHECK (valor >= 0),
    qtd_estoque INT NOT NULL DEFAULT 0 CHECK (qtd_estoque >= 0),
    em_estoque BOOLEAN DEFAULT TRUE,
    em_oferta BOOLEAN DEFAULT FALSE
);