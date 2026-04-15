import com.lambda.study.Msg;
import com.lambda.study.TypeStudy;

import java.util.function.BiFunction;

public class Math {

    public static void main(String[] args) {
        Msg div = () -> System.out.println("----------------------");

        TypeStudy t1 = MATH -> System.out.printf("\n––– LAMBDA %s STUDY –––\n", MATH);

        System.out.println("Traditional result: " + add(1,1));

        /// lambda arithmetic form
        BiFunction<Integer, Integer, Integer> add = (a,b) -> a + b;
        int result = add.apply(2,3);
        System.out.println("Lambda result: " + result);

        div.print();

        System.out.println("Traditional calculate: " + calculate(10,2,"div"));
        System.out.println("Lambda calculate: " + lambCalculate(4,4,(x,y) -> x+y));

        div.print();


    }

    /// traditional arithmetic method
    public static Integer add(int a, int b){
      return a+b;
    };

    /// traditional calculate method
    public static int calculate(int a, int b, String operation){
        return switch (operation) {
            case "add" -> a + b;
            case "sub" -> a - b;
            case "mul" -> a * b;
            case "div" -> a / b;
            default -> 0;
        };
    }

    /// lambda calculate method
    public static int lambCalculate(int a, int b, BiFunction<Integer, Integer, Integer> operation) {
        return operation.apply(a, b);
    }

}
