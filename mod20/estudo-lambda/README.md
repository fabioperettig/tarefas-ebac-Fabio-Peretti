![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Lambda](https://img.shields.io/badge/Lambda--Expressions-gold?style=for-the-badge)
![Interface](https://img.shields.io/badge/Functional--Interface-green?style=for-the-badge)

# ☕ Java Lambda and Functional Interfaces Study

This project is a personal study focused on understanding Lambda Expressions in Java from the ground up — starting with basic syntax and gradually comparing them with traditional approaches.

The goal is to build intuition first by exploring how lambdas replace anonymous classes and simplify logic.


## 📚 What is covered

This project explores lambdas through simple and practical examples:

### 🔢 Arithmetic Operations
-	Traditional methods vs Lambda expressions
- Using BiFunction to represent operations
- Dynamic calculation using lambdas as parameters

````java
import com.lambda.study.TypeStudy;
import java.util.function.BiFunction;

public class Math {

    public static void main(String[] args) {

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
````
### 🧾 Lists (Integers)
- Calculating average (traditional vs lambda)
- Filtering even numbers
- Understanding how lambdas interact with mutable variables

````java
import java.util.Arrays;
import java.util.List;

public class Lists {

    public static void main(String[] args) {
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
````
## 🧩 Custom Functional Interfaces

Custom interfaces were created to better understand how lambdas work internally:
- Msg → simple action with no parameters
- TypeStudy → parameterized lambda for dynamic output

````java
package com.lambda.study;

@FunctionalInterface
public interface TypeStudy {
    void typePrint(String type);
}
````
````java
TypeStudy t = TYPE -> System.out.printf("\n––– LAMBDA %s STUDY –––\n", TYPE);
````
## 🚀 Next Steps (Future Ideas)
- Introduce Streams API
- Use Predicate and Function
- Build a small interactive system using lambdas
- Explore method references (::)