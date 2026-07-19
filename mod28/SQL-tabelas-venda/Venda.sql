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