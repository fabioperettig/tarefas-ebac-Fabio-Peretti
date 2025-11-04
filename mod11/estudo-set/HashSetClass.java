import java.util.Set;
import java.util.HashSet;

public class HashSetClass {

    /**
     * Um Hash é um estilo de "Lista" que não imprime elementos
     * repetidos, independentemente da forma pela qual o elemento
     * é adicionado.
     *
     * <ul>
     *     <li> .add repetido</li>
     *     <li> elemento igual em variável externa</li>
     * </ul>
     *
     */
    public static void ExemploHS(){

        String mus = "Out of Touch";

        Set<String> playlist = new HashSet<>();
        playlist.add("Never Gonna Give You Up");
        playlist.add("Take on Me");
        playlist.add("Everybody Wants to Rule the World");
        playlist.add("Out of Touch");
        playlist.add("Dance all Days");
        playlist.add("Out of Touch");
        playlist.add("Owner of a Lonely Heart");
        playlist.add(mus);
        System.out.println(playlist);

        for (String song : playlist){
            System.out.println("– "+song);
        }
    }

}
