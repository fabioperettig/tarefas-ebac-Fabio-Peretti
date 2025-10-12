# 🎨 Descubra a Cor Complementar

Um pequeno programa em Java que identifica a cor complementar de uma cor primária informada pelo usuário.
Ideal para praticar condicionais com Strings (if / else if / else) e comparações com equalsIgnoreCase().

#### 💡 Objetivo de estudo
- Estruturas condicionais (if, else if, else)
- Comparação de Strings com equalsIgnoreCase()
- Saída de texto com emojis e formatação amigável
- Organização de código com métodos auxiliares

#### 🚀 Como funciona
 1.	O programa exibe uma lista de cores disponíveis.
 2.	O usuário digita o nome de uma cor primária.
 3.	O sistema retorna a cor complementar correspondente (baseada no círculo cromático).

#### 💻 Exemplo de execução
````
Descubra a cor complementar
-----------------------------------------------------
Vermelho | Laranja | Amarelo | Verde | Azul | Violeta
-----------------------------------------------------
Digite uma cor primária: Amarelo
A cor complementar de 🟡Amarelo é 🟣Violeta.
````

#### 🧩 Lógica utilizada
As cores e suas complementares são definidas conforme o círculo cromático básico:

| 🎨 Cor Primária | Cor Complementar |
|--------------|------------------|
| 🔴 Vermelho   | 🟢 Verde         |
| 🟠 Laranja    | 🔵 Azul          |
| 🟡 Amarelo    | 🟣 Violeta       |
| 🟢 Verde      | 🔴 Vermelho      |
| 🔵 Azul       | 🟠 Laranja       |
| 🟣 Violeta    | 🟡 Amarelo       |

#### 🛠️ Tecnologias utilizadas
- Java 17
- IntelliJ IDEA CE