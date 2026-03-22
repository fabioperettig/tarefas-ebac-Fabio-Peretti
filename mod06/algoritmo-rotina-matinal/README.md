## Algoritmo da Rotina Matinal

Este projeto foi desenvolvido em **Portugol** como parte dos estudos de lógica de programação.  
O objetivo é representar, de forma simples, os passos de uma rotina matinal, utilizando:

- **Variáveis** (`inteiro` e `logico`)
- **Estruturas condicionais** (`se/senao`)
- **Saídas de dados** (`escreva`)

## Descrição

O algoritmo simula os passos da rotina matinal (acordar, levantar, tomar banho, café da manhã, etc.),  
incluindo uma condição que verifica a hora e decide se o despertador deve ser desligado ou ignorado.

````
programa {
  funcao inicio() {

    logico despertadorTocar
    inteiro horario


    escreva("Passo 1: Acordar\n")
    escreva("Passo 2: Abrir os olhos\n")
    escreva("Passo 3: Ver a hora\n")
      se (horario > 7) {
        despertadorTocar = verdadeiro
        escreva("Desligar despertador\n")
      }
      senao {
        despertadorTocar = falso
        escreva("Ignorar\n")
      }
    escreva("Passo 4: Levantar da cama\n")
    ...
  }
}
````