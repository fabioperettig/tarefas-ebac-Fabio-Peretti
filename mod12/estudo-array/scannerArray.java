import java.util.Scanner;
import java.util.Arrays;

public class scannerArray {

    static Scanner scanner = new Scanner(System.in);
    static String input;

    public static void main(String[] args) {

        System.out.println("Insira os números separados por vírgula:");
        input = scanner.nextLine();

        String[] stringArray = input.split(",");
        scannerToArray(stringArray);

        System.out.println(Arrays.toString(stringArray));

    }

    public static int[] scannerToArray(String[] arrayLocal){
        int[] numbers = new int[arrayLocal.length];

        for(int i =0; i < arrayLocal.length; i++){
            numbers[i] = Integer.parseInt(arrayLocal[i]);
        }
        return numbers;
    }

}
