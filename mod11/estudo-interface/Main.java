public class Main {

    public static void main(String[] args) {

        Bladeknight Algalord = new Bladeknight();
        SoulMaster Kadaj = new SoulMaster("Kadaj");
        SoulMaster Mirian = new SoulMaster("Mirian");

        int suaLife = 1000;

        boolean gameON = true;

        /*
        while (gameON) {
            System.out.printf("Sua vida é %d%n",suaLife);

            Kadaj.ataque();
            suaLife = suaLife - Kadaj.SMdano;


            Kadaj.ataqueEspecial();
            suaLife = suaLife - Kadaj.SMdano;

            System.out.println(Kadaj + " lhe causou um dano de: " + Kadaj.SMdano);
            System.out.printf("Sua vida é %d",suaLife);

            if ( suaLife <= 0){
                gameON = false;
            }

        } */

        Kadaj.intro();
        Algalord.ataque();
        ComportamentoRPG.credito();
        Mirian.intro();

    }

}
