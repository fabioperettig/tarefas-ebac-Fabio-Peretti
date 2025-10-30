import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Deque significa Double Ended Queue, ou seja, Fila de Duas Pontas.
 * Além d epossuir os métodos offer() e poll(), também é possível
 * determinar <u>por qual lado da fila</u> o elemento entrará:
 *
 * <ul>
 *     <li>offerFirst() -> Add o elemento ao início da fila.</li>
 *     <li>offerLast() -> Add o elemento ao final da fila.</li>
 *     <li>offerFirst() -> Remove o primeiro elemento.</li>
 *     <li>offerLast() -> Remove o último elemento.</li>
 * </ul>
 *
 * Obs: o metodo [...]Last() acaba sendo realmente útil quando
 * que quer remover um elemento da fila, pois a adição segue a ordem
 * de instância.
 *
 * @author fabioperettiguimaraes 
 */
public class DequeStudy {

    static Deque<String> filaDupla = new ArrayDeque<>();

    public static void main(String[] args) {

        filaDupla.offer("Fabio");
        filaDupla.offer("Carlos");
        filaDupla.offerLast("Maria"); //Neste momento ela já está no final;
        filaDupla.offer("Joaquim");
        filaDupla.offerFirst("José");

        System.out.println("Fila atual: " + filaDupla);
        System.out.println("------------------------");
        System.out.println("Removendo primeiro: " + filaDupla.pollFirst());
        System.out.println("Fila atual: " + filaDupla);
        System.out.println("------------------------");
        System.out.println("Removendo último: " + filaDupla.pollLast());
        System.out.println("Fila atual: " + filaDupla);

    }

}
