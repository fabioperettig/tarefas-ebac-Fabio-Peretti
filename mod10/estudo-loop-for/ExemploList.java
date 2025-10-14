import java.util.ArrayList;
import java.util.List;

public class ExemploList {

    public static void main(String[] args) {

        List<Integer> numeroX = new ArrayList<>();

        System.out.println("Exemplos de For com Listas");

        //Verifica adiciona valor à lista 'numeroX'
        for (int x=0; x<=5; x++){
            System.out.println("Linha X: " + x);
            numeroX.add(x);
        }

        System.out.println("-------------------------");

        /**
         * Exemplo usando o laço for-each tradicional.
         * <p>
         * Alternativa moderna: {@code numeroX.forEach( z -> System.out.println("Linha Z: " + z*3))}
         */
        for (Integer y : numeroX) {
            System.out.println("Linha Y: " + y*2);
        }

        System.out.println("-------------------------");

        numeroX.forEach( z -> System.out.println("Linha Z: " + z*3));

    }
}
