![Java](https://img.shields.io/badge/java-21a8d5.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Lambda](https://img.shields.io/badge/Lambda-1d72b4?style=for-the-badge)
![Estudo](https://img.shields.io/badge/Estudo-e89d41?style=for-the-badge)

# 📚 Estudo Expressões Lambda <span style="color:#fb7e14">(λ)</span >

Expressões Lambda são ferramentas que permitem **implementar métodos como se fossem objetos**, simplificando consideravelmente o seu código e retira a necessidade de intanciar classes completas apenas para executar um método.

*"As expressões lambda permitem expressar instâncias de classes com um único método de forma mais compacta."* (**[Java Language Specification](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)**)

---

Antes do **Java 8**, se você quisesse executar um único método criado em uma Interface, era necessário: criar uma Classe, implementar a Interface, instanciar esta Classe e, por fim, executar o método atrelado.

````java
//Interface com método
public interface Printline {
    void print();
}

-----
//Classe que utilizará o método
public class Gato implements PrintLine {
    public String nome;
    public int idade;

    public void print(){
        System.out.println("Miau")
    }
    ...
}

----
//Clase Main
public class Main {
    public static void main(String[] args){
        Gato meuGato = new Gato();
        meuGato.print();
    }
} 
````
Por mais que este seja o jeito convencional de uma **linguagem Orientada a Objetos**, pode se tornar uma implementação custosa para executar um ***"método descartável"*** ou que não faça sentido atrelá-lo à classe. Ou até em situações piores onde se intancia uma Classe Anônima para se tornar possível a execução do método.
<br><br>
## 🪄 A real mudança
A estrutura de uma Expressão Lambda ignora os modificadores de acesso e foca apenas na execução do método, nos dando a possibilidade de **executar o método como parâmetro de outro método**.

````java
// Passo 1;
printAlgo(
    public void print() {
        System.out.println("Miau")
    }
);

// Passo 2;
printAlgo(
    () {
        System.out.println("Miau")
    }
);

// Passo 3;
printAlgo(() -> {
        System.out.println("Miau")
    }
);

// Sintaxe final;
printAlgo(() -> System.out.println("Miau"));

// Passo bônus.
printAlgo( s -> "Miau");
````

- Passo 1: método como **parâmetro**;

- Passo 2: **retirar** o nível de acesso, o nome do método e o tipo de retorno;

- Passo 3: adicionar o **Operador de Seta**, validando a sintaxe da expressão lambda;

- Passo bônus - se o método executa uma única ação e **possui um retorno** específico (String, por exemplo) o método pode ficar ainda mais resumido.

<br>
É possível até salvar uma expressão Lambda em uma variável (5:55) ou passá-la diretamente como um parâmetro para um método (2:20).


## Interfaces Funcionais

Lambdas são utilizadas estritamente em conjunto com Interfaces Funcionais — interfaces que possuem exatamente um método abstrato (também chamadas de SAM - Single Abstract Method).