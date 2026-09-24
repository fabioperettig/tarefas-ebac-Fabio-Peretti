![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Java Persistence](https://img.shields.io/badge/Java_Persistence_API-FDFFFC?style=for-the-badge)
![Curso EBAC](https://img.shields.io/badge/Curso--EBAC-235789?style=for-the-badge)

# 📚🚙 Tarefa Módulo 33

Este projeto consiste em um sistema DAO simples de três Entidades, com classe DAO dedicada,
testes exclusivos e DB interligado. Além disso, o projeto estuda modos de conexão entre schemas 
e possui diferentes tipo de implementação para buscas específicas.

| **Entidade** | **Conexão** | **Tipo de busca** |
|--------------|-------------|-------------------|
| Carro        | @ManyToOne  | Raw SQL           |
| Marca        | @OneToMany  | Srtrigbuilder     |
| Acessório    | @OneToOne   | JPA Criteria  |


## Modelo Entidade

As Entidades foram criadas seguindo o padrão Jakarta Persistence API (JPA), com geração de ID automática,
única e sequencial. Além disso, as Entidades possuem atributos correlacionais.

```java
package com.fabioperettig.domain;
import jakarta.persistence.*;
```

## Camada DAO

As camadas DAO contam com um `EntityManager` implementado em uma Classe própria, servido para todas as Entidades
e envitando boilerplate.

```java
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

**Fabio Peretti Guimarães | tarefa Ebac mod 33 | SET 2026**