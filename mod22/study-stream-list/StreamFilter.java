import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamFilter {

    public static void main(String[] args) {

        /// It's necessary a empty ctor
        List<User> list = new User().userList();
        Stream<User> streamDefaultMethod = list.stream()
                .filter(user -> user.getNationality().equals("USA"));


        /// Stream with a Predicate Variable (less common)
        Predicate<User> PredicateVar = user -> user.getNationality().equals("USA");
        Stream<User> StreamPredicateMethod = list.stream()
                .filter(PredicateVar);


        /// Stream with anonymous Class (even less common)
        Predicate<User> InstancePredicate = new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.getNationality().equals("USA");
            }
        };

        Stream<User> InstancePredicateMethod = list.stream().filter(InstancePredicate);

        /// Printing a Stream -> forReach n Reference Method
        streamDefaultMethod.forEach(System.out::println);

    }

}
