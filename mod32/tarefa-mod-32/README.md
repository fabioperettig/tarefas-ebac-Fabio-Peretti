![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Java Persistence](https://img.shields.io/badge/Java_Persistence_API-FDFFFC?style=for-the-badge)
![Curso EBAC](https://img.shields.io/badge/Curso--EBAC-235789?style=for-the-badge)

# 📚 Tarefa Modulo 32

Este projeto consiste em um sistema DAO simples em três Entidade. Cada entidade possui uma classe DAO
com métodos CRUD, mais alguns métodos específicos.

| **Entidade**                 | **Classe DAO** | **Objetivo da tarefa**                                     |
|------------------------------|----------------|------------------------------------------------------------|
| Curso                        | CursoDao       | Implementar método CRUD completos + classe de Testes;      |
| Matricula                    | MatriculaDao   | Atrelar a Entidade Matricula à Entidade Curso (ManyToOne); |
| Produto                      | ProdutoDAO     | Criar a Entidade Produto + Implementos DAO do zero;        |


## Modelo Entidade

As Entidades foram criadas seguindo o padrão Jakarta Persistence API (JPA), com geração de ID automática,
única e sequencial.

```java
package com.fabioperettig.domain;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_sq")
    @SequenceGenerator(
            name = "prod_sq",
            sequenceName = "sq_produto",
            initialValue = 1,
            allocationSize = 1)
    private long id;

    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "NAME", length = 50, nullable = false)
    private String nome;

    @Column(name = "VALUE", nullable = false)
    private double value;
}
```

## Camada DAO

As camadas DAO contam com um `EntityManager` implementado em uma Classe própria, servido para todas as Entidades
e envitando boilerplate.

```java
public class ProdutoDao implements IProdutoDao {

    @Override
    public Produto create(Produto produto) {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();
        entityManager.close();

        return produto;
    }

    @Override
    public Produto readById(Long id) {

        EntityManager entityManager = ConnectionManager.getEntityManager();
        Produto produto = entityManager.find(Produto.class, id);
        entityManager.close();

        return produto;
    }

    @Override
    public Produto update(Produto produto) {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        produto = entityManager.merge(produto);
        entityManager.getTransaction().commit();
        entityManager.close();

        return produto;
    }

    @Override
    public void delete(Produto produto) {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        produto = entityManager.merge(produto);
        entityManager.remove(produto);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public List<Produto> findAll() {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        List<Produto> produtos = entityManager.createQuery(
                "SELECT m FROM Produto m", Produto.class).getResultList();
        entityManager.close();

        return produtos;
    }

    public Produto findByCode(String codigoProduto) {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        String jpql = "SELECT p FROM Produto p WHERE p.codigo = :codigo";

        TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);

        query.setParameter("codigo", codigoProduto);

        Produto produto = query.getSingleResult();
        entityManager.close();

        return produto;
    }
}
```

## EntityManager -> Connection Manager

Criei a Classe `ConnectionManager` foi implementada não só para deixar o projeto com uma arquitetura mais limpa,
mas também para construir a EntityManagerFactory sob o padrão Singleton com Double-Checked Locking para continuar
praticando aplicando os estudos de Patterns aprendidos no curso.

Além disso, este padrão permite proteger os dados de conexão SQL (URL, USER e PASS) em .env, aumentando a segurança
e mais facilidade para replicar em outros database sem alterar diretamente a `persistence.xml`.

```java
public class ConnectionManager {

    private static volatile EntityManagerFactory managerFactory;

    public static EntityManager getEntityManager() {
        if (managerFactory == null) {
            synchronized (EntityManager.class) {
                if (managerFactory == null) {
                    Dotenv dotenv = Dotenv.load();

                    String url = dotenv.get("DB_URL");
                    String user = dotenv.get("DB_USER");
                    String pass = dotenv.get("DB_PASS");

                    Map<String, String> propriedades = new HashMap<>();
                    propriedades.put("jakarta.persistence.jdbc.url", url);
                    propriedades.put("jakarta.persistence.jdbc.user", user);
                    propriedades.put("jakarta.persistence.jdbc.password", pass);

                    managerFactory = Persistence.createEntityManagerFactory("mod32DB", propriedades);
                }
            }
        }
        return managerFactory.createEntityManager();
    }
}
```

------

**Fabio peretti Guimarães | tarefa Ebac mod 32 | SET 2026**