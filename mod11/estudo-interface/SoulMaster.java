public class SoulMaster implements ComportamentoRPG {
    private String nome;
    int SMdano;

    public SoulMaster(String nome) {
        this.nome = nome;
    }


    /**
     * Método para pegar o nome de qualquer objetivo proveniente da Classe,
     * com base no método de interface {@link #intro()};
     *
     * @return nome do Objeto instanciado.
     */
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void intro() {
        ComportamentoRPG.super.intro();
    }

    @Override
    public void ataque() {
        System.out.println("O mago ataca lança fireballs nos inimigos!");
        SMdano = dano;
    }

    @Override
    public void ataqueEspecial() {
        System.out.println("O mago convoca espíritos negros");
        SMdano = dano * 3;
        System.out.println(getClass().getSimpleName() + " lhe causou um dano de: " + SMdano);
    }

    @Override
    public void respouso() {
        System.out.println("O mago passa o tempo estudando seus tomos antigos.");
    }

    @Override
    public void objetivo() {
        System.out.println("Seu objetivo é retirar os poderes de Dark Kundun!");
    }

    @Override
    public void derrota() {
        System.out.println("O mago sente sua energia drenada de seu corpo.");
    }
}
