public class mainArrayLinear {

    /**
     * Este estudo mostra a possibilidades de se trabalhar com arrays, podendo ser instanciadas
     * já com os valores finais, ou com a quantidade de espaços alocados para os valores.
     *
     * <ul>
     *     <li>int[ ] valFinais = {1,2,3,4}</li>
     *     <li>int[ ] espAlocados = new int[3]</li>
     * </ul>
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] array01 = {1,3,5,7};

        int[] array02 = new int[4];
        array02[0] = 2;
        array02[1] = 4;
        array02[2] = 6;
        array02[3] = 8;


        System.out.println("-- Impressão de array pre definida: --");
        printArray(array01);//basicamente um método artimético que recebe dois parâmetros INT

        System.out.println("\n-- Impressão de array pre alocada e definida posteriormente: --");
        printArray(array02);//basicamente um método artimético que recebe dois parâmetros INT

    }

    /**
     * Um método que recebe uma array como parâmetro, podendo ser executado em qualquer array linear
     * criado, sendo apenas necessário aplicar como parâmetro a array desejada.
     * @param array
     */
    public static void printArray(int[] array){
        for (int local:array){
            System.out.println(local);
        }
    };


}
