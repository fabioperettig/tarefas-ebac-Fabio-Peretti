public class Notas {

    public double Nota1;
    public double Nota2;
    public double Nota3;
    public double Nota4;

    public double Media;

    public Notas(double nota1, double nota2, double nota3, double nota4){
        this.Nota1 = nota1;
        this.Nota2 = nota2;
        this.Nota3 = nota3;
        this.Nota4 = nota4;
    }

    public void media(){
        Media = (Nota1 + Nota2 + Nota3 + Nota4) / 4;
    }

}
