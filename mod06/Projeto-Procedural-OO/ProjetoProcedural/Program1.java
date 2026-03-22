import java.util.Scanner;
import java.util.Random;

public class Program1 {


    public static String nomeHeroi = "Arthas";
    public static int vidaInicialHeroi = 150;
    public static int vidaHeroi;
    public static int[] danoHeroi = {10,25,30,50};
    public static String[] nomeMonstro = {"Goblin verde", "Goblin vermelho", "Goblin azul", "Goblin rosa"};
    public static String sorteadoMonstro;
    public static int vidaInicialMonstro = 120;
    public static int vidaMonstro;
    public static int[] danoMonstro = {5,15,20,60};
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {
        System.out.println("=== RPG Procedural ===");
        vidaHeroi = vidaInicialHeroi;
        System.out.println("\n Pressione ENTER para começar!");
        scanner.nextLine();

        while (vidaHeroi > 0) {

            sortearMonstro();
            vidaMonstro = vidaInicialMonstro;
            System.out.println("Você encontrou um " + sorteadoMonstro);
            System.out.println("\n Pressione ENTER para começar o combate!");
            scanner.nextLine();

            System.out.println("=== COMBATE INICIADO ===");
            statusCombate();

            while (vidaHeroi > 0 && vidaMonstro > 0) {

                turnoHeroi();
                statusCombate();

                if (vidaMonstro <= 0) {
                    System.out.println(sorteadoMonstro + " foi derrotrado!");
                    break;
                }

                turnoMonstro();
                statusCombate();

                if (vidaHeroi <= 0) {
                    System.out.println(nomeHeroi + " foi derrotado, fim de jogo.");
                    break;
                }

            }

            if (vidaHeroi > 0) {
                vidaHeroi = vidaInicialHeroi;
                System.out.println("=== COMBATE FINALIZADO ===");
                System.out.println("\nCombate vencido e vida restaurada! Um novo monstro se aproxima...");
            }

        }

    }

    public static void statusCombate() {
        System.out.println(nomeHeroi + " HP: " + vidaHeroi + " | " + sorteadoMonstro + " HP: " + vidaMonstro);
    }


    public static void sortearMonstro() {
        double chance = random.nextDouble();
        if (chance < 0.3) {sorteadoMonstro = nomeMonstro[0];}
        else if (chance < 0.5) {sorteadoMonstro = nomeMonstro[1];}
        else if (chance < 0.85) {sorteadoMonstro = nomeMonstro[2];}
        else {sorteadoMonstro = nomeMonstro[3];}
    }



    public static void turnoHeroi(){
        System.out.println("Aperte ENTER para atacar o " + sorteadoMonstro);
        scanner.nextLine();
        int ataqueHeroi = danoHeroi[random.nextInt(danoHeroi.length)];
        System.out.println("Você causou " + ataqueHeroi + " de dano em " + sorteadoMonstro);
        vidaMonstro -= ataqueHeroi;
    }

    public static void turnoMonstro(){
        System.out.println(sorteadoMonstro + " fará um ataque, pressione ENTER para continuar e prepare-se!");
        scanner.nextLine();
        int ataqueMonstro = danoMonstro[random.nextInt(danoMonstro.length)];
        System.out.println(sorteadoMonstro + " ataca e lhe causa " + ataqueMonstro + " de dano.");
        vidaHeroi -= ataqueMonstro;
    }



}