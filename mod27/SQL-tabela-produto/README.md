![SQL](https://img.shields.io/badge/SQL-005687?style=for-the-badge&logo=ibm&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

# Exemplo Database SQL – DDL e DML
Este é um estudo sobre Structured Query Language (SQL), apresentando comandos básicos de criação e manipulação de tabelas, além de inserção emanipulação de dados sob condicionais. Para uma melhor compreensão, o estudo foi dividido o entre comandos de categoria DDL e DML. O estudo também apresenta os comandos utilizados no estudo, além de prints para visualização da manipulação real.

> A manipulação foi feita não através da interface PgAdmin, mas sim do próprio terminal via PSQL. Como o foco da lição são prints que mostram a manipulação acontecendo fora de IDE/README, é possível conferir resumidamente todos os prints abaixo:

[Print 01 DDL – Criação da tabela Produto](www.google.com);<br>
[Print 02 DDL – Alteração da tabela Produto](www.google.com);<br>
[Print 03 DDL – Exclusão da tabela Produto](www.google.com);<br>
[Print 04 DML – Inserção de dados à tabela](www.google.com);<br>
[Print 05 DML – Atualização de dados específicos](www.google.com);<br>
[Print 06 DML – Exclusão de dados sob condicionais](www.google.com).<br>

## 📖 Data Definition Language
DDL é a categoria de comandos relacionadas à **estrutura do banco de dados**, interagindo diretamente com objetos e tabelas do banco. São comandos que definem onde e como as informações serão armazenadas, preparando o terreno para os comandos do tipo DML.

* **CREATE:** Usado para criar novos objetos, como tabelas, bancos de dados e índices;
* **ALTER:** Modifica a estrutura de um objeto existente (adicionando uma nova coluna);
* **DROP:** Remove um objeto do banco de dados permanentemente.

Exemplo de CREATE para a criação de uma tabela, também disponível via PSQL [nesta imagem](www.google.com).
````SQL
CREATE TABLE Produto(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    descrição VARCHAR(255),
    preço INTEGER,
    estoque INTEGER,
    em_estoque BOOLEAN
);
````

Note que a tabela criada contém o dado 'preço' no estilo INTEGER, não sendo a melhor escolha para registrar preços por exigirem casas decimais. Além disso, também é possível predefinir um valor padrão como, por exemplo, todo novo registro já ser inserido no database com o valor "em_estoque" como verdadeiro.

São para mudanças como esta que o comando **ALTER** serve, evitando a exclusão completa da tabela e retrabalho com o TYPE novo. Um exemplo no código abaixo e também disponível via PSQL [nesta imagem](www.google.com).
````SQL
ALTER TABLE Produto 
    ALTER COLUMN preço TYPE DECIMAL(10,2), 
    ALTER COLUMN em_estoque SET DEFAULT TRUE;
````

Mas, caso seja necessário a exclusão da tabela criada, o comando ***DROP TABLE ...*** resolve facilmente. Um exemplo no código abaixo e também disponível via PSQL [nesta imagem](www.google.com).
````SQL
DROP TABLE Produto;
````

## 📝 Data Manipulation Language

Após a definição dos campos da tabela, é hora de cuidar da **inserção dos dados**, os comandos DMLs entram exatamente aí, para gerenciar os registros cadastrados no database.

* INSERT: Adiciona novos registros nas tabelas;
* UPDATE: Altera dados existentes;
* DELETE: Remove cadastros completos ou dados específicos de uma coluna.

Um pequeno exemplo da inserção de dados, também disponível via PSQL [nesta imagem](www.google.com).
````SQL
-- Exemplo de INSERT unitário
INSERT INTO Produto (nome, descrição, preço, estoque) VALUES
('Smartphone S20', 'Smartphone com tela de 6.5 polegadas e 128GB de armazenamento.', 1499.90, 99),
('Notebook Quantum', 'Computador portátil com processador i5 e 8GB de memória RAM.', 3499, 99),
('Fone Bluetooth Wave', 'Fone de ouvido sem fio com cancelamento de ruído ativo.', 299, 99),
('Smartwatch Horizon', 'Relógio inteligente com monitor cardíaco e contador de passos.', 459, 99),
('Teclado Mecânico Neon', 'Teclado para jogos com iluminação RGB e switches azuis.', 199, 99),
('Mouse Gamer Stealth', 'Mouse ergonômico com sensor óptico de alta precisão e 6000 DPI.', 129, 99),
('Monitor UltraVue', 'Tela LED de 24 polegadas Full HD com taxa de atualização de 75Hz.', 899, 99),
('Caixa de Som Sonic', 'Caixa de som portátil bluetooth à prova d água com 20W RMS.', 249, 99),
('Câmera CamLink 4K', 'Webcam para streaming com resolução Ultra HD e microfone embutido.', 399, 99);
````
Após a inserção de dados, é importante que seja possível também **atualizar os dados da tabela**, usando então o comando ***UPDATE***, alterando qualquer coluna com o novo dado inserido. Mas, é importante ressaltar que utilizar o comando **sem uma condição pode comprometer todo o database**, pois todos os dados serão atualizados com o mesmo valor. Por isso, é importante o uso do comando ***WHERE***, que limita a mudança de dados apenas em condições específicas.

Um exemplo no código abaixo e também disponível via PSQL [nesta imagem](www.google.com).
````SQL
UPDATE Produto SET estoque = 0, em_estoque = FALSE 
WHERE id IN (6,7, 8, 9);
````
O comando ***WHERE*** aceita inúmeros tipos de informação para usar como condicional:
* **=** Igual a;
* **<> ou !=**: Diferente de;
* **>** Maior que;
* **<** Menor que;
* **>=** Maior ou igual a;
* **<=** Menor ou igual a;

Além de operadores lógicos como **OR**, **AND**, **NOT**, **BETWEEN** e **LIKE**.

Por fim, caso a intenção seja realmente apagar os dados, basta usar o comando ***DELETE*** também junto à condicional ***WHERE***. 
````SQL
DELETE FROM Produto WHERE estoque = 0 OR em_estoque = FALSE;
````

E estes são alguns comandos básicos do SQL, mas que já causam impacto suficiente, permitindo que os dados de seu projeto sejam armazenados segura e corretamente.

----

### Fabio peretti Guimarães | Ebac mod 27 | JUL 2026
