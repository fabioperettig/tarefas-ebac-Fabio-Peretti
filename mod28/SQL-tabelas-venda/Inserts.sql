-- ==========================
-- CLIENTES
-- ==========================
INSERT INTO Cliente (nome, sexo, cpf, endereco)
VALUES
('Ana Silva', 'F', '12345678901', 'Rua das Flores, 100'),
('Bruno Souza', 'M', '23456789012', 'Av. Brasil, 250'),
('Carla Lima', 'F', '34567890123', 'Rua Central, 45'),
('Diego Alves', 'M', '45678901234', 'Rua do Sol, 80'),
('Fernanda Costa', 'F', '56789012345', 'Av. Paulista, 1500');

-- ==========================
-- PRODUTOS
-- ==========================
INSERT INTO Produto (nome, valor, qtd_estoque, em_estoque, em_oferta)
VALUES
('Notebook', 4500.00, 10, TRUE, FALSE),
('Mouse Gamer', 150.00, 25, TRUE, TRUE),
('Teclado Mecânico', 380.00, 15, TRUE, FALSE),
('Monitor 27"', 1200.00, 8, TRUE, FALSE),
('Headset', 280.00, 12, TRUE, TRUE);

-- ==========================
-- VENDAS
-- ==========================
INSERT INTO Venda (cliente_id, produto_id, qtd, valor_unitario, percentual_desconto)
VALUES
(1, 3, 1, 380.00, 0),
(2, 1, 1, 4500.00, 5),
(3, 5, 2, 280.00, 10),
(4, 2, 1, 150.00, 0),
(5, 4, 1, 1200.00, 15);