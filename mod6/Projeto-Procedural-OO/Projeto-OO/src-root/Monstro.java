public class Monstro {
    public String NomeMonstro;
    public int VidaInicialMonstro;
    public int VidaMonstro;
    public int[] DanoMonstro;

    ///construtor
    public Monstro(String nomeMonstro, int vidaInicialMonstro, int[] danoMonstro) {
        this.NomeMonstro = nomeMonstro;
        this.VidaInicialMonstro = vidaInicialMonstro;
        this.VidaMonstro = vidaInicialMonstro;
        this.DanoMonstro = danoMonstro;
    }
}
