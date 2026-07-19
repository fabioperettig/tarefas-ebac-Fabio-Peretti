
SELECT * FROM Cliente;
SELECT * FROM Produto;
SELECT * FROM Venda;

SELECT c.nome, p.nome, v.qtd
FROM Venda v
JOIN Cliente c ON v.cliente_id = c.id
JOIN Produto p ON v.produto_id = p.id;