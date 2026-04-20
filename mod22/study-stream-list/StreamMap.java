import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMap {

    public static void main(String[] args) {

        List<User> list = new User().userList();

        /// Mapping a Stream and converting/returning to Integer
        Stream<Integer> streamMap = list.stream()
                .filter(user -> user.getNationality().equals("USA")) // filter applied
                .map(User::getAge);

        /// An Interface which auto convert a list to return Integer
        IntStream streamListConverted = list.stream()
                .mapToInt(User::getAge);

        /// Printing a Stream -> forReach n Reference Method
        streamListConverted.forEach(System.out::println);
    }

}
