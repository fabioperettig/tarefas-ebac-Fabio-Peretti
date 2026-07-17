
UPDATE Clientes SET email = 'fabio@tsmail.com'
WHERE nome = 'Fabio Peretti';

-- Buscar apenas clientes do sexo feminino
SELECT * FROM Clientes WHERE sexo = 'F' ;

-- Buscar todas as pessoas cujo nome
-- começa com "D" em idade decrescente
SELECT nome, email FROM Clientes
WHERE nome LIKE 'D%' ORDER BY idade DESC;

DELETE FROM Clientes WHERE nome = 'Don Lotário'
