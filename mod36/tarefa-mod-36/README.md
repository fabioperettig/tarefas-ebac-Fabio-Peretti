![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)
![Curso EBAC](https://img.shields.io/badge/Curso--EBAC-f2f0ef?style=for-the-badge)

# 📚☕️ Tarefa Módulo 36

Este projeto simples serve como introdução para projetos DAO que utilizam dois databases diferentes para a persistência de Entidades.
Para isso, escolhi utilizar os BD PostgreSQL como Banco Relacional e MongoDB como Banco Não Relacional.

| objetivo                                            | Observações                                       |
|-----------------------------------------------------|---------------------------------------------------|
| Cadastrar uma Entidade em dois databases diferentes | Provavelmente DAOs dedicados para cada DB         |
| Trabalahr com SQl e NoSQL                           | PostgreSQL e MongoDB                              |
| Integrar databases via Docker                       | Praticar Docker via .yml com variávis de ambiente |
| Integrar databases via Docker                       |                                                   |

## Entidade Interface e Concretas

Escolhi trabalhar com uma entidade simples `ClienteJPA` estruturada no padrão de anotações `Jakarta Persistence`
com identificador `Long` para o PostgreSQL, e também no padrão de anotações `Morphia` com identificador `ObjectId`
para o Mongo, mas ambas implementando a mesma interface `ICliente<ID>`.

### 🐘 Entidade Cliente Jakarta Persistence
```java
import jakarta.persistence.*;

@Entity
@Table(name = "TB_CLIENTE")
public class ClienteJPA implements ICliente<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    @SequenceGenerator(name = "cliente_seq", sequenceName = "sq_cliente", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "CPF", nullable = false, unique = true)
    private Long cpf;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    ///getter e setters {...}
}
```

### 🌱 Entidade Cliente Morphia (Mongo DB)
```java
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import org.bson.types.ObjectId;

@Entity("clientes")
public class ClienteMorphia implements ICliente<ObjectId> {

    @Id
    private ObjectId id;
    private String nome;
    private Long cpf;
    private String email;
    
    ///getter e setters {...}
}
```

## 🐳 Docker

O projeto consta com um `docker-compose` para estabelecer a estrutura dos databases, com os dados devidamente protegidos
com variáveis de ambiente.

```yaml
services:
  postgres:
    image: postgres:17
    container_name: shop-postgres
    environment:
      POSTGRES_DB: postgresdb
      POSTGRES_USER: ${DB_USER}
      POSTGRES_PASSWORD: ${DB_PASS}
    ports:
      - "127.0.0.1:5433:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

  mongodb:
    image: mongo:8.0
    container_name: shop-mongodb
    environment:
      MONGO_INITDB_ROOT_USERNAME: ${MONGO_USER}
      MONGO_INITDB_ROOT_PASSWORD: ${MONGO_PASS}
    ports:
      - "127.0.0.1:27017:27017"
    volumes:
      - mongodb_data:/data/db

volumes:
  postgres_data:
  mongodb_data:
```

## 🏭Factories de Conexão

Cada tipo de banco de dados precisa de um padrão de construção própria, sendo o JPA construído com `EntityManager`
e o Mongo construído com `Datastore`. Porém, é possivel ver que ambos podem ser construídos com a mesma pattern
`Singleton` e ter as variáveis de ambiente implementadas via `.env`.

### 🐘 Factory EntityManager (Jakarta Persistence)
```java
///Estrutura EntityManagerFactory Jakarta Persistence
public class EntityManagerJPA {

    private static volatile EntityManagerFactory emFactory;

    public static EntityManager getEntitymanager() {

        if (emFactory == null) {
            synchronized (EntityManagerJPA.class) {
                if (emFactory == null) {
                    Dotenv dotenv = Dotenv.load();

                    String url = dotenv.get("DB_URL");
                    String user = dotenv.get("DB_USER");
                    String pass = dotenv.get("DB_PASS");

                    Map<String, String> input = new HashMap<>();
                    input.put("jakarta.persistence.jdbc.url", url);
                    input.put("jakarta.persistence.jdbc.user", user);
                    input.put("jakarta.persistence.jdbc.password", pass);

                    emFactory = Persistence.createEntityManagerFactory("postgresdb", input);

                }
            }
        }
         return emFactory.createEntityManager();
    }
}
```

### 🌱 Factory Datastore (Mongo DB)
```java
///Estrutura Datastore MongoClient
public class MongoConnection {

    private static MongoClient mongoClient;
    private static volatile Datastore mongoDatastore;

    public static Datastore getDatastore() {

        if (mongoDatastore == null) {
            synchronized (MongoConnection.class) {
                if (mongoDatastore == null) {
                    
                    Dotenv dotenv = Dotenv.load();
                    String uri = dotenv.get("MONGO_URI");
                    mongoClient = MongoClients.create(uri);

                    MorphiaConfig mConfig = MorphiaConfig
                            .load().database("mongodb")
                            .packages(List.of("com.fabioperettig.domain"));

                    mongoDatastore = Morphia.createDatastore(mongoClient, mConfig);
                }
            }
        }
        return mongoDatastore;
    }
}
```
>No caso de conexões com `MongoClient`, a URI já contém USER e PASS embutidas nos dados. 

## ⚙️ DAOs

EM CONTRUÇÃO 🚧

------

**Fabio Peretti Guimarães | tarefa Ebac mod 36 | OUT 2026**