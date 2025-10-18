# 🧠 Estudos de Switch Case em Java

Este repositório reúne pequenos projetos criados para praticar e compreender o comportamento da estrutura `switch-case` em diferentes contextos dentro da linguagem **Java**.

Cada classe aborda um aspecto específico, combinando condicionais, laços e manipulação de dados.

---

## 📘 Projetos incluídos

### 🔹 `Main.java`
Demonstra o uso básico do **`switch-case`** com valores numéricos simples, destacando a lógica condicional e a importância dos blocos `break`.

````
System.out.println("Insira lvl: ");
level = input.nextInt();

switch(level){
    case 1:
        System.out.println("Level é Armor Bronze " + level);
        break;
    case 2:
        System.out.println("Level é Armor Prata " + level);
        break;
    case 3:
        System.out.println("Level é Armor Gold " + level);
        break;
    default:
        System.out.println("Level desconhecido.");
        break;
}
````

---

### 🔹 `SwitchArray.java`
Exemplo de **integração entre `for` e `switch`**, percorrendo um array de níveis (`Integer[]`) e classificando cada valor em categorias:
- Nível iniciante  
- Nível intermediário  
- Nível avançado  
- Nível máximo  

Também inclui uma segunda variação (`switchScan`) que permite ler um valor digitado pelo usuário e aplicar a mesma lógica condicional.

````
static Integer[] levels = {1,2,3,4,5,6,7,8,9,10};

public static void switchFOR(){
    for (int level : levels) {
        switch (level){
            case 1,2,3:
                System.out.println("Nível iniciante: " + level);
                break;
            case 4,5,6:
                System.out.println("Nível intemerdiário: " + level);
                break;
            case 7,8,9:
                System.out.println("Nível avançado: " + level);
                break;
            default:
                System.out.println("Nível Máximo: " + level);
                break;
        }
    }
}
````

---

### 🔹 `SwitchArrayString.java`
Um mini projeto que une **loops, condicionais e comparações de strings**, demonstrando:
- Como o `switch-case` se comporta com **Strings**;
- O uso de **`Arrays.stream()` e expressões lambda** (`anyMatch`) para validar categorias;
- A aplicação do **`printf()`** para **formatar saídas personalizadas** e criar respostas dinâmicas no console.

````
static String[] Armas = {"Espada", "Arco", "Clava", "Bastão", "Besta", "Escudo"};
static String[] Armadura = {"Elmo", "Peitoral", "Luvas", "Botas", "Balaclava"};
static String[] Magico = {"Cajado", "Manto", "Chapéu", "Varinha"};
static String[] Misc = {"Cristal", "Diamante", "Pergaminho", "Gaze", "Lockpick"};

do {
    System.out.println("\n1- Analisar item | 2- Sair");
    comando=input.nextInt();
    switch (comando){
        case 1:
            System.out.println("| Arma | Armadura | Magia | Misc |");
            System.out.print("\nInsira o item que você achou: ");
            item= input.next();

            analiseItem();

            break;
        case 2:
            System.out.println("Encerrando.");
            break;
        default:
            System.out.println("Comando desconhecido, insira um comando válido.\n");
    }
} while (comando !=2);

{...}

if (Arrays.stream(Armas).anyMatch(i -> i.equalsIgnoreCase(itemLower))) {
    System.out.printf("%s deve ser guardado no baú de Armas, baú 01.%n",item);
} else if (Arrays.stream(Armadura).anyMatch(i -> i.equalsIgnoreCase(itemLower))) {
    System.out.printf("%s deve ser guardado no baú de Armaduras, baú 02.%n", item);
} else if (Arrays.stream(Magico).anyMatch(i -> i.equalsIgnoreCase(itemLower))) {
    System.out.printf("%s deve ser guardado no baú de Itens Mágicos, baú 03.%n", item);
} else if (Arrays.stream(Misc).anyMatch(i -> i.equalsIgnoreCase(itemLower))) {
    System.out.printf("%s deve ser guardado no baú de itens aleatórios, baú 0%d.%n", item,4);
} else {
    System.out.println("Item desconhecido.");
}
````

---

## 💡 Conceitos explorados

- Estrutura `switch-case` com múltiplos valores por caso  
- Uso de `for` e `Scanner` em conjunto  
- Comparações com `equalsIgnoreCase()`  
- Streams e expressões **lambda**  
- Saídas formatadas com `System.out.printf()`  
- Boas práticas de organização e documentação com **JavaDoc**

---

## 🧩 Autor

**Fabio Peretti Guimarães**  
📅 Projeto de estudos — EBAC | Módulo 10  
💬 Foco: lógica condicional, loops e boas práticas em Java.