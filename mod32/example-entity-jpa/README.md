![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Java Persistence](https://img.shields.io/badge/Java_Persistence_API-FDFFFC?style=for-the-badge)
![Projeto Curso EBAC](https://img.shields.io/badge/Projeto--Curso--EBAC-235789?style=for-the-badge)

# Exemplo Persistência de Entidade via JPA

## ConnectionManager.class

Para utilizar a `EntityManager` sem deixar os dados do database expostos no [persistence.xml](src/main/resources/META-INF/persistence.xml), criei a classe
*ConnectionManager* que se encarrega das instanciações de EntityManager com dados declarados em variáveis de ambiente (via ***Dotenv***).
Além disso, as instanciações são criadas em ***padrão Singleton com Double-Checked Locking***, garantindo que as *threads* enxergem a factory corretamente.

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

                    Map<String, String> properties = new HashMap<>();
                    properties.put("jakarta.persistence.jdbc.url", url);
                    properties.put("jakarta.persistence.jdbc.user", user);
                    properties.put("jakarta.persistence.jdbc.password", pass);

                    managerFactory = Persistence.createEntityManagerFactory("firstJPA", properties);
                }
            }
        }
        return managerFactory.createEntityManager();
    }
}
```
