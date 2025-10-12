import java.util.Scanner;

/**
 * @author Fabio Peretti Guimarães
 */
public class Main {

    public static void main(String[] args) {

        Scanner inputColor = new Scanner(System.in);

        System.out.println("\nDescubra a cor complementar");
        System.out.println("-----------------------------------------------------");
        System.out.println("Vermelho | Laranja | Amarelo | Verde | Azul | Violeta");
        System.out.println("-----------------------------------------------------");
        System.out.print("Digite uma cor primária: ");

        String cor = inputColor.nextLine();
        String complementar = getCorComplementar(cor);

        System.out.println(complementar);
    }

    public static String getCorComplementar(String cor) {
        if (cor.equalsIgnoreCase("Vermelho")) {
            return "A cor complementar de \uD83D\uDD34" + cor + " é \uD83D\uDFE2Verde.";
        } else if (cor.equalsIgnoreCase("Laranja")) {
            return "A cor complementar de \uD83D\uDFE0" + cor + " é \uD83D\uDD35Azul.";
        } else if (cor.equalsIgnoreCase("Amarelo")) {
            return "A cor complementar de \uD83D\uDFE1" + cor + " é \uD83D\uDFE3Violeta.";
        } else if (cor.equalsIgnoreCase("Verde")) {
            return "A cor complementar de \uD83D\uDFE2" + cor + " é \uD83D\uDD34Vermelho.";
        } else if (cor.equalsIgnoreCase("Azul")) {
            return "A cor complementar de \uD83D\uDD35" + cor + " é \uD83D\uDFE0Laranja.";
        } else if (cor.equalsIgnoreCase("Violeta")) {
            return "A cor complementar de \uD83D\uDFE3" + cor + " é \uD83D\uDFE1Amarelo.";
        } else{
            return "Cor não reconhecida.";
        }
    }
}