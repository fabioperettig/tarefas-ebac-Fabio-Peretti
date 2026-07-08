![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

# ☕ Estudo PostgreSQL

O PostgreSQL (ou “Postgres”) é um **Sistema de Gerenciamento de Banco de Dados Relacional (SGBD)** que organiza dados em tabelas, compostas por linhas e colunas, que podem ser relacionadas entre si por meio de chaves, como as famosas chaves primárias e estrangeiras.

## 🖲️ O que é um Banco de Dados?

**Um banco de dados** é um sistema utilizado para armazenar e organizar informações de forma estruturada. Por meio de um **SGBD**, é possível inserir, consultar, atualizar, remover e relacionar dados utilizando a linguagem **SQL** (Structured Query Language), tornando o gerenciamento das informações mais seguro e eficiente.<br><br>

## Tipos de dados no PostgreSQL

O PostgreSQL oferece uma grande variedade de tipos de dados, desde os mais comuns utilizados no dia a dia até recursos avançados para aplicações específicas. Essa flexibilidade é um dos motivos pelos quais ele é considerado um dos SGBDs mais completos do mercado.

<details><summary><b>Tipos de dados</b></summary>

````
Tipos mais utilizados
├── VARCHAR   → Texto
├── INT       → Números inteiros
├── NUMERIC   → Valores decimais
├── BOOLEAN   → Verdadeiro/Falso
├── DATE      → Datas
└── TIMESTAMP → Data e hora

Tipos avançados
├── JSON / JSONB
├── UUID
├── ARRAY
├── BYTEA
└── Tipos customizados

Extensões
└── PostGIS (dados geográficos)
````
</details>
<br>

>Neste estudo, utilizaremos principalmente os tipos **INT, VARCHAR e TIMESTAMP**, suficientes para compreender os conceitos fundamentais de modelagem e manipulação de dados.

## 💻 Exemplo prático

O exemplo abaixo demonstra como uma aplicação Java pode realizar operações básicas (CRUD) em um banco de dados PostgreSQL utilizando a API JDBC. Para estabelecer a comunicação com o banco, três componentes são fundamentais:

* **Connection:** representa a conexão ativa com o banco de dados.

* **DriverManager:** responsável por criar essa conexão a partir da URL, usuário e senha.

* **PreparedStatement:** prepara e executa comandos SQL de forma segura, permitindo a passagem de parâmetros e ajudando a evitar problemas como SQL Injection.


````java
public void save (User user) {
    String sql = "INSERT INTO users (name, mail) VALUES (?, ?)";

    try(Connection connection = DriverManager.getConnection(URL, USER, PASS);
        PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, user.getName());
        statement.setString(2, user.getMail());
        statement.executeUpdate();

        System.out.printf("\nUser %s add.", user.getName());

    }catch (Exception e) {
        e.printStackTrace();
    }
}

public List<User> list() {
    List<User> userList = new ArrayList<>();
    String sql = "SELECT * FROM users";

    try(Connection connection = DriverManager.getConnection(URL, USER, PASS);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery()) {

        while(resultSet.next()) {
            String name = resultSet.getString("name");
            String mail = resultSet.getString("mail");

            User user = new User(name, mail);
            userList.add(user);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return userList;
}

public void delete(String name) {
    String sql = "DELETE FROM users WHERE NAME = ?";

    try(Connection connection = DriverManager.getConnection(URL, USER, PASS);
    PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, name);
        statement.executeUpdate();

        System.out.printf("\nUser %s deleted.", name);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
````


## Comunicação via String

<details><summary><b>Comunicação String</b></summary>

````
Java
   │
   │ SQL (String)
   ▼
JDBC Driver
   │
   ▼
PostgreSQL
   │
   ▼
Tabelas
````
</details>

<br>Quando você envia um comando para o PostgreSQL, você envia uma String (ex: "SELECT * FROM usuarios;"). Isso acontece por três motivos principais:

* Universalidade do SQL: A linguagem SQL (Structured Query Language) é baseada em texto humano para ser universal. Qualquer linguagem de programação sabe criar e ler Strings.

* Protocolo de Rede: O driver JDBC empacota a consulta SQL, envia ao servidor PostgreSQL (pela rede ou localmente) e o banco traduz esse texto em instruções internas.

* Camada de Abstração: Usar texto evita que o seu programa precise entender como o Postgres gerencia memória internamente. O texto é a interface padronizada.

## PostgreSQL x pgAdmin x psql

A relação é de Motor (PostgreSQL) e Painel de Controle (pgAdmin). 

PostgreSQL: É o banco de dados real. Ele roda em segundo plano, não tem "cara", é apenas o serviço processando e guardando os dados.

pgAdmin: É uma ferramenta de interface gráfica (software com telas, botões e menus) feita especificamente para você gerenciar o PostgreSQL visualmente. Com ele, você clica para criar tabelas, visualiza linhas e digita seus comandos SQL sem precisar usar o terminal prego do sistema operacional.

````
PostgreSQL
→ O motor do banco.

psql
→ Cliente via terminal.

pgAdmin
→ Cliente gráfico.

````

## Vantagens e Sinergia entre PostgreSQL e Java

A combinação de Java com PostgreSQL é um padrão de mercado gigantesco (especialmente no ambiente corporativo). As principais vantagens são:

* Driver JDBC Maduro: O driver que conecta o Java ao Postgres é extremamente otimizado, seguro e atualizado constantemente.

* Ecossistema Spring (JPA/Hibernate): Frameworks Java mapeiam classes do Java para tabelas do Postgres quase sem esforço. O suporte a recursos avançados do Postgres (como JSONB) dentro do Java é excelente.

* Foco em Enterprise: Ambos foram feitos para aguentar sistemas pesados, milhões de acessos e alta concorrência. É um casamento perfeito de estabilidade.

* Tipagem Forte: O Java é uma linguagem fortemente tipada e o Postgres é um banco rigidamente tipado. Isso reduz drasticamente erros de dados inválidos entre o código e o armazenamento.

* Pool de Conexões: Bibliotecas como HikariCP mantêm conexões abertas para evitar o custo de criar uma nova conexão a cada requisição.