import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamSort {

    public static void main(String[] args) {

        List<Monsters> monstersList = new Monsters().monstersList();

        /// Order list through the NAME param
        Stream sortStream = monstersList.stream()
                .sorted(Comparator.comparing(Monsters::getName))
                .map(Monsters::getName);

        sortStream.forEach(System.out::println);

        /// Comparing list through the ATK param
        String compareStream = monstersList.stream()
                .max(Comparator.comparing(Monsters::getAtk))
                .map(m -> m.getName() + " is the strongest!")
                .orElse("Draw");

        System.out.println(compareStream);


        /// Comparing specifics through the ATK param
        String compareSpecificStream = monstersList.stream()
                .filter(m -> m.getName().equals("Werewolf") || m.getName().equals("Mummy"))
                .max(Comparator.comparing(Monsters::getAtk))
                .map(m -> m.getName() + " wins!")
                .orElse("Draw");

        System.out.println(compareSpecificStream);
    }
}
