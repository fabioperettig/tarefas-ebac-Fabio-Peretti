## Projeto RPG – Versão Procedural##

Este projeto implementa um sistema simples de RPG em turno em Java, desenvolvida de forma procedural para fins didáticos.  
A ideia é mostrar como a lógica pode ser estruturada sem Orientação a Objetos, mantendo tudo concentrado em um único arquivo/Classe (Program1).

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
```


* Ao vencer, o herói restaura sua vida e enfrenta um novo monstro; se perder, o jogo termina.


### Características do Projeto Procedural ###

– Tudo em um único arquivo: variáveis, funções (voids) e a lógica principal (main).

– Uso de variáveis estáticas globais para representar atributos do herói e dos monstros.

- Métodos utilitários (como sortearMonstro, turnoHeroi, turnoMonstro) que manipulam diretamente essas variáveis globais.

- O fluxo do jogo é controlado por loops e condicionais no próprio main.

✅ Simples de implementar, ótimo para estudos iniciais.

❌ Escalabilidade limitada: conforme o projeto cresce, a manutenção fica mais difícil, com muito código duplicado e acoplado.

---

Este exercício me ajudou a perceber na prática as limitações de um projeto procedural: o código funciona, mas rapidamente começa a ficar “apertado” e repetitivo.
Foi uma forma clara de enxergar por que a Orientação a Objetos existe e como ela pode tornar o código mais organizado e fácil de evoluir.