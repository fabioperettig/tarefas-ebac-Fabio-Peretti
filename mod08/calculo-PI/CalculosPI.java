import java.util.Scanner;

public class CalculosPI {
    public double Raio;
    public double Diametro;
    public double Circun;


    public void calculoCirc(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o tamanho do Raio: ");
        String inputR = scanner.nextLine().replace(",",".");
        Raio = Double.parseDouble(inputR);
        Diametro = 2*Raio;
        Circun = 2*Math.PI*Raio;
    }

    public void calculoRaio(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o comprimento da Circunferência: ");
        String inputC = scanner.nextLine().replace(",",".");
        Circun = scanner.nextDouble();
        Raio = Circun/(2*Math.PI);
        Diametro = 2*Raio;
    }

}
