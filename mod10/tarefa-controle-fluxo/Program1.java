import java.util.Scanner;

/**
 * Método criado para saber o Status de um aluxo, através da média
 * sas notas, adicionadas todas de uma vez pelo Scanner input,
 * sendo armazenadas em uma String única.<br><br>
 * {@code • linha = input.nextLine()}
 * <br><br>
 * Após isso, as notas da String são armazenadas dentro de uma array String,
 * usando a virgula como divizor.<br><br>
 * {@code • partes = linha.split(",")}
 * <br><br>
 * @author Fabio Peretti Guimarães
 */
public class Program1 {

    static boolean rodando;
    static int comando;
    static Scanner input = new Scanner(System.in);
    static int[] notas;
    static int media;
    static String linha;
    static String[] partes;

    public static void main(String[] args) {

        System.out.println("\n---- Cálculo de média ----");
        rodando = true;

        do {
            System.out.println("\nAdicione as quatro notas separadas por vírgula.");
            linha = input.nextLine();

            partes = linha.split(",");

            if (partes.length != 4){
                System.out.println("PRECISAM SER EXATAMENTE QUATRO NOTAS.");
                continue;
            }

            extrairNotasString();

            calculoMedia();
            System.out.println("\nA média do aluno é: " + media);

            if (media >= 7){
                System.out.println("\nStatus: APROVADO.");
            } else if (media >= 5){
                System.out.println("\nStatus: EM RECUPERAÇÃO.");
            } else {
                System.out.println("\nStatus: REPROVADO.");
            }

            System.out.println("\nGostaria de iniciar um novo processo?");
            System.out.println("1- Sim");
            System.out.println("2- Não");
            comando = input.nextInt();
            input.nextLine(); // consome o Enter

        }while (comando !=2);

        System.out.println("Encerrando processo.");

    }


    /**
     * Método que converte as notas da array String
     * em um array de Inteiros atra'ves do uso do 'for'
     * e parseInt.
     * <br><br>
     * Após isso, exibe cada nota através de printf,
     * unindo texto e index da array.
     * <br><br>
     */
    public static void extrairNotasString(){
        notas = new int[4];

        for (int i=0; i < 4; i++) {
            notas[i] = Integer.parseInt(partes[i].trim()); //trim() -> remove espaços
        }

        //Saída de notas
        System.out.println("-----------------");
        System.out.println("\n- Notas registradas -\n");

        System.out.printf("Primeira nota: %d\n", notas[0]);
        System.out.printf("Segunda nota: %d\n", notas[1]);
        System.out.printf("Terceira nota: %d\n", notas[2]);
        System.out.printf("Quarta nota: %d\n", notas[3]);


    }

    public static void calculoMedia(){
        int soma = 0;

        for (int n : notas){
            soma += n;
        }
        media = soma/notas.length;
    }
}
