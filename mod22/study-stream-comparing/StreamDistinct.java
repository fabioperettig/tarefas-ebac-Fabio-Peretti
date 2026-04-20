import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamDistinct {

    public static void main(String[] args) {

        List<Monsters> monstersList = new Monsters().monstersList();

        /// Used to avoid repeated elements on Stream (it works only with 'hashCode')
        Stream distinctMethod = monstersList.stream()
                .map(monsters -> monsters.getName())
                .distinct();

        distinctMethod.forEach(System.out::println);

        /// Bonus: limiting elements on Stream
        Stream limitMethod = monstersList.stream()
                .sorted(Comparator.comparing(Monsters::getAtk).reversed())
                .limit(4);

        //limitMethod.forEach(System.out::println);


        /// Bonus: selecting specifics intervals on Stream
        Stream skipMethod = monstersList.stream()
                //.sorted(Comparator.comparing(Monsters::getDef))
                .skip(4);

        skipMethod.forEach(System.out::println);

    }

}
