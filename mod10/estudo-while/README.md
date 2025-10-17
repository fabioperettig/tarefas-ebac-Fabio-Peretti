# 🧩 Estudo: Estruturas de Repetição `while` em Java

Este projeto demonstra, de forma prática e comentada, as diferenças de comportamento entre os laços de repetição `for` e `while` em **Java**. O objetivo é observar como a ordem das instruções dentro dos loops afeta o resultado final impresso no terminal.

----

## 🖲️ Main.java
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


## 🗒️ WhileString.java

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

## ✂️ WhileBoolean.java
Criado como exercício de **lógica de repetição (`while` e `do/while`)** em controle de fluxo usando **variáveis booleanas**.

O objetivo era desenvolver um **simulador de Jokenpô** (Pedra, Papel e Tesoura) totalmente jogável no terminal, com placar, validação de jogadas e opção de reinício.

````
while (gameIniciado) {
                System.out.println("\n---------------------------\n");
                System.out.println("Seus pontos: " + pontosPlayer +
                        " | " + "Pontos do Bot: " + pontosBot);

                do {
                    System.out.println("\nEscolha sua jogada: Pedra, Papel ou Tesoura");
                    jogadaPlayer = input.nextLine();

                    //while jogadaPlayer != "Pedra" (trocar IF)
                    if (jogadaPlayer.equalsIgnoreCase("Pedra")||
                            jogadaPlayer.equalsIgnoreCase("Papel")||
                            jogadaPlayer.equalsIgnoreCase("Tesoura")) {
                    } else {
                        System.out.println("Jogada não permitida. Tente novamente.");
                        jogadaPlayer = ""; //retorna valor para vazio
                    }


                } while (jogadaPlayer.isEmpty());
            ...}
````

🎲 O estudo também apresenta um pouco de **escolhas probabilísticas** do Bot, através de Random() double.

````
public static void jogadaBot(){
        double jogada = random.nextDouble();
        if (jogada < 0.33) {
             escolhaBot= "Pedra";
        } else if (jogada < 0.66) {
            escolhaBot= "Papel";
        } else {
            escolhaBot= "Tesoura";
        }
    }
````
Além disso, o projeto contém **dois eventos de jogadas (Player vs Bot)**, para fins comparativos de métodos.

❌ O método `comparativoIf()` foi criado propositalmente como um exemplo de **“o que não fazer”** — uma versão gigantesca e repetitiva, contendo múltiplos `if` para cada combinação possível.

````
/**
* Método criado de forma proposital para compará-lo com Switch Case.<br>
* @Deprecated código desnecessariamente grande
* e substituível pelo método comparativoSwitch().
* @author fabioperettiguimarães
*/
public static void comparativoIf() {

    {...}

    if(jogadaPlayer.equalsIgnoreCase("Pedra")
            && escolhaBot.equalsIgnoreCase("Papel")){
            System.out.println(comparativoJogada);
            System.out.println("Bot venceu esta rodada!");
            pontosBot ++;
    }
    if(jogadaPlayer.equalsIgnoreCase("Papel")
            && escolhaBot.equalsIgnoreCase("Papel")){
            System.out.println(comparativoJogada);
            System.out.println("Empate!");
    }
    if(jogadaPlayer.equalsIgnoreCase("Tesoura")
            && escolhaBot.equalsIgnoreCase("Papel")){
            System.out.println(comparativoJogada);
            System.out.println("Você venceu esta rodada!");
            pontosPlayer ++;
    }
    if(jogadaPlayer.equalsIgnoreCase("Pedra")
            && escolhaBot.equalsIgnoreCase("Pedra")){
            System.out.println(comparativoJogada);
            System.out.println("Empate!");
    }
    
    {...}
}
````

✅ Essa implementação é comparada ao método `comparativoSwitch()`, que faz o mesmo trabalho com **apenas alguns casos bem organizados**.

````
public static void comparativoSwitch(){

   {...}

    switch (jogadas){
        case "pedra - papel", "tesoura - pedra", "papel - tesoura":
            System.out.println(comparativoJogada);
            System.out.println("Bot venceu esta rodada!");
            pontosBot ++;
            break;
        case "papel - papel", "tesoura - tesoura", "pedra - pedra":
            System.out.println(comparativoJogada);
            System.out.println("Empate!");
            break;
        case "tesoura - papel", "papel - pedra", "pedra - tesoura":
            System.out.println(comparativoJogada);
            System.out.println("Você venceu esta rodada!");
            pontosPlayer ++;
            break;
    }
}
````


Esse contraste ajuda a visualizar a importância de:
- Otimizar a lógica condicional;
- Evitar redundâncias;
- Manter o código legível e escalável.




## 🛠️ Tecnologias Utilizadas
- **@author** Fabio Peretti Guimarães
- **Java 17**
- Biblioteca padrão do Java (`java.util`)
- Projeto criado para fins de estudo — EBAC | Módulo 10 – Estruturas de Repetição.