import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.Scanner;

/**
 * A classe ArrayBlockingQueue (pacote java.util.concurrent)
 * permite criar uma fila com tamanho máximo definido no construtor.
 */
public class BlockingQueue {

    static ArrayBlockingQueue<String> primeirosClientes = new ArrayBlockingQueue<>(5);
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        primeirosClientes.offer("João");
        primeirosClientes.offer("Maria");
        primeirosClientes.offer("Carlos");
        primeirosClientes.offer("Joaquim");
        primeirosClientes.offer("Marcia");

        System.out.printf("%nFila cheia: %s.%n",primeirosClientes);
        System.out.println("----------------------------------");

        adicionarMembroADMIN();



    }


    public static void adicionarMembro(){
        System.out.println("\nInsira o nome do novo membro: ");
        String newMembro = input.nextLine();

        if (primeirosClientes.remainingCapacity()==0){
            System.out.println("A fila já está cheia.");
        } else {
            primeirosClientes.offer(newMembro);
        }
    }

    public static void adicionarMembroADMIN(){
        System.out.println("\nInsira o nome do novo membro: ");
        String newMembro = input.nextLine();

        if (primeirosClientes.remainingCapacity()==0){
            System.out.println("A fila já está cheia. Gostaria de remover um elemento da fila?");
            System.out.println("1-Sim | 2-Não");
            int escolha = input.nextInt();
            input.nextLine();

            if (escolha == 1) {
                primeirosClientes.poll();
                primeirosClientes.offer(newMembro);
                System.out.println("Lista atualizada: " + primeirosClientes);
            } else {
                System.out.println("Ação cancelada.");
                System.out.println(primeirosClientes);
            }

        } else {
            primeirosClientes.offer(newMembro);
        }
    }

}
