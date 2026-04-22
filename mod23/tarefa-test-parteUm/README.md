![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Test](https://img.shields.io/badge/Tests-leafgreen?style=for-the-badge)
![JUnit5](https://img.shields.io/badge/JUnit5-f5f5f5?style=for-the-badge&logo=junit5&logoColor=dc524a)

# ☕ Tarefa Estudo de Tests JUnit - Parte I

**Esta é a primeira parte dos estudos de 'Testes' de código, com o uso do framework JUnit. Para este estudo, foi também utilizado Listas e Streams para ver como o framework se comporta com variáveis sequenciadas.**

>**Nota:** atualmente, a versão mais recomendada do framweork JUnit é a versão 5, diferente do módulo do curso. Então alguns, operadores estarão diferentes, apesar de alcançarem o mesmo objetivo.

````XML
<!-- Source: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.13.4</version>
    <scope>test</scope>
</dependency>
````
<br>

## Classe Pessoa
<details>
<summary>Clique aqui para expandir</summary>

<br>

**O projeto reutiliza a Classe usada no módulo de Streams, trabalhando com lista e instanciação anônima.**

````java
package com.fabioperettig.model;
import java.util.List;

public class Pessoa {

    private String nome;
    private String sexo;

    public Pessoa(String nome, String sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    // anonymous instance
    public Pessoa() {}

    // getters
    public String getNome() { return nome; }
    public String getSexo() { return sexo; }

    public List<Pessoa> pessoaList(){
        Pessoa p1 = new Pessoa("Fabio","Masculino");
        Pessoa p2 = new Pessoa("Miguel","Masculino");
        Pessoa p3 = new Pessoa("Helena","Feminino");
        Pessoa p4 = new Pessoa("Arthur","Masculino");
        Pessoa p5 = new Pessoa("Alice","Feminino");
        Pessoa p6 = new Pessoa("Laura","Feminino");
        ...

        return List.of(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14);
    }

    @Override
    public String toString() {
        return nome + " | " + sexo;
    }
}
````
</details>

<br>

## 🔍 Classe Test

A classe de testes conta com a API *Assertions* do **JUnit 5** para checagem booleana após o uso de *streams*, dentro e fora do método **test()**.

````java
package com.fabioperettig.test;

import com.fabioperettig.model.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PessoaTest {

    List<Pessoa> testList = new Pessoa().pessoaList();

    List<String> femList = testList.stream()
            .filter(sexo -> sexo.getSexo().equals("Feminino"))
            .map(pessoa -> pessoa.getNome() + " | " + pessoa.getSexo())
            .toList();


    @Test
    public void test(){
        femList.forEach(pessoa -> {
            Assertions.assertTrue(pessoa.contains("Feminino"));
        });
    }
}
````
Através deste método, o teste obtem sucesso se apenas pessoas do sexo feminino tiverem sido passadas pelo filtro da **List≺Pessoa≻ femList**.

>Neste tipo de checagem booleana também é possível o uso de Assertions.assertFalse caso queira checar se a lista contém o sexo masculino. Garantindo um teste ainda mais seguro.

----

### Fabio peretti Guimarães | tarefa Ebac mod 23 | ABR 2026