
public class SoulMaster implements ComportamentoRPG {

    private String nome;

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
        System.out.printf("O mago %s ataca lança fireballs nos inimigos!%n",nome);
        int SMdano = dano*(int)(Math.random()*3+1);
        System.out.println(nome + " lhe causou um dano de: " + SMdano);
    }

    @Override
    public void ataqueEspecial() {
        System.out.printf("O mago %s convoca espíritos negros!%n",nome);
        int SMdano = dano*(int)(Math.random()*10+1);
        System.out.println(nome + " lhe causou um dano de: " + SMdano);
    }

    @Override
    public void respouso() {
        System.out.printf("O mago %s passa o tempo estudando seus tomos antigos!%n",nome);
    }

    @Override
    public void objetivo() {
        System.out.println("Seu objetivo é retirar os poderes de Dark Kundun!");
    }

    @Override
    public void derrota() {
        System.out.printf("O mago %s sente sua energia drenada de seu corpo.%n",nome);
    }
}
