# 🎓 Coleções e Manipulação de Listas parte 2

Projeto desenvolvido como exercício de **Manipulação de Listas e Coleções** em Java. Este projeto tem como finalidade: ser capaz de receber inputs String do usuário, armazenar e manipular este input com **Capitalização**, **Ordenação**, **Fragmentação de String**, dentre outras.
<br><br>
## 💻 Funcionamento

Exemplo de execução e chamada de métodos da Classe Main:
````
System.out.println("\n----- Exercício Ebac – Módulo12 -----\n");
System.out.println("Adicione nome e sexo, separando o grupo por vírgula.");
String inputInfos = input.nextLine();

String[] pessoas = inputInfos.split(",");

for (String pessoaLocal : pessoas) {

    pessoaLocal = pessoaLocal.trim();

    String[] partes = pessoaLocal.split(" ");
    genero = partes[partes.length-1].toUpperCase();
    nome = pessoaLocal.substring(0,pessoaLocal.lastIndexOf(" ")).trim();

    if (genero.equals("M")) {
        listaM.add(nome);
    } else if (genero.equals("F")) {
        listaF.add(nome);
    } else {
        System.out.println("Gênero inválido em: " + pessoaLocal);
    }
}

System.out.println("\n----- Imprimindo listas -----");
System.out.println("Masculino: " + listaM);
System.out.println("Feminino:   " + listaF);
System.out.println("----------------------");
````
<br><br>

## 🧠 Lógica Implementada

✔ Usa dois List<Object> para armazenar homens e mulheres;

✔ Gênero sempre é considerado o último token da entrada;

✔ Funciona com nomes simples e compostos;

✔ Aceita gênero maiúsculo ou minúsculo (M, m, F, f);

✔ Ignora letras “F” ou “M” no nome (ex.: Fabio, Fernanda);


<br> <br>
-------
**👨‍💻 Fabio Peretti Guimarães**  
📘 Projeto EBAC – Módulo 11: *Coleções Parte 1*  
🗓️ Novembro de 2025