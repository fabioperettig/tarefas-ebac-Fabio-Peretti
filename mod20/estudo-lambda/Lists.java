import com.lambda.study.Msg;
import com.lambda.study.TypeStudy;

import java.util.Arrays;
import java.util.List;

public class Lists {

    public static void main(String[] args) {
        Msg div = () -> System.out.println("----------------------");
        List<Integer> numList = Arrays.asList(1,2,3,4,5,6);

        TypeStudy t2 = LIST -> System.out.printf("\n––– LAMBDA %s STUDY –––\n", LIST);

        /// Traditional average form
        int sum = 0;
        for (int n : numList) {
            sum += n;
        }

        double avg = (double) sum / numList.size();
        System.out.println("Traditional result: " + avg);

        /// Lambda average form
        /// It's necessary using [] to allow lambda modify
        final int[] lambdaSum = {0};
        numList.forEach(n -> lambdaSum[0] += n);
        double lambdaAvg = (double) lambdaSum[0]/ numList.size();
        System.out.println("Lambda result: " + lambdaAvg);

        div.print();

        /// Traditional even filter form
        for (int n : numList) {
            if (n%2 == 0) {
                System.out.println("Traditional even form: " + n);
            }
        }

        /// Lambda even filter form
        numList.forEach( n -> {
            if (n%2==0) {
                System.out.println("Lambda even form: " + n);
            }
        });

    }

}
