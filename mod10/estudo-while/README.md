# 🧩 Estudo: Estruturas de Repetição `while` em Java

Este projeto demonstra, de forma prática e comentada, as diferenças de comportamento entre os laços de repetição `for` e `while` em **Java**. O objetivo é observar como a ordem das instruções dentro dos loops afeta o resultado final impresso no terminal.

----

### Main.java
Explora o comportamento dos loops aplicados a uma variável estática.


````
for (int local=0;local<10;local++){
    number ++;
    System.out.println("Valor de int number: " + number);
}

while (number > 0){
    System.out.println("Valor de int number: " + number);
    number --;
}
````

**Em comparação com o método for**, o método While não precisa condicionar uma variável local para exercer influência sobre a variável principal.


`````
/**
* @deprecated uma forma prolixa e substituível pelo método visivelWhile().
*/
public void analiseWhile(){
    int local = 0;
    while (number > 0){
        if (local <= 10){
        local ++;
        }
        System.out.println("Valor de int number: " + number);
        number--;
    }
}

public void visivelWhile(){
    while (number > 0) {
        System.out.println("Valor de int number: " + number);
        number--;
    }
}
`````

----

### WhileString.java

Um estudo de cálculos simples, com foco no comportamento do while com Strings de valores aplicados via Scanner(System.in), sendo executado em loop e só encerrando através de comando do usuário. O cálculo também pode ser feito tanto via a união de `while` e `for`, quanto o uso de `while` puro.

````
while(resposta.equalsIgnoreCase("sim")){
    System.out.println("Digite um número para calcular: ");
    number = input.nextInt();

    System.out.println("\nEscolha um dos métodos:");
    System.out.println("1 – whilePuro()");
    System.out.println("2 – etapaFOR()\n");
    metodoEscolhido = input.nextInt();

    if (metodoEscolhido == 1) {
        whilePuro(number);
    } else {
        etapaFOR(number);
    }

    System.out.println("Gostaria de escolher um outro número para calcular?");
    resposta = input.next();
}
````

**Metodos comparativos**
````
/**
* <p>Estudo da possibilidade da quebra de etapas em diferentes whiles.</p>
* <p>O exemplo mostra uma substituição do método etapaFOR por um método while,
* criando uma variável local que influencia a variável de parâmetro.</p>
* @param number variável static criada fora da Main.
*/
public static void whilePuro(int number){
    int local = 0;
    System.out.println("\nCálculo executado via WHILE\n");
    while (local < 10){
        local ++;
        System.out.println(number + "*" + local + "=" + number*local);
    }
}

public static void etapaFOR(int number){
    System.out.println("\nCálculo executado via FOR\n");
    for(int local=0; local<=10; local++){
        System.out.println(number + "*" + local + "=" + number*local);
    }
}
````


## 🛠️ Tecnologias Utilizadas
- **@author** Fabio Peretti Guimarães
- **Java 17**
- Biblioteca padrão do Java (`java.util`)
- Projeto criado para fins de estudo — EBAC | Módulo 10 – Estruturas de Repetição.