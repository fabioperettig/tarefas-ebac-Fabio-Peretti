import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<>();

        numeros.add(0);
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        //numeros.add(3,5);

        System.out.println("\nEsta lista contém " + numeros
        + " cuja terceira posição é o número " + numeros.get(3));

        System.out.println("\nSe não quisermos contar a posição zero" +
                "da lista " + numeros + " a terceira posição seria o número " + numeros.get(3-1));


        listaIndex();
    }


    /**
     * Demonstra a manipulação de índices em uma {@link java.util.List} através do método
     * {@link java.util.List#add(int, Object)}.
     *
     * <p>O método {@code add(int, Object)} aceita dois argumentos:
     * o primeiro define a posição (índice) onde o elemento será inserido,
     * e o segundo é o valor que será adicionado à lista.</p>
     *
     * <p>Neste exemplo, a lista {@code nIndex} é preenchida em ordem inversa,
     * mostrando que é possível controlar manualmente a posição dos elementos.</p>
     *
     * @see java.util.List#add(Object)
     */
    public static void listaIndex() {

        List<Integer> nIndex = new ArrayList<>();

        nIndex.add(0,5);
        nIndex.add(1,4);
        nIndex.add(2,3);
        nIndex.add(3,2);
        nIndex.add(4,1);
        nIndex.add(5,0);

        System.out.println("\n"+nIndex);

        System.out.println("\nO número " + nIndex.indexOf(3)+ " é o item de lugar 3 na Lista.");

    }

}
