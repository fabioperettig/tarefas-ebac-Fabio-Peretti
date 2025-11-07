import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Esta Classe armazena e manipula a lista de objetos instanciados
 * da Classe <u>exercClass</u>. Permitindo imprimir no console
 * tanto o parâmetro <b>String nome</b> quanto o parâmetro
 * <b>Character sexo</b>, de duas formas diferentes:
 *<ul>
 *     <li>Ordem de instância;</li>
 *     <li>Ordem alfabética.</li>
 *</ul>
 * @author Fabio Peretti Guimarães
 * @since Novembro 2025
 */
public class exercParte02 {

    private static List<String> listaParte02 = new ArrayList<>();

    /**
     * Método Getter que busca a lista privada <u>listaParte02</u>
     * e a disponibiliza na Classe Main.
     * @return lista dos nomes e sexo.
     */
    public static List<String> getListaParte02() {
        return listaParte02;
    }

    /**
     * Método automático de adição a lista, tornando dispensável
     * o uso de .add() manual, objeto por objeto.Com fomratação
     * de saída unindo ambos os parâmetros.<br><br>
     *
     * Este método precisa ser adicionado ao Construtor da Classe
     * exercClass para que possa funcionar corretamente.
     *
     * @param objetos instanciados da CLasse exercClass,
     * separando apenas o nome dos Objetos.
     */
    public static void addAutomatico02(exercClass objetos) {
        listaParte02.add(objetos.getNome() + " – " + objetos.getSexo());
    }

    /**
     * Cria uma cópia da <b><u>ArrayList<>(ListaParte02)</u></b>,
     * aplica o método .sort() para ordenar os objetos da lista,
     * imprimindo-os em ordem alfabética.
     *
     */
    public static void OrdemObjetos02() {
        List<String> ordenada = new ArrayList<>(listaParte02);
        Collections.sort(ordenada);
        System.out.println(ordenada);
    }

}