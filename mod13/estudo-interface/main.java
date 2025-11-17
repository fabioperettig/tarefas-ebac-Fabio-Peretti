public class main {

    public static void main(String[] args) {
        ICaneta esfero1 = new CanetaEsferografica();
        esfero1.escrever("Hello esfero");
        System.out.println("Na cor: " + esfero1.getColor());

        ICaneta esfero2 = new CanetaEsferografica();
        esfero2.escritaDefault();
        System.out.println("Na cor: " + esfero2.getColor());

        ICaneta giz1 = new Giz();
        giz1.escritaDefault();
        giz1.escrever("chão de giz");
        System.out.println("Na cor " + giz1.getColor());

        Lapis lapis1 = new Lapis();
        lapis1.escrever("folha amarela");
        System.out.println("Na cor:" + lapis1.getColor());
    }

}
