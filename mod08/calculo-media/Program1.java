public class Program1 {

    public static void main(String[] args) {

        Notas notas = new Notas(5,7.5,8,3.75);
        System.out.println("*** Notas ***");

        System.out.println("Nota 1: " + notas.Nota1);
        System.out.println("Nota 2: " + notas.Nota2);
        System.out.println("Nota 3: " + notas.Nota3);
        System.out.println("Nota 4: " + notas.Nota4);
        System.out.println("|---------------------------------|");

        notas.media();

        System.out.println("Média de notas: " + notas.Media);
        System.out.printf("Média de notas: %.2f%n",notas.Media);
    }
}
