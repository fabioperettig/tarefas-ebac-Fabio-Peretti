import java.util.Arrays;
import java.util.Scanner;

public class SwitchArrayString {

    static String[] Armas = {"Espada", "Arco", "Clava", "Bastão", "Besta", "Escudo"};
    static String[] Armadura = {"Elmo", "Peitoral", "Luvas", "Botas", "Balaclava"};
    static String[] Magico = {"Cajado", "Manto", "Chapéu", "Varinha"};
    static String[] Misc = {"Cristal", "Diamante", "Pergaminho", "Gaze", "Lockpick"};
    static Scanner input = new Scanner(System.in);
    static String item;
    static int comando;

    public static void main(String[] args) {

        System.out.println("\n   .:.Simulador de inventário.:.   ");
        System.out.println("----------------------------------");
        System.out.println("O que deseja fazer?");

        do {
            System.out.println("\n1- Analisar item | 2- Sair");
            comando=input.nextInt();
            switch (comando){
                case 1:
                    System.out.println("| Arma | Armadura | Magia | Misc |");
                    System.out.print("\nInsira o item que você achou: ");
                    item= input.next();

                    analiseItem();

                    break;
                case 2:
                    System.out.println("Encerrando.");
                    break;
                default:
                    System.out.println("Comando desconhecido, insira um comando válido.\n");
            }

        } while (comando !=2);
    }

    /**
     * <li>Utiliza um Stream para percorrer o array correspondente (Armas, Armaduras, etc.)
     * e verifica, se há pelo meos um item compatível com o input(anyMatch()).</li>
     *
     * <li>A expressão lambda (i -> i.equalsIgnoreCase(itemLower)) é usada para comparar cada elemento
     * do array, ignorando diferenças entre maiúsculas e minúsculas.</li>
     *
     * <li>Retornando TRUE, analisa o item informado pelo usuário e identifica
     * a qual categoria ele pertence (Armas, Armaduras, Itens Mágicos ou Misc).</li>
     *
     * <li>Exibe no console a mensagem indicando em qual baú
     * o item deve ser guardado via printf.</li>
     *
     * O printf() lê a string de formatação; Procura espaços %; Preenche cada um com as respectivas
     * variáveis (na ordem) pra preencher cada um desses espaços.
     *
     * @author Fabio Peretti Guimarães
     */
    public static void analiseItem(){
        String itemLower = item.toLowerCase();

        if (Arrays.stream(Armas).anyMatch(i -> i.equalsIgnoreCase(itemLower))) {
            System.out.printf("%s deve ser guardado no baú de Armas, baú 01.%n",item);
        } else if (Arrays.stream(Armadura).anyMatch(i -> i.equalsIgnoreCase(itemLower))) {
            System.out.printf("%s deve ser guardado no baú de Armaduras, baú 02.%n", item);
        } else if (Arrays.stream(Magico).anyMatch(i -> i.equalsIgnoreCase(itemLower))) {
            System.out.printf("%s deve ser guardado no baú de Itens Mágicos, baú 03.%n", item);
        } else if (Arrays.stream(Misc).anyMatch(i -> i.equalsIgnoreCase(itemLower))) {
            System.out.printf("%s deve ser guardado no baú de itens aleatórios, baú 0%d.%n", item,4);
        } else {
            System.out.println("Item desconhecido.");
            //próximo update: novoRegistro();
        }
    }

}
