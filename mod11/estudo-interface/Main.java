import java.util.Scanner;


/**
 * local de intancia das Classes implementadas da interface principal,
 * podendo inclusive ser instanciadas via Scanner.
 *
 * @author fabioperettiguimaraes
 */
public class Main {

    static Scanner input = new Scanner(System.in);
    static String nome;
    static int escolha;
    public static void main(String[] args) {

        //exemplos de Classe Instanciada
        Bladeknight Algalord = new Bladeknight("Algalord");
        SoulMaster Kadaj = new SoulMaster("Kadaj");

        System.out.println("Aqui estão os aventureiros!");

        Algalord.intro();
        Kadaj.intro();

        Algalord.objetivo();
        Kadaj.objetivo();

        Algalord.ataque();
        Kadaj.ataqueEspecial();

        Algalord.respouso();
        Kadaj.respouso();
    }

}
