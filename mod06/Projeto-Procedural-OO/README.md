## Projeto Procedural vs Orientado a Objetos — EBAC ##

Este repositório faz parte do Curso de Java Back End da EBAC 🎓.  
O objetivo é demonstrar, na prática, as diferenças entre um projeto escrito de forma Procedural e outro escrito de forma Orientada a Objetos (OO).

````
Projeto-Procedural-OO/
├── Projeto-Procedural/   ← versão procedural do projeto 
└── Projeto-OO/           ← versão orientada a objetos do projeto
````


### Projeto Procedural ### 

Esse formato foi feito propositalmente para mostrar como o código pode ficar mais “engessado” e difícil de organizar quando cresce.

- Implementado em um único arquivo Java (Program1.java);
- Todas as variáveis, funções e fluxo do jogo estão centralizados na classe principal;
- Simula um RPG simples, com:
    - Um herói e um monstro;
    - Sorteio de monstros com diferentes probabilidades;
    - Sistema de combate em turnos.  


---


### Projeto Orientado a Objetos (OO) ###

Este formato evidencia a vantagem da modularidade e reuso de código, características fundamentais da Programação Orientada a Objetos.  

- Implementado com múltiplas classes (Heroi, Monstro, Combate, Program1);
- Cada entidade do jogo possui atributos e responsabilidades próprias;
- O fluxo principal (Program1) apenas orquestra o funcionamento;
- Sistema de combate isolado em uma classe dedicada (Combate), facilitando futuras expansões.

---

Este projeto é uma demonstração prática de como a escolha da estrutura do código impacta diretamente a clareza, organização e capacidade de manutenção. O Procedural funciona bem em pequenos programas, mas a Orientação a Objetos se mostra essencial para projetos mais complexos e escaláveis.