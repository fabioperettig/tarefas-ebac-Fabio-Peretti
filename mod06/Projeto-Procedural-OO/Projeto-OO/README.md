## Projeto RPG – Versão Orientada a Objetos##

Este projeto é a versão Orientada a Objetos do RPGzinho criado como estudo de Java. A ideia é mostrar como separar responsabilidades em classes deixa o código mais organizado e escalável em comparação à versão Procedural.

````
Projeto-OO/src-root
├── Program1.java   ← Classe principal (ponto de entrada)
├── Heroi.java      ← Classe do herói (atributos e construtor)
├── Monstro.java    ← Classe do monstro (atributos e construtor)
└── Combate.java    ← Classe responsável pelas regras de batalha
````

[Program1.java](https://github.com/fabioperettig/tarefas-ebac-Fabio-Peretti/blob/main/mod5/Projeto-Procedural-OO/Projeto-OO/src-root/Program1.java)  
[Heroi.java](https://github.com/fabioperettig/tarefas-ebac-Fabio-Peretti/blob/main/mod5/Projeto-Procedural-OO/Projeto-OO/src-root/Heroi.java)  
[Monstro.java](https://github.com/fabioperettig/tarefas-ebac-Fabio-Peretti/blob/main/mod5/Projeto-Procedural-OO/Projeto-OO/src-root/Monstro.java)  
[Combate.java](https://github.com/fabioperettig/tarefas-ebac-Fabio-Peretti/blob/main/mod5/Projeto-Procedural-OO/Projeto-OO/src-root/Combate.java)  


---

### Contexto do Projeto ###

* O jogador controla ataques do herói, enfrentando monstros em combates por turnos. Os monstros são sorteados aleatoriamente a partir de uma array, incluindo também um sistema de raridades.

````
public static void sortearMonstro() {

    double chance = random.nextDouble();
    if (chance < 0.3) {sorteadoMonstro = nomeMonstro[0];}
    else if (chance < 0.5) {sorteadoMonstro = nomeMonstro[1];}
    else if (chance < 0.85) {sorteadoMonstro = nomeMonstro[2];}
    else {sorteadoMonstro = nomeMonstro[3];}
}
````


* Ao vencer, o herói restaura sua vida e enfrenta um novo monstro; se perder, o jogo termina.


### Características do Projeto Orientado a Objetos ###

- Herói e Monstros são representados como objetos, com atributos próprios chamados na Classe Principal [Program1].

````
static Scanner scanner = new Scanner(System.in);

static String[] listaMonstros = {"Goblin verde", "Goblin vermelho", "Goblin azul", "Goblin rosa"};
static Random random = new Random();
static String sorteadoMonstro;

static Heroi heroi = new Heroi("Arthas", 150, new int[] {10, 25, 30, 50});
static Monstro monstro = new Monstro(sorteadoMonstro, 120, new int[] {5,15,20,60});
````

````
public class Heroi {
    public String NomeHeroi;
    public int VidaInicialHeroi;
    public int VidaHeroi;
    public int[] DanoHeroi;

    ///construtor
    public Heroi(String nomeHeroi, int vidaInicialHeroi, int[] danoHeroi) {
        this.NomeHeroi = nomeHeroi;
        this.VidaInicialHeroi = vidaInicialHeroi;
        this.VidaHeroi = vidaInicialHeroi;
        this.DanoHeroi = danoHeroi;
    }
}
````


---

### O que este projeto ensina ###

__Encapsulamento inicial:__ cada entidade (Herói/Monstro) tem sua própria classe.  
__Construtores:__ inicializam os objetos de forma consistente.  
__Organização:__ Program1 cuida do fluxo, enquanto Combate concentra a lógica de batalha.  
__Escalabilidade:__ fica mais fácil adicionar novas regras (crítico, fuga, poções) sem bagunçar o __void main__.  

---

# Saída esperada no Terminal #

````
=== RPG Orientado [OO] ===

Pressione ENTER para começar!

Você encontrou um 'Goblin azul'

=== COMBATE INICIADO ===

Arthas HP: 150 | Goblin azul HP: 120
Aperte ENTER para atacar o Goblin azul
Você causou 25 de dano em Goblin azul
Arthas HP: 150 | Goblin azul HP: 95
...
Goblin azul foi derrotado!

=== COMBATE FINALIZADO ===

Combate vencido e vida restaurada! Um novo monstro se aproxima...
````