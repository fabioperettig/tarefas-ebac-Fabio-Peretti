public class Bladeknight implements ComportamentoRPG {

    @Override
    public String getNome() {
        return null;
    }

    @Override
    public void intro() {
        ComportamentoRPG.super.intro();
    }

    @Override
    public void ataque() {
        System.out.println("O guerreiro ataca ferrozmente com sua lâmina incandescente!");
    }

    @Override
    public void ataqueEspecial() {
        System.out.println("O guerreiro lança sua espada que gira violentamente ao seu redor!");
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
