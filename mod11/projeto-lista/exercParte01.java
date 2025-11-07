import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Esta Classe armazena e manipula a lista de objetos instanciados
 * da Classe <u>exercClass</u>. Permitindo imprimir no console
 * apenas o parâmetro <b>String nome</b> de duas formas diferentes:
 *<ul>
 *     <li>Ordem de instância;</li>
 *     <li>Ordem alfabética.</li>
 *</ul>
 * @author Fabio Peretti Guimarães
 * @since Novembro 2025
 */
public class exercParte01 {

    private static List<String> listaParte01 = new ArrayList<>();

    /**
     * Método Getter que busca a lista privada <u>listaParte01</u>
     * e a disponibiliza na Classe Main.
     * @return lista dos nomes.
     */
    public static List<String> getListaParte01() {
        return listaParte01;
    }

    /**
     * Método automático de adição a lista, tornando dispensável
     * o uso de .add() manual, objeto por objeto.<br><br>
     *
     * Este método precisa ser adicionado ao Construtor da Classe
     * exercClass para que possa funcionar corretamente.
     *
     * @param objetos instanciados da CLasse exercClass,
     * separando apenas o nome dos Objetos.
     */
    public static void addAutomatico01(exercClass objetos) {
        listaParte01.add(objetos.getNome());
    }

    /**
     * Cria uma cópia da <b><u>ArrayList<>(ListaParte01)</u></b>,
     * aplica o método .sort() para ordenar os objetos da lista,
     * imprimindo-os em ordem alfabética.
     *
     */
    public static void OrdemObjetos01() {
        List<String> ordenada = new ArrayList<>(listaParte01);
        Collections.sort(ordenada);
        System.out.println(ordenada);
    }

}
