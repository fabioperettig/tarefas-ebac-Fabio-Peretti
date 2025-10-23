# 🧙‍♂️ Estudo de Interfaces em Java

Projeto desenvolvido como **material de estudo** sobre o uso de **Interfaces**, **Polimorfismo** e **métodos default/static** em Java.  
O objetivo é demonstrar na prática como diferentes classes podem compartilhar um mesmo contrato de comportamento, mantendo suas próprias implementações e personalidades.

---

## 🧩 Estrutura do Projeto
````
estudo-interface/
│
├── Main.java
├── ComportamentoRPG.java
├── Bladeknight.java ⚔️
└── SoulMaster.java 🔮
````
---

## ⚙️ Conceitos Aplicados

### 1. **Interface como Contrato**
A interface `ComportamentoRPG` define o **conjunto mínimo de métodos** que todo personagem deve possuir:
````
public interface ComportamentoRPG {
    String getNome();
    int dano = 10;

    void ataque();
    void ataqueEspecial();
    void respouso();
    void objetivo();
    void derrota();
}
````
Cada classe (Bladeknight e SoulMaster) é obrigada a implementar todos esses métodos, garantindo que possuam o mesmo conjunto de ações básicas — mesmo que suas execuções sejam distintas.

---

2. Métodos default e static

A interface também traz métodos com comportamento pré-definido:
````
default void intro() {
    System.out.println(getNome() + " é da classe " + getClass().getSimpleName());
}

static void credito() {
    System.out.println("Desenvolvido por Fabio Peretti Guimarães");
}
````
- O método default pode ser usado diretamente ou sobrescrito pelas classes.
- Já o método static é fixo, e só pode ser chamado diretamente pela interface: **ComportamentoRPG.credito();**

---

3. Polimorfismo em Ação

Na Main.java, os objetos são instanciados e acessados apenas pelos métodos definidos na interface — sem precisar saber a classe real de cada um:
````
Bladeknight Algalord = new Bladeknight("Algalord");
SoulMaster Kadaj = new SoulMaster("Kadaj");

Algalord.intro();
Kadaj.intro();

Algalord.objetivo();
Kadaj.objetivo();

Algalord.ataque();
Kadaj.ataqueEspecial();
````

- Saída esperada:
````
Aqui estão os aventureiros!

Algalord é da classe Bladeknight
Kadaj é da classe SoulMaster

Seu objetivo é derrotar todos os Tarkans!
Seu objetivo é retirar os poderes de Dark Kundun!

{...}
````

---

4. Randomização de Dano

Cada personagem calcula um dano aleatório baseado em um valor fixo (dano = 10) definido na interface:
````
@Override
public void ataque() {
    System.out.printf("O mago %s ataca lança fireballs nos inimigos!%n",nome);
    int SMdano = dano*(int)(Math.random()*3+1);
    System.out.println(nome + " lhe causou um dano de: " + SMdano);
}
````
Essa expressão gera valores inteiros entre 1× e 3× o dano base, simulando variação de ataque em combates.

---

5. Uso de getNome() e getClass()

A interface exige que cada classe forneça seu próprio nome por meio de:
````
/**
* Método {@code default} para pegar o nome do Objeto por uma String getNome()
* através de um construtor da Classe implementada.
*/
default void intro() {System.out.println(getNome() + " é da classe " + getClass().getSimpleName());};


@Override
public String getNome() {
    return nome;
}

"Kadaj é da classe SoulMaster."
````

## 💬 Explicação Simplificada
- **Interface →** Define o contrato do que todos os personagens devem saber fazer.
- **Classe →** Dá a implementação concreta, com seu estilo e comportamento.
- **Polimorfismo →** Permite que cada método reaja conforme sua própria classe.
- **Método default →** Fornece um comportamento “de fábrica”, personalizável.
- **Método static →** Fornece uma função fixa (imutável) da interface.

**@author** Fabio Peretti Guimarães

Biblioteca padrão do Java (java.util)

Projeto criado para fins de estudo — EBAC | Módulo 11 – Coleções.