
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*ClassCastExceptionError*/
        //List list = new ArrayList<>();
        //list.add("Arnold");
        //list.add(123);
        //CastErrorExample.printList(list);


        /*Correct implement*/
        List<String> stringList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();

        stringList.add("Zeke");
        stringList.add("Julie");

        intList.add(10);
        intList.add(25);

        //it works, but print only one type of list at a time
        GenericPrint.printList(intList);

        //print how many Lists as possible through a Stream Method
        StreamGenericPrint.printStream(stringList,intList);

    }

}