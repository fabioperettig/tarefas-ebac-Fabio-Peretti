public class Comissionado extends Empregado {

    private Double totalVenda;
    private Double totalComissao;

    @Override
    public Double vencimento() {
        return totalVenda*totalComissao;
    }

    //getterSetter
    public Double getTotalVenda() {
        return totalVenda;
    }
    public void setTotalVenda(Double totalVenda) {
        this.totalVenda = totalVenda;
    }
    public Double getTotalComissao() {
        return totalComissao;
    }
    public void setTotalComissao(Double totalComissao) {
        this.totalComissao = totalComissao;
    }

    //ctor
    public Comissionado(String nome, String sobrenome, String CPF, Double totalVenda, Double totalComissao) {
        super(nome, sobrenome, CPF);
        this.totalVenda = totalVenda;
        this.totalComissao = totalComissao;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " – " +
                super.toString() +
                " | Total de Vendas: " + totalVenda +
                " | Comissão: R$ " + vencimento();
    }
}
