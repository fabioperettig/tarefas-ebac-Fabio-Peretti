import java.util.List;

/**
 * @version 1.0
 * @author fabioperettiguimaraes
 * Calculadora aritmética Wrapper sem limite de parâmetros.
 */
public class CalculadoraWrapperBasica {

    public Integer somar(List<Integer> numeros) {
        int soma = 0;
        for (Integer n : numeros) {
            if (n != null) soma += n;
        }
        return soma;
    }

   public Integer subtrair(List<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()) return null;
        Integer result = null;
        for (Integer n : numeros) {
            if (n != null) {
                if (result == null) {
                    result = n;
                } else {
                    result -= n;
                }
            }
        }
        return result == null ? 0 : result;
   }

   public Integer multiplicar(List<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()) return 1;
        int produto = 1;
        for (Integer n : numeros) {
            if (n != null) {
                produto *= n;
            }
        }
        return produto;
   }

   public Double dividir(List<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()) return null;
        Double resultado = null;
        int idx = 0;
        for (Integer n : numeros) {
            if (n != null) {
                if (resultado == null) {
                    resultado = n.doubleValue();
                } else {
                    if (n == 0) {
                        throw new IllegalArgumentException("Divisão por zero não permitida.");
                    }
                    resultado /= n;
                }
            }
        }
        return resultado;
   }

}