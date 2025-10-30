import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueVsStack {

    static Queue<String> queueFila = new LinkedList<>();
    static Deque<String> stackPilha = new ArrayDeque<>();

    public static void main(String[] args) {

        System.out.println("\nDiferença entre Queue e Stack");
        System.out.println("------------------------------");

        mecanicaFila();
        System.out.println("\n------------------------------");
        mecanicaPilha();

    }

    /**
     * Uma Queue é equivalente à uma fila de mercado, onde
     * só existe a opção de entrar pelo fim e sair pelo começo.
     * <br><br>
     * <p><b>(entrada) Fim > | > | > | > Começo (saída)</b></p>
     * <br>
     * <p><b>FIFO (First in First out)</b></p>
     */
    static public void mecanicaFila(){
        queueFila.offer("Primeiro");
        queueFila.offer("Segundo");
        queueFila.offer("Terceiro");
        queueFila.offer("Quarto");

        System.out.println("\nMecânica de fila – Queue");
        System.out.println("Fila atual: " + queueFila);

        System.out.println("- - - - -");

        System.out.println("Removendo o primeiro da fila: " + queueFila.poll());
        System.out.println("Fila atual: " + queueFila);
    }

    /**
     * Já uma Stack (Dequeue) é equivalente à uma pilha de pratos,
     * onde só ambas as ações de entrar e sair <u>só podem ser feitas
     * pelo fim.</u>
     * <br><br>
     * <p><b>(entrada e saída) Fim > | > | > | > Começo</b></p>
     * <br>
     * <p><b>LIFO (Last in First out)</b></p>
     */
    static public void mecanicaPilha(){
        stackPilha.push("Primeiro");
        stackPilha.push("Segundo");
        stackPilha.push("Terceiro");
        stackPilha.push("Quarto");

        System.out.println("\nMecânica de pilha – Stack(Deque)");
        System.out.println("Pilha atual: " + stackPilha);

        System.out.println("- - - - -");

        System.out.println("Removendo o primeiro da pilha: " + stackPilha.pop());
        System.out.println("Pilha atual: " + stackPilha);
    }

}
