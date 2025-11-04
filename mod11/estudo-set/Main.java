import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static String addSong;


    public static void main(String[] args) {

        HashSetClass.ExemploHS();
        HashSetClass.showPlaylist();

        addNewSong();

        HashSetClass.showPlaylist();
    }


    public static void addNewSong(){
        System.out.println("Insira uma nova música:");
        addSong = input.nextLine();

        if (HashSetClass.checkSong(addSong)){
            System.out.println("Esta música já foi adicionada à playlist.");
        } else {
            HashSetClass.getPlaylist().add(addSong);
        }
    }
}
