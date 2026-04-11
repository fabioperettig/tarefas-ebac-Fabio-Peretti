![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Annotation Definition](https://img.shields.io/badge/Annotation-gold?style=for-the-badge)

# 🧩 Projeto: Annotation Customizada em Java

Este projeto tem como objetivo demonstrar a criação e utilização de uma annotation customizada, aplicando conceitos básicos de metadados e ***Reflection***.

Em Java, uma ***Annotation*** é uma forma de adicionar informações extras (metadados) a elementos do código, como classes, métodos ou atributos.

## 🏗️ Estrutura do projeto

O projeto é composto por três partes principais:

1. **Annotation Tabela**
````java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Tabela {

    String nome();
    int id();
}
````
<br>
Esta annotation define:

- nome da tabela;
- identificador;
- **@Target(ElementType.TYPE)** indicando que a annotation só pode ser usada em Classes;
- **@Retention(RetentionPolicy.RUNTIME)** permitindo que a annotation seja lida em tempo de execução.
<br><br>
2. **Classe User**
````java
@Tabela(nome = "usuario", id = 0)
public class User {
}
````
A classe marcada com a annotation @Tabela, informando os atributos com metadados. A classe **não precisa ter esses atributos internamente**, pois são dados implementados na annotation.
<br><br>
3. **Classe Main**
````java
public class Main {
    public static void main(String[] args) {

        if(User.class.isAnnotationPresent(Tabela.class)){

            Tabela tabela = User.class.getAnnotation(Tabela.class);
            System.out.printf("nome: %s | id: %d.", tabela.nome(), tabela.id());
        }
    }
}
````
## 🔍 O que está acontecendo aqui:

1.	O programa verifica se a classe User possui a annotation Tabela;
2.	Caso possua, ele utiliza Reflection para obter essa annotation: 

````java
Tabela tabela = User.class.getAnnotation(Tabela.class);
````
3.	O Java retorna um objeto que representa a annotation, contendo os valores predefinidos;

4.	Esses valores são acessados como métodos: **tabela.nome()** e **tabela.id()**.


## 💡 Conclusão
Annotations são metadados que descrevem informações sobre o código, que precisam de uma Classe para funcionarem, através do método **Reflection** ou frameworks como Spring, Jakarta ou hibernate.

---
<br>

**Fabio peretti Guimarães | tarefa Ebac mod 18 | ABR 2026**