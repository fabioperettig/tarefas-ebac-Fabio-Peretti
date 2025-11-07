# 🎓 Coleções e Manipulação de Listas

Projeto desenvolvido como exercício de **Manipulação de Listas e Coleções** em Java. Este projeto tem como finalidade: ser capaz de receber inputs String do usuário, armazenar e manipular este input de formas diversas como **Capitalização**, **Ordenação**, **Fragmentação de String**, dentre outras.


## 🧠 Objetivo do exercício
Este projeto foi dividido em duas partes, onde cada parte teve um algoritmo próprio a ser seguido, sendo eles:

### Parte 1
- Ler os dados do usuário;
- Aplicar o método split();
- Adicionar toda a coleção a uma lista;
- Aplicar a capitalização e exibi-los em ordem alfabética;

### Parte 2
- Aplicar um gênero aos nomes da lista de forma automática;
- Agrupar os nomes a uma nova lista dedicada ao gênero específico;
- Ordená-los em exibi-los em ordem alfabética, em suas respectivas listas.
<br><br>
O diferencial proposto neste projeto foi **aproveitar ao máximo o input do usuário**, automatizando todo o processo de Capitalização, Ordenação e Flexão de Gênero, tornando dispensável um segundo input de usuário para a execução da parte 2 do projeto.

<br><br>
## 💻 Funcionamento

Exemplo de execução e chamada de métodos da Classe Main:
````
System.out.println("\n----- Exercício Ebac – Módulo11 | Parte 01 -----");
    Thread.sleep(cooldown);

    System.out.println("Adicione os nomes desejados, separados por vírgula:");
    listaInput = input.nextLine();
    String[] nomes = listaInput.split("\\s*,\\s*");

    Collections.addAll(listaNomes, nomes);

    Thread.sleep(cooldown);
    System.out.println("\n#### IMPRESSÃO DE LISTA ORDENADA ####");
    printNomesOrdem();

    System.out.println("\n----- Exercício Ebac – Módulo11 | Parte 02 -----");
    System.out.println("\nAnalisando nomes e atribuindo sexo/gênero:");

    Thread.sleep(cooldown);
    checarVogal();

    Thread.sleep(cooldown);
    separarSexo();
````
<br><br>
## 🧩 Principais métodos

- **printNomesOrdem()**
Imprime a lista principal de nomes em ordem alfabética, formatando cada nome para que apenas o primeiro caractere fique em caixa alta e impressos lado a lado, com espaçamento fixo através de um print format.

````
public static void printNomesOrdem() {
    List<String> ordem = new ArrayList<>(listaNomes);
    ordem.sort(String.CASE_INSENSITIVE_ORDER);

    for (String nome : ordem) {
        String printUpper = nome.substring(0, 1).toUpperCase() + nome.substring(1);
        System.out.printf("%-6s | ", printUpper);
    }

    System.out.println();
}
````
<br><br>
- **checarVogal()**

Analisa todos os nomes inseridos pelo input e atribui automaticamente um gênero, com base na última letra de cada nome, seguindo seguinte algoritmo:

- Termina com 'a' → Feminino (F)
- Termina com 'o', 'l' → Masculino (M)
- Termina com 'e', 'i', 'm', 'n', 'r', 's', 'z' → checa exceções
- Qualquer outro caractere → indefinido ("?")

`````
public static void checarVogal() {

    for (String nome : listaNomes) {
        nome = nome.trim();  // limpa espaços extras
        char ultimaLetra = Character.toLowerCase(nome.charAt(nome.length() - 1));  // pega a última letra da String

        String sexo = null;

        switch (ultimaLetra) {

            case 'a' -> {
                if (nome.equalsIgnoreCase("Kaka") || nome.equalsIgnoreCase("Zeca"))
                    sexo = "M";
                else
                    sexo = "F";
            }

            case 'o', 'l' -> {
                if (nome.equalsIgnoreCase("Muriel"))
                    sexo = "F";
                else
                    sexo = "M";
            }

            case 'e', 'i' -> {...}

            default -> sexo = "?";

        }

        String nomeFormatado = nome.substring(0, 1).toUpperCase() + nome.substring(1).toUpperCase();
        //System.out.println(nomeFormatado + " – " + sexo);

        System.out.printf("%-6s – %s | ", nomeFormatado,sexo);
    }

    System.out.println();
}
`````
<br><br>
- **separarSexo()**

Funciona sob o mesmo princípio do método **checarVogal()**, mas que retorna os nomes agrupados em duas arrayList<>() do tipo String. Após os agrupamentos, ambas as listas são ordenadas alfabeticamente e impressas no console com formatação capitalizada.
````
public static void separarSexo() {

    List<String> nomesMasculinos = new ArrayList<>();
    List<String> nomesFemininos = new ArrayList<>();

    for (String nome : listaNomes) {
        nome = nome.trim();

        char ultimaLetra = Character.toLowerCase(nome.charAt(nome.length()-1));

        switch (ultimaLetra) {

            case 'a' -> {
                if (nome.equalsIgnoreCase("Kaka") || nome.equalsIgnoreCase("Zeca"))
                    nomesMasculinos.add(nome);
                else
                    nomesFemininos.add(nome);
            }

            case 'o', 'l' -> {
                if (nome.equalsIgnoreCase("Muriel"))
                    nomesFemininos.add(nome);
                else
                    nomesMasculinos.add(nome);
            }

            case 'e', 'i' -> {
                if (nome.equalsIgnoreCase("Alice") || nome.equalsIgnoreCase("Aline") ||
                        nome.equalsIgnoreCase("Daniele") || nome.equalsIgnoreCase("Gisele")
                        || nome.equalsIgnoreCase("Jaqueline") || nome.equalsIgnoreCase("Naomi"))
                    nomesFemininos.add(nome);
                else
                    nomesMasculinos.add(nome);
            }

            case 'm', 'n' -> {
                if (nome.equalsIgnoreCase("Mirian") || nome.equalsIgnoreCase("Evelin") ||
                        nome.equalsIgnoreCase("Karen") || nome.equalsIgnoreCase("Kathelyn"))
                    nomesFemininos.add(nome);
                else
                    nomesMasculinos.add(nome);
            }

            case 'r', 's' -> {
                if (nome.equalsIgnoreCase("Nair") || nome.equalsIgnoreCase("Eleonor") ||
                        nome.equalsIgnoreCase("Esther") || nome.equalsIgnoreCase("Jennifer") ||
                        nome.equalsIgnoreCase("Lais") || nome.equalsIgnoreCase("Doris"))
                    nomesFemininos.add(nome);
                else
                    nomesMasculinos.add(nome);
            }

            case 'z' -> {
                if (nome.equalsIgnoreCase("Beatriz"))
                    nomesFemininos.add(nome);
                else
                    nomesMasculinos.add(nome);
            }
        }
    }

    Collections.sort(nomesMasculinos, String.CASE_INSENSITIVE_ORDER);
    Collections.sort(nomesFemininos, String.CASE_INSENSITIVE_ORDER);

    System.out.println("\n ---- Nomes Masculinos (M) ----");
    for (String nome : nomesMasculinos){
        String nomeFormatM = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
        System.out.printf("%-6s | ", nomeFormatM);
    }
    System.out.println();

    System.out.println("\n ---- Nomes Femininos (F) ----");
    for (String nome : nomesFemininos){
        String nomeFormatF = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
        System.out.printf("%-6s | ", nomeFormatF);
    }
}

````
---
<br> <br>
**👨‍💻 Fabio Peretti Guimarães**  
📘 Projeto EBAC – Módulo 11: *Coleções Parte 1*  
🗓️ Novembro de 2025