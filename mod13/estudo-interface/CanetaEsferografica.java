public class CanetaEsferografica implements ICaneta{

    @Override
    public void escrever(String texto) {
        System.out.println("Escrevendo: '" + texto +
                "' na classe " + getClass().getSimpleName());
    }

    @Override
    public String getColor() {
        return "azul";
    }

}
