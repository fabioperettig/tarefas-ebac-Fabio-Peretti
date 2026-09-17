![Java](https://img.shields.io/badge/java-21a8d5.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Lambda](https://img.shields.io/badge/Lambda-1d72b4?style=for-the-badge)
![Estudo](https://img.shields.io/badge/Estudo-e89d41?style=for-the-badge)

# 📚 Estudo ORMs e JPA

O JPA *(Java Persistence API)*, atualmente chamado de Jakarta Persistence, é a especificação padrão do Java para gerenciar a persistência de dados em um DB relacional, usando o conceito de ORM (Object-Relational Mapping). Em vez de escrever código SQL complexo manualmente dentro do seu código Java, o JPA permite **mapear as classes Java diretamente para as tabelas do banco de dados**.

## 🔍 O que muda em relação ao JDBC

Em um modelo de entidade Cliente com três atributos, se o padrão usado for JDBC, será necessário atrelar comandos SQL à Strings de forma manual e pré compilá-los com `PreparedStatment`:

````java
public class Cliente {

    private Long id;
    private String nome;
    private String email;

}

---------------------------------------

String sql = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";
try (PreparedStatement pstm = conexao.prepareStatement(sql)) {
    
    pstm.setString(1, usuario.getNome());
    pstm.setString(2, usuario.getEmail());

    pstm.executeUpdate();
}

---------------------------------------

Cliente cliente = new Cliente();

cliente.setId(rs.getLong("id"));
cliente.setNome(rs.getString("nome"));
cliente.setEmail(rs.getString("email"));

````
Com JPA/Hibernate, boa parte do trabalho mecânico do JDBC passa a ser feita pelo ORM, que mapeia a classe e já endereça cada elemento a uma tabela de banco de dados, através de `annotations`, **automatizando todo o processo**:

````java
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;
}

---------------------------------------

entityManager.persist(cliente);

````

Sendo assim, a ORM atua ***entre*** o seu código Java e o banco, mantendo um “mundo de objetos” sincronizado com o “mundo relacional”.

| **Java**|**Banco**|
|----|----|
| Classe | Tabela |
| Objeto | Registro |
| Atributo | Coluna |
| List<Produto> | Relacionamento |
| Referência para outro objeto | Foreign Key |

## @ Alguns das Principais Annotations

Cada annotations possui uma instrução clara em um projeto DAO.

|Annotation|Objetivo|
|----|----|
|@Entity|Transformar classe em entidade|
|@Table|Define qual tabela aquela entidade representa|
|@Column|Mapeia um atributo para uma coluna|
|@Id|Define a Primary Key da entidade|
|@GeneratedValue|Define que o ID será gerado automaticamente|
|@SequenceGenerator| Configura uma sequence do banco|
|@ManyToOne|Muitos produtos pertencem a uma categoria|
|@OneToMany|Uma categoria possui muitos produtos (Collection)|

Embora o uso de ORMs seja o padrão atual mais utilizado no mercado, saber como funciona projeto CRUD (DAO genérico, ConnectionFactory, PreparedStatement e ResultSet) totalmente via JDBC é de extrema importância o que acontece por trás do JPA e o que as ORMs estão automatizando.

------

**Fabio peretti Guimarães | tarefa Ebac mod 31 | SET 2026**