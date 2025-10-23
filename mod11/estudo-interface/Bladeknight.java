public class Bladeknight implements ComportamentoRPG {

    private String nome;

    public Bladeknight(String nome) {
        this.nome = nome;
    }

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
        int BKdano = dano * (int)(Math.random()*3+1);
        System.out.println("O guerreiro ataca ferrozmente com sua lâmina incandescente!");
        System.out.printf("Dano de: %d%n",BKdano);
    }

    @Override
    public void ataqueEspecial() {
        System.out.println("O guerreiro lança sua espada que gira violentamente ao seu redor!");
        int BKdanoEsp = dano * (int)(Math.random()*8+1);
        System.out.printf("Dano de: %d%n",BKdanoEsp);
    }

    @Override
    public void respouso() {
        System.out.println("O guerreiro passa o tempo afiando sua lâmina.");
    }

    @Override
    public void objetivo() {
        System.out.println("Seu objetivo é derrotar todos os Tarkans!");
    }

    @Override
    public void derrota() {
        System.out.println("O guerreiro ferido, sente os rachados em sua armadura.");
    }
}
