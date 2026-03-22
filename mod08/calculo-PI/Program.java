import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CalculosPI calculo = new CalculosPI();

        while (true) {
            System.out.printf("### CÁLCULO CÍRCULO ###%n%nO que deseja Calcular?%n");
            System.out.println("A) Circuferência a partir do Raio");
            System.out.println("B) Raio a partir do Circuferência");
            System.out.println("X) Encerrar sistema");

            String opcao = scanner.nextLine().toUpperCase();

            if (opcao.equals("A")){
                calculo.calculoCirc();
                System.out.printf("Raio: %.2f%n", calculo.Raio);
                System.out.printf("Diâmetro: %.2f%n", calculo.Diametro);
                System.out.printf("Circunferência: %.2f%n", calculo.Circun);
            } else if (opcao.equals("B")){
                calculo.calculoRaio();
                System.out.printf("Circunferência: %.2f%n", calculo.Circun);
                System.out.printf("Raio: %.2f%n", calculo.Raio);
                System.out.printf("Diâmetro: %.2f%n", calculo.Diametro);
            } else if (opcao.equals("X")){
                System.out.println("Encerrando o programa.");
                break;
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }


    }
}