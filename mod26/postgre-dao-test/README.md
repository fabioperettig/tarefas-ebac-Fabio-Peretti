![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

# ☕ Estudo PostgreSQL

O PostgreSQL (ou “Postgres”) é um **Sistema de Gerenciamento de Banco de Dados Relacional (SGBD)** que organiza dados em tabelas, compostas por linhas e colunas, que podem ser relacionadas entre si.

## 🖲️ O que é um Banco de Dados?

**Um banco de dados** é um sistema utilizado para armazenar e organizar informações de forma estruturada. Por meio de um **SGBD**, é possível inserir, consultar, atualizar, remover e relacionar dados utilizando a linguagem **SQL** (Structured Query Language), tornando o gerenciamento das informações mais seguro e eficiente.<br><br>

## 📚 Tipos de dados no PostgreSQL

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

## 💻 Exemplo prático

O exemplo abaixo demonstra como uma aplicação Java pode realizar operações básicas (CRUD) em um banco de dados PostgreSQL utilizando a API JDBC. Para estabelecer a comunicação com o banco, três componentes são fundamentais:

* **Connection:** representa a conexão ativa com o banco de dados.

* **DriverManager:** responsável por criar essa conexão a partir da URL, usuário e senha.

* **PreparedStatement:** prepara e executa comandos SQL de forma segura, permitindo a passagem de parâmetros e ajudando a evitar problemas como SQL Injection.


````java
public void save (User user) {

    // SQL que será enviada ao PostgreSQL
    String sql = "INSERT INTO users (name, mail) VALUES (?, ?)";

    // Abre a conexão com o banco
    try(Connection connection = DriverManager.getConnection(URL, USER, PASS);

        // Prepara a instrução SQL
        PreparedStatement statement = connection.prepareStatement(sql)) {

        // Substitui os parâmetros "?" pelos valores do objeto User
        statement.setString(1, user.getName());
        statement.setString(2, user.getMail());

        // Executa o INSERT
        statement.executeUpdate();
    
    }catch (Exception e) {
        e.printStackTrace();
    }
}
````

<details><summary><b>SELECT * FROM</b></summary>

````java
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
````
</details>

<details><summary><b>DELETE FROM ... WHERE NAME = ?</b></summary>

```` java
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
</details>

## 🔍 Como o SQL chega ao PostgreSQL

Quando uma aplicação Java precisa consultar ou modificar dados em um banco PostgreSQL, ela não envia métodos, objetos ou classes Java. Toda a comunicação acontece por meio de comandos SQL escritos em formato de texto (String).

```` java
String sql = "SELECT * FROM users WHERE id = ?";
````

Embora seja armazenado como uma String no Java, esse texto representa uma instrução escrita na linguagem SQL, capaz de ser interpretada pelo PostgreSQL. Ao executar o comando, o driver JDBC é responsável por enviar esse texto ao servidor PostgreSQL, que interpreta a consulta, localiza os dados solicitados e devolve o resultado para a aplicação.

<details><summary><b>Comunicação String</b></summary>

````
Java
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

<br>

O PostgreSQL não entende classes, objetos ou métodos Java. A comunicação entre a aplicação e o banco acontece por meio da linguagem SQL, composta por palavras reservadas como SELECT, INSERT, UPDATE, DELETE e WHERE.

No lado do Java, essas instruções são armazenadas em uma String. O JDBC atua como intermediário, enviando esse texto ao PostgreSQL, que interpreta o comando SQL e executa a operação solicitada.

## PostgreSQL e JDBC 🤝

Java e PostgreSQL são tecnologias independentes. Enquanto o Java trabalha com classes, objetos e métodos, o PostgreSQL entende apenas comandos escritos na linguagem SQL. Por isso, no Java essas instruções são representadas como Strings e enviadas ao banco por meio do JDBC, responsável por estabelecer a comunicação entre a aplicação e o PostgreSQL.

Em outras palavras, o JDBC é responsável por: abrir a conexão com o banco; enviar a consulta SQL; receber os resultados; disponibilizar os resultados para que a aplicação os converta novamente em objetos Java.

````
Java
  │
  ▼
SQL (String)
  │
  ▼
JDBC
  │
  ▼
PostgreSQL
  │
  ▼
ResultSet
  │
  ▼
Java
````

Além da comunicação por meio do JDBC, a combinação entre Java e PostgreSQL é amplamente utilizada no mercado por oferecer uma integração madura, segura e de alto desempenho.

* JPA/Hibernate: Frameworks Java mapeiam classes para tabelas quase sem esforço. O suporte a recursos avançados do Postgres (como JSONB) dentro do Java é excelente.

* Foco em Enterprise: Ambos foram feitos para aguentar sistemas pesados, acessos quase ininterruptos e alta concorrência com grande estabilidade.

* Tipagem Forte: O Java é uma linguagem fortemente tipada e o Postgres é um banco rigidamente tipado, reduzindo drasticamente erros de dados inválidos entre o código e o armazenamento.

* Pool de Conexões: Bibliotecas como HikariCP mantêm conexões abertas para evitar o custo de criar uma nova conexão a cada requisição.

>Como o PostgreSQL utiliza SQL, uma linguagem padrão do mercado, aplicações Java conseguem se comunicar com o banco de forma simples e consistente por meio do JDBC.

## PostgreSQL x pgAdmin x psql

Embora sejam frequentemente utilizados juntos, **PostgreSQL, pgAdmin e psql** possuem funções diferentes:

* **PostgreSQL:** é o Sistema de Gerenciamento de Banco de Dados (SGBD). Ele executa em segundo plano, armazena os dados e processa os comandos SQL enviados pela aplicação.

* **pgAdmin:** é uma interface gráfica desenvolvida para administrar o PostgreSQL. Nele, é possível criar bancos, tabelas e executar consultas por meio de menus e formulários, sendo ideal para uma administração mais visual e amigável para o usuário.

* **psql:** é o cliente oficial de linha de comando do PostgreSQL. Com ele, é possível ter acesso completo ao banco de dados, executar comandos SQL, criar tabelas, consultar registros e administrar o servidor, mas, sem depender de interface gráfica, pois tudo é feito via terminal do sistema operacional.

## ☑️ Conclusão

O PostgreSQL é um verdadeiro ecossistema de gerenciamento de dados, permitindo armazenar e administrar qualquer tipo de recurso, desde tipos primitivos até dados geoespaciais, diretamente via SQL.

Também possui uma sincronia poderosa quando unido a linguagens tipadas, como o Java, criando um sistema sólido, dinâmico e altamente seguro.

Além disso, ele é acessível para todo tipo de profissional: desde o usuário de interface até o de terminal, apresentando e gerenciando dados com clareza, seja pelo clique do mouse ou por linhas de comando.

----

### Fabio peretti Guimarães | Ebac mod 26 | JUL 2026