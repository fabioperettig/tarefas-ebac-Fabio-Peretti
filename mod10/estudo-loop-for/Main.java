
public class Main {

    ///static int x = 0; > possivelmente loop sem variavel local

    public static void main(String[] args) {


        System.out.println("\nExemplo FOR com inteiros:");
        for (int i = 0; i<=10; i++){
            System.out.println("Linha " + i);
        }

        System.out.println("\n-------------------------");

        System.out.println("\nExemplo FOR com double:");
        for (double d = 0; d<=10.0; d= d + 0.5){
            System.out.printf("\n Linha %.1f", d);
        }



        apenasPar();


    }

    private static void apenasPar() {
        for(int par = 0; par <= 100; par++){
            if (par%5!=0){
                continue;
            }
            System.out.println(par);
        }
    }

}
