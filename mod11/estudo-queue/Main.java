import java.util.Queue;
import java.util.LinkedList;

public class Main {

    static Queue<String> filaPacientes = new LinkedList<>();


    /**
     * Adicionando elementos à uma fila através do método offer(),
     * evidenciando o elemento atráves do método peek()
     * e removendo o elemento atra'ves do método poll().
     * <br><br>
     * Em uma Queue padrão, estes métodos sempre são aplicados ao
     * <u>primeiro elemento</u> da fila.
     * @param args main Class
     */
    public static void main(String[] args) {

        filaPacientes.offer("João");
        filaPacientes.offer("Maria");
        filaPacientes.offer("Carlos");
        filaPacientes.offer("Joaquim");
        filaPacientes.offer("Marcia");
        filaPacientes.offer("Wilson");

        //funciona tanto com println quanto printf
        System.out.printf("%nFila incial: %s%n",filaPacientes);

        System.out.println("-----------------------------------------------------------");

        System.out.printf("Atendendo o paciente: %s.%n",filaPacientes.peek());

        filaPacientes.poll();

        System.out.printf("%nFila atualizada: %s%n",filaPacientes);

        metodoAlternativo();



    }

    /**
     * Além de remover, o método poll() também consegue mostrar
     * o elemento antes de removê-lo da fila.
     */
    public static void metodoAlternativo(){
        System.out.printf("%nFila incial: %s%n",filaPacientes);
        System.out.println("-----------------------------------------------------------");
        System.out.printf("Atendendo o paciente: %s.%n",filaPacientes.poll());
        System.out.printf("%nFila incial: %s%n",filaPacientes);
    }

}
