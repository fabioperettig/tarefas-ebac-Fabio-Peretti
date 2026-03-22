/**
 * @version 1.0
 * @author fabioperettiguimaraes
 * Calculadora aritmética de tipo "primitivos" com limite em dois parâmetros.
 * Dispensa a necessidade de prestabelecer atributos de Classe (int a/int b), pois serão chamados já (e apenas) nos métodos
 */

public class CalculadoraPrimitiva {


    public int somar(int a, int b) {
        return a + b;
    }

    public int subtrair(int a, int b){
        return a - b;
    }

    public int multiplicar(int a, int b){
        return a * b;
    }

    public double dividir (double a, double b){
        if (b == 0){
            throw new IllegalArgumentException("Divisão por zero não permitida.");
        }
        return a / b;
    }
}
