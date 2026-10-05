![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Maven](https://img.shields.io/badge/apachemaven-%23C71A36.svg?style=for-the-badge&logo=apachemaven&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-%232c2c2c.svg?style=for-the-badge&logo=Hibernate&logoColor=white)
![Curso EBAC](https://img.shields.io/badge/Curso--EBAC-f2f0ef?style=for-the-badge)


# 📚☕️ Tarefa Módulo 37

Este projeto apresenta mais um sistema DAO simples, mas com uma bilbioteca mais expandida para mostrar a capacidade
do de gerenciamento de depencências via `Maven` e das possibilidades que as `libraries` oferecem.

## 🧠 Maven

Escolhi trabalhar com uma entidade simples `ClienteJPA` estruturada no padrão de anotações `Jakarta Persistence`
com identificador `Long` para o PostgreSQL, e também no padrão de anotações `Morphia` com identificador `ObjectId`
para o Mongo, mas ambas implementando a mesma interface `ICliente<ID>`.

<details>
<summary>POM.xml</summary>

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.fabioperettig</groupId>
    <artifactId>tarefa-mod-37</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.release>17</maven.compiler.release>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <lombok.version>1.18.46</lombok.version>
    </properties>

    <dependencies>
        <!-- Source: https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-core -->
        <dependency>
            <groupId>org.hibernate.orm</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>7.4.10.Final</version>
            <scope>compile</scope>
        </dependency>
        <!-- Source: https://mvnrepository.com/artifact/org.postgresql/postgresql -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.7.13</version>
            <scope>compile</scope>
        </dependency>
        <!-- Source: https://mvnrepository.com/artifact/io.github.cdimascio/dotenv-java -->
        <dependency>
            <groupId>io.github.cdimascio</groupId>
            <artifactId>dotenv-java</artifactId>
            <version>3.2.0</version>
            <scope>compile</scope>
        </dependency>
        <!-- Source: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>6.1.3</version>
            <scope>test</scope>
        </dependency>
        <!-- Source: https://mvnrepository.com/artifact/org.projectlombok/lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>${lombok.version}</version>
            <scope>provided</scope>
        </dependency>
        <!-- Source: https://mvnrepository.com/artifact/info.picocli/picocli -->
        <dependency>
            <groupId>info.picocli</groupId>
            <artifactId>picocli</artifactId>
            <version>4.7.7</version>
            <scope>compile</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.13.0</version>
                <configuration>
                    <annotationProcessorPaths>
                        <path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                            <version>${lombok.version}</version>
                        </path>
                    </annotationProcessorPaths>
                </configuration>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.5.5</version>
            </plugin>
        </plugins>
    </build>

</project>
```
</details>

## 💭 Dependências vs Plugins

**Dependências** são bibliotecas utilizadas pelo código do projeto, tanto na `compilação`, na `execução` quanto
nos `testes`, conforme definidas em seu `escopo` e ficam na área `<dependencies>`.

**Plugins** é a área para configurar e gerenciar as ferramentas que executam as tarefas reais do seu projeto,
como `compilar` o código, rodar testes, empacotar arquivos `(JAR/WAR)` e fazer o deploy da aplicação.

| Característica | 	Dependências (<dependencies>)                                           | 	Plugins (<plugins>)                                            |
|----------------|-------------------------------------------------------------------------|----------------------------------------------------------------|
| O que são?     | Bibliotecas de terceiros que seu código precisa para funcionar.	         | Ferramentas que ajudam a construir ou gerenciar o projeto.     |
| Onde vão?      | Elas são empacotadas junto com o seu sistema final (vão para produção).	 | Rodam apenas na sua máquina ou no servidor de build (CI/CD).   |
| Exemplo        | Driver do banco de dados (MySQL), Spring Boot, JUnit, Gson.	             | Compilador Java, gerador de documentação, plugin do SonarQube. |


## 📚 Dependências escolhidas

Com as dependências escolhidas, é possível construir um projeto seguro, com estrutura robusta e evitar Boilerplates.
Escolhi utilizar **dependências que já utilizo no meu dia a dia**, mas também busquei dependências novas e testá-las
levemente apenas para experimentação para manter o foco principal do projeto: trabalhar com gestão de dependências.

Listei abaixo as dependências escolhidas com um breve resumo, mostrando seu papel. Mas também podem ser analisadas
mais a fundo logo abaixo da tabela.

| 📚 Dependência | 🎯 Utilidade                                                                                                                                      |
|--------------------|---------------------------------------------------------------------------------------------------------------------------------------------------|
| Hibernate ORM      | Implementa o mapeamento objeto-relacional através da JPA, permitindo persistir e recuperar objetos `Filme no banco de dados.                      |
| Lombok             | Reduz código repetitivo na entidade, gerando automaticamente métodos como `Getters` e `Setters`.                                                  |
| PostgreSQL         | Permite a comunicação entre a aplicação Java e o banco de dados `PostgreSQL utilizado para persistência dos filmes.                               |
| Dotenv             | Carrega configurações sensíveis, como usuário, senha e URL do banco, a partir de `Variáveis de Ambiente`.                                         |
| JUnit              | Permite criar `Testes` automatizados para validar métodos e comportamentos da aplicação durante o desenvolvimento.                                |
| PicoCLI            | Estrutura a interface de linha de comando, permitindo criar comandos, opções e parâmetros sem depender de menus manuais com `Scanner` e `Switch`. |

<details>
<summary>Detalhes sobre cada dependência</summary>

### Hibernate ORM + @Lombok 📚 < /dependency>

Usando as dependências `Hibernate` e `Lombok`, é possivel implementar uma Entidade de forma bastante dinâmica, não
só com a agilidade do Hibernate, mas também Getters e Setters adicionados dinamicamente através com Lombok (com a 
possibilidade de evitar setters que compromentam a estrutura como o caso do atributo Id).

```java
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_FILME")
@Getter @Setter
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filme_seq")
    @SequenceGenerator(name = "filme_seq", sequenceName = "sq_filme", initialValue = 1, allocationSize = 1)
    @Setter(AccessLevel.NONE)
    Long id;

    @Column(name = "CODIGO",  nullable = false, unique = true)
    String codigo;

    @Column(name = "NOME", nullable = false)
    String nome;

    @Column(name = "ANO")
    Integer anoLancamento;

    @Column(name = "CATEGORIA")
    String categoria;

    @Column(name = "TEMPO", nullable = false)
    Integer tempoEmMin;

    @Column(name = "NOTA")
    Double nota;
}
```

### Picocli ⌨️  < /dependency>

`Picocli` é utilizado para estruturar a interface CLI do projeto, permitindo criar comandos, parâmetros e opções de
terminal por meio de anotações. Ele substitui menus manuais com `Scanner` e `Switch`, deixando a entrada da aplicação
mais organizada e modular.

```java
import picocli.CommandLine.Command;

@Command(
        name = "PicocliBlockbuster",
        description = "CLI para gerenciamento de filmes",
        mixinStandardHelpOptions = true,
        version = "PicocliBlockbuster CLI 1.0",
        subcommands = {
                CadastarFilmeCommand.class
        }
)
public class PicocliCommnand  implements Runnable {
    @Override
    public void run() {
        System.out.println("Bem-vindo ao Blockbuster CLI!");
    }
}
```

### Dotenv 🛡️ < /dependency>

`Dotenv` é uma dependência excelente para projetos que possuem dados sensíveis como `Login`, `Senha`, `Tokens` e etc.
É perfeito para trabalhar com persistência de dados, mantendo a URL, USER e PASS declaradas em Variáveis de Ambiente e
protegidas pelo `.gitignore`.

```java
public class ConfigManager {

    private static volatile EntityManagerFactory emFactory;

    public static EntityManager getEntityInstance() {

        if (emFactory == null) {
            synchronized (ConfigManager.class) {
                if (emFactory == null){

                    ///Exemplo de proteção de dados em EntityManager através do Dotenv
                    Dotenv env = Dotenv.load();

                    String url = env.get("DB_URL");
                    String user = env.get("DB_USER");
                    String pass = env.get("DB_PASS");

                    Map<String, String> prop = new HashMap<>();
                    prop.put("jakarta.persistence.jdbc.url", url);
                    prop.put("jakarta.persistence.jdbc.user", user);
                    prop.put("jakarta.persistence.jdbc.password", pass);

                    emFactory = Persistence.createEntityManagerFactory("postgresmovdb", prop);
                }
            }
        }

        return emFactory.createEntityManager();
    }

}
```

</details>


------

**Fabio Peretti Guimarães | tarefa Ebac mod 37 | OUT 2026**
