import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;


/**
 * Adicionando elementos à uma fila através do método offer().
 * Uma lista prioritária serve para mostrar os elementos em ordem especificas:
 * <br>
 * <ul>
 *     <li>String – afbatética</li>
 *     <li> Integer – crescente </li>
 * </ul>
 * É importante lembrar que a prioridade se aplica sempre ao <u>primeiro elemento</u>
 * da fila, mas não signifca necessariamente que o restante da fila se manterá ordenado.
 *
 */
public class Priority {

    static PriorityQueue<Double> temperaturaPrioridade = new PriorityQueue<>();
    static PriorityQueue<String> pacientesPrioridade = new PriorityQueue<>();
    static PriorityBlockingQueue<Integer> numeroOrdenado = new PriorityBlockingQueue<>(10);

    public static void main(String[] args) {

        pacientesPrioridade.offer("João");
        pacientesPrioridade.offer("Maria");
        pacientesPrioridade.offer("Carlos");
        pacientesPrioridade.offer("Joaquim");
        pacientesPrioridade.offer("Marcia");
        pacientesPrioridade.offer("Wilson");

        System.out.printf("%nLista por prioridade: %s%n",pacientesPrioridade);

        temperaturaPrioridade.offer(30.5);
        temperaturaPrioridade.offer(10.5);
        temperaturaPrioridade.offer(45.7);
        temperaturaPrioridade.offer(07.5);
        temperaturaPrioridade.offer(25.5);
        temperaturaPrioridade.offer(25.6);
        temperaturaPrioridade.offer(25.7);

        System.out.printf("%nMinimo para o Máximo: %s%n",temperaturaPrioridade);

        prioridadeOrdenada();

        prioridadeBlocking();

    }

    /**
     * Para garantir que a fila imprima a fila exatamente ordenada, é necessário
     * seguir alguns passos:
     *
     * <ul>
     *     <li>Adicionar a Queue a um método While;</li>
     *     <li>Usar como parâmetro a negação da lista vazia;</li>
     *     <li>Imprimir e retirar o el. prioritário através do .poll()</li>
     * </ul>
     * A repetição do método poll() forçará a Queue a sempre buscar
     * o elemento prioritário da fila antes de executar o processo,
     * garantindo que a fila sempre será impressa em ordem.
     *<br><br>
     * Como não há um método 'isFull()' em Queues, é necessário negar
     * o fato de que a lista está vazia e usá-la como parâmetro condicional:
     * <br><br>
     * !pacientesPrioridade.isEmpty() == 'pacientesPrioridade.isFull()'
     */
    public static void prioridadeOrdenada(){

        //possível continuar adicionando elementos a Queue por ser estática;
        pacientesPrioridade.offer("Kelly");
        pacientesPrioridade.offer("Zohan");
        pacientesPrioridade.offer("Jiba");

        while (!pacientesPrioridade.isEmpty()) {
            System.out.println("Fila atual: "+pacientesPrioridade);
            System.out.println("Removendo: "+pacientesPrioridade.poll());
        }

        System.out.println("-----------------");

        while (!temperaturaPrioridade.isEmpty()){
            System.out.println(temperaturaPrioridade.poll());
        }

    }

    /**
     * Há também a possibilidade de uso prioritário em BlockingQueues,
     * onde os mesmos raciocínios de prioridade se aplicam.
     */
    public static void prioridadeBlocking(){

        numeroOrdenado.offer(3);
        numeroOrdenado.offer(24);
        numeroOrdenado.offer(1);
        numeroOrdenado.offer(17);
        numeroOrdenado.offer(16);
        numeroOrdenado.offer(6);
        numeroOrdenado.offer(4);
        numeroOrdenado.offer(5);
        numeroOrdenado.offer(12);
        numeroOrdenado.offer(9);

        System.out.println(numeroOrdenado);

        while(!numeroOrdenado.isEmpty()){
            System.out.println(numeroOrdenado.poll());
        }


    }
}
