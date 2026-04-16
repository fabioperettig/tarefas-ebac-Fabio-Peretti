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

É possível também aplicar uma Expressão Lambda ao valor de uma variável para deixar a execução ainda mais dinâmica. Com isso, também é possível notar que este tipo de implementação torna possível **'instanciar uma Interface'**.

````java
Printline miado = () -> System.out.println("Miau");

printAlgo(miado);
````
#### ⚙️ O que está acontecendo de verdade?
Não é possível instanciar uma Interface diretamente no java (ex: new Printline()), porque interfaces não possui corpo.

Quando se faz uma instanciação em Expressões Lambda, o Java execute os seguintes processos:

1. **Reconhece** que 'miado' é do tipo Printline;

2. Cria, **em tempo de execução**, uma classe que implementa a interface;

3. **Atribui o código** System.out.println("Miau") dentro do único método que a interface possui.
<br>

>**⚠️ Mas, para que esta dinâmica seja possível, é necessário que a Interface esteja no padrão 'Interface Funcional'**

## 🧩 Interfaces Funcionais
Para deixar claro: **Lambdas são utilizadas estritamente em conjunto com Interfaces Funcionais**. São Interfaces que possuem um único método abstrato (também chamadas de *SAM - Single Abstract Method*).

Embora não seja obrigatório, é uma boa prática usar a anotação **[@FunctionalInterface](https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html)**, pois instrui o compilador a verificar se a interface realmente contém apenas um método abstrato. É uma prática importante, pois se uma interface tiver **dois ou mais métodos abstratos**, o compilador não consegue identificar qual deles a sua expressão Lambda deveria implementar

```java
@FunctionalInterface
public interface Printline {
    void print(String message);
}
```
#### 💭 E se houverem métodos não abstratos?

Uma interface ainda pode ser considerada funcional mesmo contendo **outros métodos, desde que eles não sejam abstratos**:

- Static: Métodos com implementação própria dentro da interface;

- Default: Métodos que possuem uma implementação padrão definida na própria interface.

> **Ao contrário do Método Abstrato**, a Interface pode conter quantos métodos static ou default você desejar, pois eles já possuem uma implementação definida na própria interface.

```java
@FunctionalInterface
public interface Printline {
    // Método abstrato (o único obrigatório)
    void print(String message);

    // Método default: pode ser chamado por qualquer objeto que implemente a interface
    default void printInfo() {
        System.out.println("Executando uma tarefa de impressão...");
    }

    // Método static: chamado diretamente pela interface
    static void printSystemStatus() {
        System.out.println("Sistema de impressão pronto.");
    }
}
```

## ✅ Conclusão
Utilizar Expressões Lambdas pode ser uma estratégia poderosa em um sistema complexo. Esta abordagem transforma o desenvolvimento, permite um maior foco no comportamento do código e torna a estrutura menos prolixa, sem perder sua robustez.

------

**Fabio peretti Guimarães | tarefa Ebac mod 21 | ABR 2026**