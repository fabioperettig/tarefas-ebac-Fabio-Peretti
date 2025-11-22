import java.util.ArrayList;
import java.util.List;

public class Venda {

    private List <Produto> produtos;
    private Vendedor vendedor;
    private Comprador comprador;

    //ctor
    public Venda(){
        this.produtos = new ArrayList<>();
    }

    //getterSetter
    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void add(Produto produto) {
        this.produtos.add(produto);
    }

    public void remove(Produto produto) {
        this.produtos.remove(produto);
    }

    public void concretizarVenda(){
        System.out.printf("%nComprador: %s comprou os itens: ", this.comprador.getNome());

        for (Produto local : this.produtos) {
            System.out.printf("%n%s | valor: %.2f",local.getNome(), local.getValor());
        }

        System.out.println("\nVendedor: " + this.vendedor.getNome());

    };

    public void cancelarVenda(){
        System.out.println("Venda cancelada.");
    };


}