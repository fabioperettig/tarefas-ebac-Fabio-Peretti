import java.util.Random;
import java.util.Scanner;



public class Combate {

    public static void statusCombate(Heroi heroi, Monstro monstro, String sorteadoMonstro) {
        System.out.println(heroi.NomeHeroi + " HP: " + heroi.VidaHeroi +
                    " | " + sorteadoMonstro + " HP: " + monstro.VidaMonstro);
    }



    public static void turnoHeroi(Heroi heroi, Monstro monstro, String sorteadoMonstro){
        System.out.println("Aperte ENTER para atacar o " + sorteadoMonstro);
        Program1.scanner.nextLine();
        int ataqueHeroi = heroi.DanoHeroi[Program1.random.nextInt(heroi.DanoHeroi.length)];
        System.out.println("Você causou " + ataqueHeroi + " de dano em " + sorteadoMonstro);
        monstro.VidaMonstro -= ataqueHeroi;
    }

    public static void turnoMonstro(Heroi heroi, Monstro monstro, String sorteadoMonstro){
        System.out.println(sorteadoMonstro + " fará um ataque, pressione ENTER para continuar e prepare-se!");
        Program1.scanner.nextLine();
        int ataqueMonstro = monstro.DanoMonstro[Program1.random.nextInt(monstro.DanoMonstro.length)];
        System.out.println(sorteadoMonstro + " ataca e lhe causa " + ataqueMonstro + " de dano.");
        heroi.VidaHeroi -= ataqueMonstro;
    }

}
