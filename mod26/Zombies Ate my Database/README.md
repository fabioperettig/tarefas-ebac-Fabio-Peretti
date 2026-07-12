# Zombies Ate My Database 🧟

A fun Java project created to practice JDBC, PostgreSQL, and database triggers while adding a bit of chaos to the learning process. Instead of building just another CRUD application, this project introduces a small game mechanic:
Every time a new creature is registered, **there's a chance that a zombie outbreak will occur and randomly consume a record from the database**.

<details><Summary>Technologies and Features</Summary>

### Technologies
* Java 17
* PostgreSQL
* JDBC
* Maven
* Lombok
* dotenv-java
* PL/pgSQL

### Features
* Register new creatures
* Store data using PostgreSQL
* JDBC persistence layer
* Controller / DAO separation
* Automatic database initialization
* SQL scripts loaded from resources
* PostgreSQL Trigger
* Random zombie attacks
* ********* 🧬
</details>


## 📚 Project Structure
````
src
├── main
│   ├── java
│   │
│   ├── config
│   │     DatabaseInitializer.java
│   │     ClinicalReportReader.java
│   │     CureCredentials.java
│   │     ZombieOutbreakConfigDAO.java
│   │
│   ├── model
│   │     Character.java
│   │
│   ├── services
│   │     Controller.java
│   │     ZombieDAO.java
│   │
│   └── Main.java
│
└── resources
      ├── reports
      │      disease_report.txt
      │
      └── sql
             001_create_character_table.sql
             002_release_the_zombies.sql
             003_release_the_cure.sql
````

## Why JDBC❓

The main purpose of this project was to understand **how Java communicates with relational databases** before using higher-level abstractions such as JPA/Hibernate.

Instead of relying on an ORM, this project manually works with:

* Connection
* DriverManager
* PreparedStatement
* SQL statements
* SQLWarning
* Resource management

> Understanding these concepts first makes ORMs much easier to understand later.


## Why Lombok❓

Lombok was introduced to reduce **boilerplate code**.

````SQL
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Character {
    private String name;
    private int HP;
}
````

> Instead of manually writing constructors, getters and setters, the project uses annotations that generate them during compilation, allowing the model classes to stay clean and focused on their purpose.


## ☑️ Database Initialization

The project automatically prepares the database during startup. SQL scripts stored inside the resources/sql folder are executed by the application, creating all required tables, functions and triggers automatically.

**This means the project can be cloned and executed without manually creating database objects.**


## Zombie Outbreak ☣️

Every new creature registered has a chance to trigger a zombie outbreak. **A random INSERT disappears forever.**
````sql
CREATE OR REPLACE FUNCTION zombie_eats_character()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
DECLARE
    eaten_character_name VARCHAR(50);
BEGIN
{...}

RAISE NOTICE '🧟 A zombie ate %s from the database!'
````
> The newly inserted creature is never selected as the victim.

## Hidden Easter Egg 🧬

**Somewhere inside this project there's a cure to stop the outbreak, you just have to INSERT the correct credentials. Good luck.**


## 💡 What I Learned

**This project was originally intended to practice PostgreSQL using JDBC.** During development it naturally evolved into something much bigger, allowing me to explore:

* PostgreSQL Triggers
* PL/pgSQL
* SQL migrations
* Resource loading
* File parsing
* JDBC warnings
* Database initialization
* Separation of responsibilities
* Easter Eggs driven entirely by the database

More importantly, it reinforced the value of understanding the underlying technologies before relying on frameworks.

## Future Improvements

* Migrate persistence from JDBC to JPA/Hibernate
* REST API using Spring Boot
* Unit and integration tests
* Docker support
* Multiple zombie types (because why not?)

## ⭐ Final Thoughts

This project began as a simple CRUD exercise. It ended as a small PostgreSQL laboratory where zombies randomly eat database records, hidden medical reports contain secret credentials, and a cure can stop the DB apocalypse.

**Sometimes the best way to learn is to have fun while building and beign a zombie fan.**
