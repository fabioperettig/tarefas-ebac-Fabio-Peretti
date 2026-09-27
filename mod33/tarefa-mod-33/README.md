![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Java Persistence](https://img.shields.io/badge/Java_Persistence_API-FDFFFC?style=for-the-badge)
![Curso EBAC](https://img.shields.io/badge/Curso--EBAC-235789?style=for-the-badge)

# 📚☕️ Tarefa Módulo 33

Este projeto consiste em um sistema DAO simples de três Entidades, com classe DAO dedicada,
testes exclusivos e DB interligado. Além disso, o projeto estuda modos de conexão entre tabelas 
e possui diferentes tipo de implementação para buscas específicas.

| **Entidade** | **Conexão**         | **Método de busca**                        |
|--------------|---------------------|--------------------------------------------|
| Marca        | @OneToMany -> Carro | `findById()`                               |
| Carro        | @ManyToOne -> Marca | `findById()` + `findByCode()` via JPQL     |
| Acessório    | @OneToOne -> Carro  | `findById()` + `findByCode()` via Criteria |


## 🚙 Modelo Entidade

As Entidades foram criadas seguindo o padrão Jakarta Persistence API (JPA), com geração de ID automática,
única e sequencial. Além disso, as Entidades possuem atributos correlacionais.

```java
package com.fabioperettig.domain;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_CARRO")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "c.seq")
    @SequenceGenerator(name = "c.seq", sequenceName = "sq_c", initialValue = 1, allocationSize = 1)
    private long id;

    @Column(name = "CODIGO", nullable = false, unique = true)
    private String codigo;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "ANO", nullable = false)
    private int ano;

    @Column(name = "MODELO", nullable = false)
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "nome_marca_fk", foreignKey = @ForeignKey(name = "fk_marca_carro"),
            referencedColumnName = "NOME", nullable = false)
    private Marca marca;

    @OneToOne(mappedBy = "carro", optional = true)
    private Acessorio acessorio;
```

## ⚙️ Camada DAO

As camadas DAO contam com um `EntityManager` implementado em uma Classe própria, servido para todas as Entidades
e envitando boilerplate.

```java
public class CarroDao implements ICarroDao {

    @Override
    public Carro create(Carro carro) {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        em.getTransaction().begin();
        em.persist(carro);
        em.getTransaction().commit();
        em.close();

        return carro;
    }

    @Override
    public Carro read(Long id) {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        Carro carro = em.find(Carro.class, id);
        em.close();

        return carro;
    }

    @Override
    public Carro update(Carro carro) {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        em.getTransaction().begin();
        carro = em.merge(carro);
        em.getTransaction().commit();
        em.close();

        return carro;
    }

    @Override
    public void delete(Carro carro) {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        em.getTransaction().begin();
        carro = em.merge(carro);
        em.remove(carro);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public List<Carro> findAll() {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        List<Carro> carros = em.createQuery("SELECT c FROM Carro c", Carro.class).getResultList();
        em.close();

        return carros;

        {...}
    }
}
```

## 🛡️EntityManager -> Connection Manager

Implementei no projeto a Classe `ConnectionManager`, não só para uma arquitetura mais limpa, mas também para
construir a EntityManagerFactory sob o padrão `Singleton` com ***Double-Checked Locking*** para continuar
praticando os estudos de Patterns aprendidos nos módulos passados.

Além disso, este padrão permite proteger os dados de conexão SQL (URL, USER e PASS) em `.env`, aumentando a segurança
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

## 📚 JPQL e Criteria API 🔍

Também implementei os métodos JPA de consultas a banco de dados orientadas a objetos ***JPQL*** e ***Criteria API***.
Com estes métodos, é possível não só realizar buscas diretamente pelo código da entidade, mas aprimorar os métodos
para filtros personalizados, com duas ou mais propriedades.

> Para manter o foco no estudo, concentrei o método em `findByCode()` apenas.

### JPQL (Java Persistence Query Language)

Método semelhante com SQL tradicional, mas manipula Entidades e seus atributos em vez de tabelas e colunas do database.

```java
    @Override
    public Carro findyByCode(String codigo) {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT c FROM Carro c ");
        jpql.append("WHERE c.codigo = :parametro");

        TypedQuery<Carro> query = em.createQuery(jpql.toString(), Carro.class);
        query.setParameter("parametro", codigo);


        return query.getSingleResult();
    }
```

### Criteria API

API desenvolvida para criar consultas diretamente em código Java, substituindo a escrita de consultas
em texto SQL `SELECT`, `FROM`, `WHERE` por **métodos orientados a objetos**.

```java
@Override
    public Acessorio findyByCode(String codigo) {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        CriteriaBuilder cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Acessorio> querry = cBuilder.createQuery(Acessorio.class);

        ///FROM Acessorio 'a'(alias)
        Root<Acessorio> acessorioRoot = querry.from(Acessorio.class);

        ///SELECT a + WHERE a.codigo=:codigoInput(parametro)
        querry.select(acessorioRoot).where(cBuilder.equal(acessorioRoot.get("codigo"),codigo));

        TypedQuery<Acessorio> typedQuery = em.createQuery(querry);

        return typedQuery.getSingleResult();
}
```

------

**Fabio Peretti Guimarães | tarefa Ebac mod 33 | SET 2026**