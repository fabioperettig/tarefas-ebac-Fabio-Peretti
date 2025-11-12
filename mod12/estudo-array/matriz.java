public class matriz {

    public static void main(String[] args) {

        int [][] matriz = {{1,2,3},{4,5,6}};

        printMatriz(matriz);
        System.out.println(matriz[0][2]);//linha 0 | coluna 2


    }

    public static void printMatriz(int[][] array){
        for (int linha = 0; linha < array.length; linha ++){

            for(int coluna = 0; coluna < array[linha].length; coluna ++) {
                System.out.printf("%d, ", array[linha][coluna]);
            }
            System.out.println();
        }
    }


}
