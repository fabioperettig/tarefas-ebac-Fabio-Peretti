import java.util.Scanner;
import java.text.Normalizer;


/**
 * Programa de estudo sobre o uso do loop 'for' com Strings em Java.
 * <p>
 * Este programa permite ao usuário digitar uma palavra ou frase e realiza as seguintes operações:
 * <ul>
 *   <li>Exibe cada caractere e sua posição na string.</li>
 *   <li>Conta o número total de caracteres.</li>
 *   <li>Remove acentos e conta o número de vogais e consoantes, ignorando espaços e pontuação.</li>
 *   <li>Mostra a string invertida.</li>
 * </ul>
 * O código também demonstra o uso das classes {@link java.text.Normalizer} e {@link java.lang.Character}.
 * </p>
 *
 * @author Fabio Peretti
 * @version 1.0
 */
public class ExemploForString {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Insira uma palavra ou frase:");
        String stringTest=input.nextLine();

        // Retirar a acentuação para a contagem correta de caracteres
        String stringNormalizada = Normalizer.normalize(stringTest,Normalizer.Form.NFD);
        //troca acento por nada
        stringNormalizada = stringNormalizada.replaceAll("[^\\p{ASCII}]", "");

        // Separa String por letras
        for (int i=0; i < stringTest.length(); i++){
            char letra = stringTest.charAt(i);
            System.out.println("Letra na posição " + i + ": " + letra);
        }

        // Exibe a quantidade de caracteres há em stringtest
        System.out.println("\nQuantidade de caracteres: " + stringTest.length());

        //Exibir quantidade de vogais e consoantes

        int contadorVogal = 0;
        int contadorConsoante = 0;

        for (int i = 0; i < stringNormalizada.length(); i++) {
            char c = Character.toLowerCase(stringNormalizada.charAt(i));
            if (Character.isLetter(c)) {
                if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
                    contadorVogal++;
                } else {
                    contadorConsoante++;
                }
            }
        }

        System.out.println("A quantidade de vogais em '" + stringTest + " é: " + contadorVogal);
        System.out.println("A quantidade de consoantes em '" + stringTest + " é: " + contadorConsoante);

        //Mostrar palavra invertida
        String invertida = "";

        for (int i = stringTest.length() - 1; i >=0; i--) {
            invertida += stringTest.charAt(i);
        }

        System.out.println("A palavra '" + stringTest + "' invertida fica '" + invertida + "'.");
    }
}
