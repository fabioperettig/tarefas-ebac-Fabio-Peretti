# Projeto: Classe Abstrata Pessoa (PFisica e PJuridica)

Este projeto foi desenvolvido como exercício da EBAC para praticar os conceitos de **classes abstratas**, **herança** e **polimorfismo** em Java.  
O sistema simula pessoas físicas e jurídicas, permitindo que cada tipo apresente seus próprios dados através do método abstrato `discriminar()`.

---

## 🧠 Objetivos do Projeto

- Criar uma classe abstrata `Pessoa`, contendo os atributos e comportamentos comuns.
- Implementar as subclasses `PFisica` e `PJuridica`, especializando o que for necessário.
- Demonstrar **polimorfismo**, chamando o mesmo método (`discriminar()`) em objetos de tipos diferentes.
- Praticar construtores com `super()`.
- Organizar o projeto de forma simples, limpa e orientada a objetos.

---

## 🏗 Estrutura das Classes

````
Pessoa (abstrata)
├── atributos:
│   • nome
│   • endereco
│
├── métodos:
│   • discriminar()  ← abstrato
│
└── especializações:
    ├── PFisica
    │     • cpf
    │     • sobrescreve discriminar()
    │
    └── PJuridica
          • cnpj
          • nome fantasia
          • sobrescreve discriminar()
````
---

## 🚀 Funcionamento

No método `main` são criadas três pessoas físicas e três pessoas jurídicas.  
O método `discriminar()` é chamado tanto diretamente quanto através do método utilitário `imprimir(Pessoa)`.

Exemplo de chamada:

````
PFisica pf1 = new PFisica("João", "São Paulo", "123.456.789-10");
PFisica pf2 = new PFisica("Maria", "Bahia", "332.678.456-32");
PFisica pf3 = new PFisica("Jorge", "Santa Catarina", "450.345.365-09");

PJuridica pj1 = new PJuridica(...);
PJuridica pj2 = new PJuridica(...);
PJuridica pj3 = new PJuridica(...);


//fisica
pf1.discriminar();
pf2.discriminar();
imprimir(pf3);

//juridica
imprimir(pj1);
imprimir(pj2);
pj3.discriminar();
````
## 📚 Conceitos Aplicados
- Classe Abstrata: Pessoa não pode ser instanciada diretamente.
- Herança: PFisica e PJuridica herdam e especializam Pessoa.
- Polimorfismo: O método discriminar() é executado conforme o tipo real do objeto.
- Construtores com super(): Reaproveitamento de atributos comuns.
- Organização de classes: Separação clara das responsabilidades.
<br> <br>
-------
**👨‍💻 Fabio Peretti Guimarães**  
📘 Projeto EBAC – Módulo 13
🗓️ Novembro de 2025