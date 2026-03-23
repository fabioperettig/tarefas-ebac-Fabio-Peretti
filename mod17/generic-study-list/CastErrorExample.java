import java.util.ArrayList;
import java.util.List;

/**
 * This is an example of "DON'T" when you're working with Lists without type.
 * The print method bellow compile the {@Code List list = new ArrayList<>()}
 * and return ClassCastException error when executed.
 */
public class CastErrorExample {

    //List list = new ArrayList<>();

    public static void printList(List<String> list){
        for (String string : list){
            System.out.println(string);
        }
    }

}
