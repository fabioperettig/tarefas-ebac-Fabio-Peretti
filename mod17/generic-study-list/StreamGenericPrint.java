import java.util.Arrays;
import java.util.List;

/**
 * Processes multiple lists of any type using a Stream-based approach.
 * This method demonstrates the use of Varargs combined with flatMap
 * to handle an arbitrary number of collections in a single pipeline.
 */
public class StreamGenericPrint {

    public static void printStream(List<?>... lists) {
        Arrays.stream(lists).flatMap(List::stream).forEach(System.out::println);
    }

}
