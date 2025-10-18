# 🎓 Cálculo de Média de Aluno (Java)

Projeto desenvolvido como exercício de **controle de fluxo** em Java. O programa solicita que o usuário insira quatro notas de um aluno, separadas por vírgula, calcula a média e informa o status final (Aprovado, Recuperação ou Reprovado).

---

## 🧠 Objetivo do exercício
Este projeto tem como propósito reforçar:
- Leitura de dados via **Scanner**;
- Uso de **estruturas de repetição** (`do-while`) e **decisão** (`if-else`);
- Controle de fluxo com `continue` e limpeza do buffer com `nextLine()`.

---

## 💻 Funcionamento

Exemplo de execução no console:
````
–– Cálculo de média ––

Adicione as quatro notas separadas por vírgula.
7, 8, 6, 9

- Notas registradas -

Primeira nota: 7
Segunda nota: 8
Terceira nota: 6
Quarta nota: 9

A média do aluno é: 7
Status: APROVADO.

Gostaria de iniciar um novo processo?
1- Sim
2- Não
````

## 🧩 Estrutura do código

- **Loop principal (`do-while`)** → controla a execução, valida entradas e permite repetir o processo.

````
do {
    System.out.println("\nAdicione as quatro notas separadas por vírgula.");
    linha = input.nextLine();

    partes = linha.split(",");

    if (partes.length != 4){
        System.out.println("PRECISAM SER EXATAMENTE QUATRO NOTAS.");
        continue;
    }

    extrairNotasString();

    calculoMedia();
    System.out.println("\nA média do aluno é: " + media);

    if (media >= 7){
        System.out.println("\nStatus: APROVADO.");
    } else if (media >= 5){
        System.out.println("\nStatus: EM RECUPERAÇÃO.");
    } else {
        System.out.println("\nStatus: REPROVADO.");
    }
}
````
- **`calculoMedia()`** → soma as notas e calcula a média.  
- **`extrairNotasString()`** → converte as notas de `String` para `int` e exibe no console.
````
public static void extrairNotasString(){
    notas = new int[4];

    for (int i=0; i < 4; i++) {
        notas[i] = Integer.parseInt(partes[i].trim());
    }

    //Saída de notas
    System.out.println("-----------------");
    System.out.println("\n- Notas registradas -\n");

    System.out.printf("Primeira nota: %d\n", notas[0]);
    System.out.printf("Segunda nota: %d\n", notas[1]);
    System.out.printf("Terceira nota: %d\n", notas[2]);
    System.out.printf("Quarta nota: %d\n", notas[3]);


}
````


## 📚 Aprendizados
Durante o desenvolvimento, foram aplicados conceitos importantes como:
- **Escopo de variáveis (global x local)**;
- **Validação de entrada de usuário**;
- **Tratamento de fluxo e repetição**;
- **Boas práticas de exibição de dados formatados**.

---

**👨‍💻 Fabio Peretti Guimarães**  
📘 Projeto EBAC – Módulo: *Controle de Fluxo em Java*  
🗓️ Outubro de 2025