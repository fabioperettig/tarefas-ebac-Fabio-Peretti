import java.util.Scanner;


/**
 * @author Fabio Peretti Guimarães
 */
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("\n  Indicador de idade");
        System.out.println("------------------------");
        System.out.println("  Digite sua idade: ");

        int idade = input.nextInt();
        String result = getIdade(idade);
        System.out.println(result);
    }

    public static String getIdade(int idade) {
        if (idade >= 0 && idade <= 5) {
            return "Você é um bebê.";
        } else if (idade >= 6 && idade <= 10) {
            return "Você é uma criança.";
        } else if (idade >= 11 && idade <= 18) {
            return "Você é uma criança.";
        } else if (idade >= 19 && idade <= 25) {
            return "Você é um jovem adulto.";
        } else {
            return "Você é um adulto.";
        }
    }

}
