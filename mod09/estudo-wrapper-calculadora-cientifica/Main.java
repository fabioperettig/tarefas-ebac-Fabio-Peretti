import java.util.List;

/**
 * @version 1.0
 * @author fabioperettiguimaraes
 * Projeto para estudos diferenciais entre atributos estilo primitios e estilo Wrappers.
 */
public class Main {

    public static void main(String[] args) {

        // ---- Área Calculadora Primitiva ----
        CalculadoraPrimitiva calcPrimitiva = new CalculadoraPrimitiva();

        System.out.println("=== Calculadora Primitiva ===");
        System.out.println("Soma: " + calcPrimitiva.somar(5,5));
        System.out.println("Subtração: " + calcPrimitiva.subtrair(15,5));
        System.out.println("Multiplicação: " + calcPrimitiva.multiplicar(3,5));
        System.out.println("Divisão: " + calcPrimitiva.dividir(25,5));

        // ---- Área Calculadora Wrapper ----
        CalculadoraWrapperBasica calcWrapper = new CalculadoraWrapperBasica();

        List<Integer> numeros = List.of(10, 3, 2, 5);
        System.out.println("\n=== Calculadora Wrapper ===");
        System.out.println("Soma: " + calcWrapper.somar(numeros));
        System.out.println("Subtrair: " + calcWrapper.subtrair(numeros));
        System.out.println("Multiplicação: " + calcWrapper.multiplicar(numeros));
        System.out.println("Divisão: " + calcWrapper.dividir(numeros));
    }
}
