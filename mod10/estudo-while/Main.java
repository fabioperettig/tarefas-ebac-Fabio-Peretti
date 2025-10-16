/**
 * Estudo comparativo entre o FOR e While para geração de loops.
 *
 * <li>A ordem entre alterar o valor de @int number e anunciar a quantidade (sout)
 * altera a saída no terminal.</li>
 * <li>Ordem no método via FOR – primeiro altera e depois anuncia;</li>
 * <li>Ordem no método via While – primeiro anuncia e depois altera.</li>
 *
 * @author fabioperettiguimaraes
 */
public class Main {

    static int number = 0;

    public static void main(String[] args) {


        for (int local=0;local<10;local++){
            number ++;
            System.out.println("Valor de int number: " + number);
        }

        System.out.println("\n---------------------------\n");

        while (number > 0){
            System.out.println("Valor de int number: " + number);
            number --;
        }

    }


    /**
     * Em comparação com o método FOR, o método While não precisa
     * condicionar uma variável local para exercer influência sobre
     * a variável principal.
     *
     * @deprecated uma forma prolixa e substituível pelo método visivelWhile().
     */
    public void analiseWhile(){
        int local = 0;
        while (number > 0){
            if (local <= 10){
                local ++;
            }
            System.out.println("Valor de int number: " + number);
            number--;
        }
    }

    public void visivelWhile(){
        while (number > 0) {
            System.out.println("Valor de int number: " + number);
            number--;
        }
    }

}
