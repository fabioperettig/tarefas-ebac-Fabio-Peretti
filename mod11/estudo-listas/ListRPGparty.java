import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ListRPGparty {

    static String nome;
    static Scanner scanner = new Scanner(System.in);
    static boolean gameON;
    static String escolha;

    public static void main(String[] args) {

        List<String> party = new ArrayList<>();
        System.out.println("Entre com seu nome");
        nome = scanner.nextLine();
        party.add(nome);
        System.out.println("\n"+party);

        gameON = true;

        while(gameON){

            System.out.println("Gostaria de adicionar um membro? SIM | NÃO");
            escolha = scanner.nextLine();

            if (escolha.equalsIgnoreCase("sim")){
                System.out.println("\nadicione membro:");
                nome = scanner.nextLine();
                party.add(nome);
                System.out.println("\nSua party atual é:");
                System.out.println(party);
            } else {
                gameON = false;
            }
        }

        System.out.println("Party completa.");

    }

}
