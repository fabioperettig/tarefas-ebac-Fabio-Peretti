
UPDATE Produto 
SET estoque = 0, em_estoque = FALSE 
WHERE id IN (6,7, 8, 9);

DELETE FROM Produto 
WHERE estoque = 0
OR em_estoque = FALSE;