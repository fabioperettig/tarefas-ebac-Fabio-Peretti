import java.util.Scanner;
import java.util.Random;

public class ExemploWhileBoolen {

    static Random random = new Random();
    static Scanner input = new Scanner(System.in);
    static int pontosPlayer = 0;
    static int pontosBot = 0;
    static boolean gameIniciado;
    static String escolhaBot;
    static String jogadaPlayer = "";



    public static void main(String[] args) {

        System.out.println("Simulador de jokenpo");
        System.out.println("Gostaria de iniciar o game? Sim ou não.");
        String resposta = input.nextLine();

        while(resposta.equalsIgnoreCase("sim")) {

            gameIniciado = true;

            while (gameIniciado) {
                System.out.println("\n---------------------------\n");
                System.out.println("Seus pontos: " + pontosPlayer +
                        " | " + "Pontos do Bot: " + pontosBot);

                do {
                    System.out.println("\nEscolha sua jogada: Pedra, Papel ou Tesoura");
                    jogadaPlayer = input.nextLine();

                    //while jogadaPlayer != "Pedra" (trocar IF)
                    if (jogadaPlayer.equalsIgnoreCase("Pedra")||
                            jogadaPlayer.equalsIgnoreCase("Papel")||
                            jogadaPlayer.equalsIgnoreCase("Tesoura")) {
                    } else {
                        System.out.println("Jogada não permitida. Tente novamente.");
                        jogadaPlayer = ""; //retorna valor para vazio
                    }


                } while (jogadaPlayer.isEmpty());

                jogadaBot();
                metodoUsado();

                if (pontosPlayer == 3 || pontosBot == 3){
                    gameIniciado = false;
                }
            }

            if (pontosPlayer == 3){
                System.out.println("\n---------------------------\n");
                System.out.println("Seus pontos: " + pontosPlayer +
                                " | " + "Pontos do Bot: " + pontosBot);
                System.out.println("\nVocê ganhou.");
            } else {
                System.out.println("\n---------------------------\n");
                System.out.println("Seus pontos: " + pontosPlayer +
                        " | " + "Pontos do Bot: " + pontosBot);
                System.out.println("\nO Bot ganhou.");
            }

            System.out.println("\nDeseja jogar novamente? (Sim ou Não)");
            resposta = input.nextLine();
            pontosPlayer = 0;
            pontosBot = 0;

        }
    }

    public static void jogadaBot(){
        double jogada = random.nextDouble();
        if (jogada < 0.33) {
             escolhaBot= "Pedra";
        } else if (jogada < 0.66) {
            escolhaBot= "Papel";
        } else {
            escolhaBot= "Tesoura";
        }
    }

    public static void metodoUsado(){
        double metodo = random.nextDouble();

        if (metodo < 0.50) {comparativoIf();}
        else {comparativoSwitch();}
    }

    /**
     * Método criado de forma proposital para compará-lo com Switch Case.<br>
     * @Deprecated código desnecessariamente grande
     * e substituível pelo método comparativoSwitch().
     * @author fabioperettiguimarães
     */
    public static void comparativoIf() {

        String jogadas = jogadaPlayer.toLowerCase() + " - " + escolhaBot.toLowerCase();

        String comparativoJogada = "Você escolheu '" + jogadaPlayer +
                "', enquanto Bot escolheu '" + escolhaBot + "'.";

        if(jogadaPlayer.equalsIgnoreCase("Pedra")
                && escolhaBot.equalsIgnoreCase("Papel")){
                System.out.println(comparativoJogada);
                System.out.println("Bot venceu esta rodada!");
                pontosBot ++;
        }
        if(jogadaPlayer.equalsIgnoreCase("Papel")
                && escolhaBot.equalsIgnoreCase("Papel")){
                System.out.println(comparativoJogada);
                System.out.println("Empate!");
        }
        if(jogadaPlayer.equalsIgnoreCase("Tesoura")
                && escolhaBot.equalsIgnoreCase("Papel")){
                System.out.println(comparativoJogada);
                System.out.println("Você venceu esta rodada!");
                pontosPlayer ++;
        }
        if(jogadaPlayer.equalsIgnoreCase("Pedra")
                && escolhaBot.equalsIgnoreCase("Pedra")){
                System.out.println(comparativoJogada);
                System.out.println("Empate!");
        }
        if(jogadaPlayer.equalsIgnoreCase("Papel")
                && escolhaBot.equalsIgnoreCase("Pedra")){
                System.out.println(comparativoJogada);
                System.out.println("Você venceu esta rodada!");
                pontosPlayer ++;
        }
        if(jogadaPlayer.equalsIgnoreCase("Tesoura")
                && escolhaBot.equalsIgnoreCase("Pedra")){
                System.out.println(comparativoJogada);
                System.out.println("Bot venceu esta rodada!");
                pontosBot ++;
        }
        if(jogadaPlayer.equalsIgnoreCase("Pedra")
                && escolhaBot.equalsIgnoreCase("Tesoura")){
                System.out.println(comparativoJogada);
                System.out.println("Você venceu esta rodada!");
                pontosPlayer ++;
        }
        if(jogadaPlayer.equalsIgnoreCase("Papel")
                && escolhaBot.equalsIgnoreCase("Tesoura")){
                System.out.println(comparativoJogada);
                System.out.println("Bot venceu esta rodada!");
                pontosBot ++;
        }
        if(jogadaPlayer.equalsIgnoreCase("Tesoura")
                && escolhaBot.equalsIgnoreCase("Tesoura")){
                System.out.println(comparativoJogada);
                System.out.println("Empate!");
        }
    }

    public static void comparativoSwitch(){

        String jogadas = jogadaPlayer.toLowerCase() + " - " + escolhaBot.toLowerCase();

        String comparativoJogada = "Você escolheu '" + jogadaPlayer +
                "', enquanto Bot escolheu '" + escolhaBot + "'.";

        switch (jogadas){
            case "pedra - papel", "tesoura - pedra", "papel - tesoura":
                System.out.println(comparativoJogada);
                System.out.println("Bot venceu esta rodada!");
                pontosBot ++;
                break;
            case "papel - papel", "tesoura - tesoura", "pedra - pedra":
                System.out.println(comparativoJogada);
                System.out.println("Empate!");
                break;
            case "tesoura - papel", "papel - pedra", "pedra - tesoura":
                System.out.println(comparativoJogada);
                System.out.println("Você venceu esta rodada!");
                pontosPlayer ++;
                break;
        }
    }

}