# 🧩 Estudo: Estruturas de Repetição `for` em Java

Exercícios e exemplos práticos desenvolvidos para estudar o uso do laço `for` em **Java**, explorando suas variações, aplicações com diferentes tipos de dados e boas práticas.


### 🧮 `Main.java`
Demonstra o uso básico do laço `for` com **tipos numéricos** (`int` e `double`), além do uso do comando `continue` para filtrar valores.

- Exemplo de `for` simples com inteiros  
- Exemplo com `for` usando `double`  
- Método `apenasPar()` mostrando o uso de **condicionais e continue**

````
private static void apenasPar() {
    for(int par = 0; par <= 100; par++){
        if (par%5!=0){
            continue;
        }
        System.out.println(par);
    }
}
````


### 🧾 `ExemploList.java`
Demonstra o uso de `for` com **Listas (`ArrayList`)**.

- Adiciona números em uma lista com `for` tradicional  
- Percorre a lista com `for-each`  
- Demonstra o uso do método moderno `forEach()` com **expressões lambda**

````
List<Integer> numeroX = new ArrayList<>();

System.out.println("Exemplos de For com Listas");
    for (int x=0; x<=5; x++){
        System.out.println("Linha X: " + x);
        numeroX.add(x);
    }
````


### 🧩 `ExemploIFvsFOR.java`
Exemplo comparando o uso de **estruturas condicionais (`if`)** e **laços (`for`)**.

- Mostra uma tabuada criada manualmente com `if`  
- Mostra a mesma tabuada criada de forma otimizada com `for`  
- Usa a anotação `@Deprecated` para indicar métodos antigos ou substituíveis

````
/**
* @deprecated perfeitamente subsituível pelo método tabuadacomFOR()
*/
public static void tabuadacomIF(int numInt){
    if (numInt < 10) {
        System.out.println(numInt + "x1=" + numInt*1);
        System.out.println(numInt + "x2=" + numInt*2);
        System.out.println(numInt + "x3=" + numInt*3);
        System.out.println(numInt + "x4=" + numInt*4);
        System.out.println(numInt + "x5=" + numInt*5);
        System.out.println(numInt + "x6=" + numInt*6);
        System.out.println(numInt + "x7=" + numInt*7);
        System.out.println(numInt + "x8=" + numInt*8);
        System.out.println(numInt + "x9=" + numInt*9);
        System.out.println(numInt + "x10=" + numInt*10);
    } else {
        System.out.println("O número deve ser menor que 10.");
    }
}

public static void tabuadacomFOR(int numInt){
    for (int i=1; i<=10;i++){
        System.out.println(numInt + "x" + i + "="+ numInt*i);
    }
}
````

---

### 🔠 `ExemploForString.java`
Exercício prático de manipulação de **Strings com for**.

O programa:
- Lê uma palavra ou frase do usuário;  
- Exibe cada caractere e sua posição;  
- Conta o número total de caracteres;  
- **Remove acentos** e conta **vogais e consoantes**, ignorando espaços e pontuação;  
- Mostra a palavra invertida.

> 💡 Também utiliza `java.text.Normalizer` e `Character.isLetter()` para tratamento de acentuação e filtragem de letras.

````
String stringNormalizada = Normalizer.normalize(stringTest,Normalizer.Form.NFD);
stringNormalizada = stringNormalizada.replaceAll("[^\\p{ASCII}]", "");

for (int i=0; i < stringTest.length(); i++){
    char letra = stringTest.charAt(i);
        System.out.println("Letra na posição " + i + ": " + letra);
}



int contadorVogal = 0;
int contadorConsoante = 0;

for (int i = 0; i < stringNormalizada.length(); i++) {
    char c = Character.toLowerCase(stringNormalizada.charAt(i));
    if (Character.isLetter(c)) {
        if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
            contadorVogal++;
        } else {
            contadorConsoante++;
        }
    }
}

````

## 🛠️ Tecnologias Utilizadas
- **@author** Fabio Peretti Guimarães
- **Java 17**
- **IntelliJ IDEA CE**
- Biblioteca padrão do Java (`java.util`, `java.text`)