import java.util.Scanner;

public class ExemploWhileString {

    static int number;
    static int metodoEscolhido;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Bem vindo ao simulador de tabuada.");
        System.out.println("\nGostaria de iniciar?");
        String resposta = input.next();


        while(resposta.equalsIgnoreCase("sim")){
            System.out.println("Digite um número para calcular: ");
            number = input.nextInt();

            System.out.println("\nEscolha um dos métodos:");
            System.out.println("1 – whilePuro()");
            System.out.println("2 – etapaFOR()\n");
            metodoEscolhido = input.nextInt();

            if (metodoEscolhido == 1) {
                whilePuro(number);
            } else {
                etapaFOR(number);
            }

            System.out.println("Gostaria de escolher um outro número para calcular?");
            resposta = input.next();
        }

        System.out.println("Encerrando aplicação.");

    }

    /**
     * <p>Estudo da possibilidade da quebra de etapas em diferentes whiles.</p>
     * <p>O exemplo mostra uma substituição do método etapaFOR por um método while,
     * criando uma variável local que influencia a variável de parâmetro.</p>
     * @param number variável static criada fora da Main.
     */
    public static void whilePuro(int number){
        int local = 0;
        System.out.println("\nCálculo executado via WHILE\n");
        while (local < 10){
            local ++;
            System.out.println(number + "*" + local + "=" + number*local);
        }
    }

    public static void etapaFOR(int number){
        System.out.println("\nCálculo executado via FOR\n");
        for(int local=0; local<=10; local++){
            System.out.println(number + "*" + local + "=" + number*local);
        }
    }

}
