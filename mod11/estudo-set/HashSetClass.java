import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;


public class HashSetClass {

    private static Set<String> playlist = new HashSet<>();

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


        playlist.add("Never Gonna Give You Up");
        playlist.add("Take on Me");
        playlist.add("Everybody Wants to Rule the World");
        playlist.add("Out of Touch");
        playlist.add("Dance all Days");
        playlist.add("Out of Touch");
        playlist.add("Owner of a Lonely Heart");
        playlist.add(mus);


    }


    //Métodos para adicionar via Scanner em outra Classe
    public static void addSong(String song) {
        playlist.add(song);
    }

    public static boolean checkSong(String song){
        return playlist.contains(song);
    };

    public static Set<String> getPlaylist(){
        return playlist;
    }

    public static void showPlaylist(){
        for (String song : HashSetClass.getPlaylist()){
            System.out.println("– "+song);
        }
    }

}