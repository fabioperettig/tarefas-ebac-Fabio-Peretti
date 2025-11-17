public interface ICaneta {

    public void escrever(String texto);
    public String getColor();

    default void escritaDefault() {
        System.out.println("Escrita default com");
    }

}