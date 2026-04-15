import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args){
		System.out.println("Hello World");

        List<String> list = List.of("Zeke", "Julie", "Zombie", "Werewolf");

        list.forEach((String lprint) -> {
                System.out.printf("\nName on List: %s", lprint);
            }
        );
	}
}
