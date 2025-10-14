import java.util.Scanner;

/**
 * Exemplo que mostra vantagens no uso do FOR, em comparação ao uso de IF/ELSE
 * @author fabioperettiguimaraes
 */
public class ExemploIFvsFOR {

    static Scanner numeroInput = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println("\nInsira um número para calcular: ");
        int numInt = numeroInput.nextInt();

        System.out.println("Aqui está a tabuada do número " + numInt + ":");

        tabuadacomIF(numInt);
        System.out.println("-------------------------");
        tabuadacomFOR(numInt);
    }

    /**
     * @deprecated perfeitamente subsituível pelo método tabuadacomFOR()
     */
    public static void tabuadacomIF(int numInt){

        if (numInt < 10) {
            System.out.println(numInt + "x1=" + numInt*1);
            System.out.println(numInt + "x2=" + numInt*2);
            System.out.println(numInt + "x3=" + numInt*3);
            System.out.println(numInt + "x4=" + numInt*4);
            System.out.println(numInt + "x5=" + numInt*5);
            System.out.println(numInt + "x6=" + numInt*6);
            System.out.println(numInt + "x7=" + numInt*7);
            System.out.println(numInt + "x8=" + numInt*8);
            System.out.println(numInt + "x9=" + numInt*9);
            System.out.println(numInt + "x10=" + numInt*10);
        } else {
            System.out.println("O número deve ser menor que 10.");
        }
    }

    public static void tabuadacomFOR(int numInt){
        for (int i=1; i<=10;i++){
            System.out.println(numInt + "x" + i + "="+ numInt*i);
        }
    }

}
