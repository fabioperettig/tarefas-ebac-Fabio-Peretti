public class Comprador {

    private String nome;
    private Double dinheiro;

    //getterSetter
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getDinheiro() {
        return dinheiro;
    }
    public void setDinheiro(Double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public void comprar() {
        System.out.println("Compra realizada.");
    };

}
