public class Main {

    public static void main(String[] args) {

        Printable dog = () -> System.out.println("Au au");
        printThing(dog);

    }

    static void printThing(Printable thing){
        thing.print();
    }
}
