import java.util.Scanner;
import java.util.Random;

public class Program1 {

    static Scanner scanner = new Scanner(System.in);

    static String[] listaMonstros = {"Goblin verde", "Goblin vermelho", "Goblin azul", "Goblin rosa"};
    static Random random = new Random();
    static String sorteadoMonstro;

    static Heroi heroi = new Heroi("Arthas", 150, new int[] {10, 25, 30, 50});
    static Monstro monstro = new Monstro(sorteadoMonstro, 120, new int[] {5,15,20,60});


    public static void main(String[] args) {
        System.out.println("=== RPG Orientado [OO] ===");
        System.out.println("\n Pressione ENTER para começar!");
        scanner.nextLine();

        while (heroi.VidaHeroi > 0) {

            sortearMonstro();
            System.out.println("Você encontrou um " + sorteadoMonstro);
            System.out.println("\n Pressione ENTER para começar o combate!");
            scanner.nextLine();

            System.out.println("=== COMBATE INICIADO ===");
            Combate.statusCombate(heroi, monstro, sorteadoMonstro);

            while (heroi.VidaHeroi > 0 && monstro.VidaMonstro > 0) {

                Combate.turnoHeroi(heroi, monstro, sorteadoMonstro);
                Combate.statusCombate(heroi, monstro, sorteadoMonstro);

                if (monstro.VidaMonstro <= 0) {
                    System.out.println(sorteadoMonstro + " foi derrotado!");
                    break;
                }

                Combate.turnoMonstro(heroi, monstro, sorteadoMonstro);
                Combate.statusCombate(heroi, monstro, sorteadoMonstro);

                if (heroi.VidaHeroi <= 0) {
                    System.out.println(heroi.NomeHeroi + " foi derrotado, fim de jogo.");
                    break;
                }

            }

            if (heroi.VidaHeroi > 0) {
                heroi.VidaHeroi = heroi.VidaInicialHeroi;
                System.out.println("=== COMBATE FINALIZADO ===");
                System.out.println("\nCombate vencido e vida restaurada! Um novo monstro se aproxima...");
                monstro.VidaMonstro = monstro.VidaInicialMonstro;
            }

        }

    }

    public static void sortearMonstro() {
        double chance = random.nextDouble();
        if (chance < 0.3) {sorteadoMonstro = listaMonstros[0];}
        else if (chance < 0.5) {sorteadoMonstro = listaMonstros[1];}
        else if (chance < 0.85) {sorteadoMonstro = listaMonstros[2];}
        else {sorteadoMonstro = listaMonstros[3];}
    }

}