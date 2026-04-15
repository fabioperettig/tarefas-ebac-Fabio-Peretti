import com.lambda.study.Msg;

import java.util.Arrays;
import java.util.List;

import com.lambda.study.*;

public class StringOp {

    public static void main(String[] args) {
        Msg div = () -> System.out.println("----------------------");
        List<String> namesList = Arrays.asList("Zeke","Julie","Zombie", "Werewolf");

        TypeStudy t3 = STRING -> System.out.printf("\n––– LAMBDA %s STUDY –––\n", STRING);

        /// Traditional filter form
        for ( String n : namesList){
            if (n.toLowerCase().contains("z")){
                String upper = n.toUpperCase();
                System.out.println("Traditional filter form: " + upper);
            }
        }

        /// Lambda filter form
        namesList.forEach( n -> {
            if (n.toLowerCase().contains("e")) {
                String upper = n.toUpperCase();
                System.out.println("Lambda filter form: " + upper);
            }
        });

    }
}
