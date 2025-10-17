import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static int level = 0;

    public static void main(String[] args) {

        System.out.println("Insira lvl: ");
        level = input.nextInt();

        switch(level){
            case 1:
                System.out.println("Level é Armor Bronze " + level);
                break;
            case 2:
                System.out.println("Level é Armor Prata " + level);
                break;
            case 3:
                System.out.println("Level é Armor Gold " + level);
                break;
            default:
                System.out.println("Level desconhecido.");
                break;
        }


    }
}
