import java.sql.Wrapper;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("\nSeja bem vindo ao conversor de valores.");
        System.out.println("-----------------");

        while (true){

            System.out.println("Digite o tipo de valor: int | short | long | double");
            String tipo = input.nextLine();
            Number wrapperValue = null;

            switch (tipo.toLowerCase()) {
                case "int":
                    System.out.println("\nDigite um valor inteiro: ");
                    int primInt = input.nextInt();
                    wrapperValue = Integer.valueOf(primInt);
                    System.out.println("Wrapper Integer criado: " + wrapperValue);
                    input.nextLine(); // limpa o buffer
                    break;

                case "short":
                    System.out.println("\nDigite um valor pequeno: ");
                    short primShort = input.nextShort();
                    wrapperValue = Short.valueOf(primShort);
                    System.out.println("Wrapper Short criado: " + wrapperValue);
                    input.nextLine(); // limpa o buffer
                    break;

                case "long":
                    System.out.println("\nDigite um valor longo: ");
                    long primLong = input.nextLong();
                    wrapperValue = Long.valueOf(primLong);
                    System.out.println("Valor Long criado: " + wrapperValue);
                    input.nextLine(); // limpa o buffer
                    break;

                case "double":
                    System.out.println("\nDigite um valor decimal: ");
                    double primDouble = input.nextDouble();
                    wrapperValue = Double.valueOf(primDouble);
                    System.out.println("Wrapper Double criado: " + wrapperValue);
                    input.nextLine(); // limpa o buffer
                    break;

                default:
                    System.out.println("Opção inválida, escolha uma das opções disnponíveis.");
                    continue;
            }

            System.out.println("Deseja converter seu Wrapper para outro tipo? (s/n)");
            String opcao = input.nextLine();

            if (opcao.equalsIgnoreCase("s")) {
                System.out.println("\nConverter para: Integer | Short | Long | Double");
                String novoTipo = input.nextLine();

                switch (novoTipo.toLowerCase()) {

                    case "integer":
                        Integer novoInteger = wrapperValue.intValue();
                        System.out.println("Convertido para Integer: " + novoInteger);
                        break;

                    case "short":
                        Short novoShort = wrapperValue.shortValue();
                        System.out.println("Convertido para Short: " + novoShort);
                        break;

                    case "long":
                        Long novoLong = wrapperValue.longValue();
                        System.out.println("Convertido para Long: " + novoLong);
                        break;

                    case "double":
                        Double novoDouble = wrapperValue.doubleValue();
                        System.out.println("Convertido para Double: " + novoDouble);
                        break;

                    default:
                        System.out.println("Conversão inválida.");
                }

                System.out.println("\nDeseja realizar outra conversão? (s/n): ");
                String outra = input.nextLine();

                if (outra.equalsIgnoreCase("n")) {
                    System.out.println("Encerrando o programa...");
                    break; // Sai do while
                }

            } else {
                System.out.println("\nDeseja realizar outra conversão? (s/n): ");
                String outra = input.nextLine();

                if (outra.equalsIgnoreCase("n")) {
                    System.out.println("Encerrando o programa...");
                    break; // Sai do while
                }
            }
        }
    }
}