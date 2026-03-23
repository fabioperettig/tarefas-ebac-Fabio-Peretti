import java.util.List;

/**
 * A generic utility method to print elements of a list.
 * Using the <T> type parameter allows this method to handle lists of any
 * reference type while maintaining compile-time type safety.
 *
 */
public class GenericPrint {

    public static <T> void printList(List<T> list){
        for (T item : list) {
            System.out.println(item);
        }
    }

}
