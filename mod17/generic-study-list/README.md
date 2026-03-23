# 🚀 The Evolution of Type Safety: Java Generics

This module is a deep dive into how Java handles collections and type safety. It documents the transition from unsafe "Raw Lists" to higly flexible generic methods.

#### (Spoiler: with a powerful bonus solution at the end)

## 1・"Raw List" Trap
Initially, we explore Lists without types. You can add anything to them (Strings, Integers, etc.). But then, a ***ClassCastException*** appears at runtime when the code tries to treat an Integer as a String.

````Java
public class CastErrorExample {

    //List list = new ArrayList<>();

    public static void printList(List<String> list){
        for (String string : list){
            System.out.println(string);
        }
    }
}

- - - - - -

public class Main {

    public static void main(String[] args) {

        /*ClassCastExceptionError*/
        List list = new ArrayList<>();
        list.add("Arnold");
        list.add(123);
        CastErrorExample.printList(list);
    }
}
````
````diff
-Exception in thread "main" java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String (java.lang.Integer and java.lang.String are in module java.base of loader 'bootstrap')
````
<br>

## 2・Specific Generics (the "Quick Fix")
To solve the crash, we introduce specific tags to these Lists, and compiler prevents you from adding the wrong type.

***The New Problem:*** code duplication. If you have 5 different types, you need 5 different methods, making your code "dirty" and inefficient.
````Java
List<String> stringList = new ArrayList<>();
List<Integer> intList = new ArrayList<>();
List<Long> longList = new ArrayList<>();

stringList.add("Zeke");
stringList.add("Julie");

intList.add(10);
intList.add(25);

longList.add(1L);
longList.add(2L);
longList.add(3L);

/*A large and unnecessary number of different methods*/

StringPrint.printList(stringList);
IntegerPrint.printList(intList);
LongPrint.printList(longList);
````
## 3・Solution: Generic Methods with < T > (the "Reusable Way")
Instead of hardcoding the type, we use the ***Generic Type Parameter < T >***. Now, we have one single method powered to print any list, making a reusable and clean code. The method doesn't care what's inside the list; it just knows how to handle ***"a list of something"***.
````Java
public class GenericPrint {

    public static <T> void printList(List<T> list){
        for (T item : list) {
            System.out.println(item);
        }
    }
}

- - - - - -

public class Main {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        List<Long> longList = new ArrayList<>();

        stringList.add("Zeke");
        stringList.add("Julie");

        intList.add(10);
        intList.add(25);

        longList.add(1L);
        longList.add(2L);
        longList.add(3L);

        /*A single method printing any type of List*/

        GenericPrint.printList(stringList);
        GenericPrint.printList(intList);
        GenericPrint.printList(longList);
    }
}
````
---
<br>

## 🔥🔥🔥 BONUS - The Ultimate Solution: Streams + Varargs + Wildcards <?>
The final evolution takes it to a professional architectural level: use **Varargs (...) to accept multiple lists at once and Java Streams to process them**.

Using the Unbounded Wildcard (<?>), you can handle an arbitrary number of lists with different types in the same call. This approach is extremely concise and uses the power of functional programming in Java.

````Java
public class StreamGenericPrint {

    public static void printStream(List<?>... lists) {
        Arrays.stream(lists).
        flatMap(List::stream).
        forEach(System.out::println);
    }
}

- - - - - -

public class Main {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        List<Long> longList = new ArrayList<>();

        stringList.add("Zeke");
        stringList.add("Julie");

        intList.add(10);
        intList.add(25);

        longList.add(1L);
        longList.add(2L);
        longList.add(3L);

        /*A single method printing ALL TYPES OF LISTS AT THE SAME TIME*/
        StreamGenericPrint.printStream(stringList, intList, longList);
    }
}
````
<br>

This method prevents runtime errors at compile time, showing **how Java handles generics under the hood and a dynamic number of arguments**, using flatMap to consolidate multiple collections into one data flow.