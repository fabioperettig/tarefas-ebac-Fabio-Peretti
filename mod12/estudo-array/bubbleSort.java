public class bubbleSort {

    public static void main(String[] args) {

        int[] arrayFixaBubble = {6,8,3,7,2,1,9,4,10,5};
        bubbleSortFixo(arrayFixaBubble);

    }

    /**
     * Método para deixar uma array em ordem crescente, comparando o elemento
     * de um index N com o elemento seguinte (N+1). Caso N seja maior que N+1
     * o método segue o algoritmo:
     *
     * <ul>
     *     <li>Armazena o maior elemento em uma variável local;</li>
     *     <li>Atribui o menor valor ao index do maior valor (index N+1 vai para index N);</li>
     *     <li>Atribui ao index N+1 o valor maior que estava armazenado na variável local;</li>
     *     <li>Finaliza e faz uma nova comparação com os elementos seguintes (N+2... N+3)</li>
     * </ul>
     *
     * @param array recebe qualquer array como parâmetro
     * @author Fabio Peretti Guimarães
     */
    public static void bubbleSortFixo(int[] array){
        for(int i=0; i<array.length;i++){

            for (int n=0; n < array.length-1;n++){

                if(array[n] > array[n+1]){
                    int local = array[n];
                    array[n] = array[n+1];
                    array[n+1] = local;
                }
            }

        }

        for (int print:array){
            System.out.println(print);
        }

    }



}
