public class Vendedor {

    private Double comissao;

    //getterSetter
    public Double getComissao() {
        return comissao;
    }
    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }

    public void vender() {
        System.out.println("Venda realizada.");
    };

}
