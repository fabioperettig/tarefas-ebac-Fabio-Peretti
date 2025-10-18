import java.util.Arrays;
import java.util.Scanner;

/**
 * O switch utiliza múltiplos valores por caso, permitindo agrupar
 * diferentes níveis em uma única condição.
 *
 * @author fabioperettiguimaraes
 */
public class SwitchArray {

    static Integer[] levels = {1,2,3,4,5,6,7,8,9,10};
    static Scanner input = new Scanner(System.in);
    static int levelDigitado;

    public static void main(String[] args) {

        switchFOR();

        System.out.println("Digite seu level: ");
        levelDigitado = input.nextInt();
        switchScan();

    }

    /**
     * Demonstra o uso de um loop for combinado com a estrutura switch-case.
     * A classe percorre um array Integer e imprime uma mensagem correspondente
     * ao nível do usuário (iniciante, intermediário, avançado ou máximo).
     */
    public static void switchFOR(){
        for (int level : levels) {
            switch (level){
                case 1,2,3:
                    System.out.println("Nível iniciante: " + level);
                    break;
                case 4,5,6:
                    System.out.println("Nível intemerdiário: " + level);
                    break;
                case 7,8,9:
                    System.out.println("Nível avançado: " + level);
                    break;
                default:
                    System.out.println("Nível Máximo: " + level);
                    break;
            }
        }
    }

    /**
     * Switch com Array para variáveis específicas ou Scanner.
     */
    public static void switchScan(){
        if (Arrays.asList(levels).contains(levelDigitado)) {
            switch (levelDigitado){
                case 1,2,3:
                    System.out.println("Nível iniciante: " + levelDigitado);
                    break;
                case 4,5,6:
                    System.out.println("Nível intemerdiário: " + levelDigitado);
                    break;
                case 7,8,9:
                    System.out.println("Nível avançado: " + levelDigitado);
                    break;
                default:
                    System.out.println("Nível Máximo: " + levelDigitado);
                    break;
            }
        }
    }


}
