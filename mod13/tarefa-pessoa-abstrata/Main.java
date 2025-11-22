/**
 * Classe principal utilizada para demonstrar o uso da classe abstrata {@code Pessoa}
 * e suas especializações {@code PFisica} e {@code PJuridica}.
 * <br><br>
 * Este método {@code main} cria diferentes instâncias de pessoas físicas e jurídicas
 * e utiliza o polimorfismo para chamar o método {@code discriminar()} tanto de forma
 * direta quanto através do método utilitário {@code imprimir(Pessoa)}.
 * <br><br>
 * Este arquivo existe apenas como ponto de execução e demonstração dos conceitos
 * de herança, abstração e polimorfismo.
 */
public class Main {

    public static void main(String[] args) {

        //instâncias
        PFisica pf1 = new PFisica("João", "São Paulo", "123.456.789-10");
        PFisica pf2 = new PFisica("Maria", "Bahia", "332.678.456-32");
        PFisica pf3 = new PFisica("Jorge", "Santa Catarina", "450.345.365-09");

        PJuridica pj1 = new PJuridica("Dpto. Água LTDA", "São Paulo", "12.345.678/0001-00", "AguaRecovery");
        PJuridica pj2 = new PJuridica("Comunicação S.A.", "Minas Gerais", "13.456.732/00001-30", "Agência X");
        PJuridica pj3 = new PJuridica("Aurora Sistemas Integrados", "Curitiba", "55.888.222/0001-07", "Aurora Tech");


        //fisica
        pf1.discriminar();
        pf2.discriminar();
        imprimir(pf3);

        //juridica
        imprimir(pj1);
        imprimir(pj2);
        pj3.discriminar();


    }

    public static void imprimir(Pessoa p){
        p.discriminar();
    }

}
