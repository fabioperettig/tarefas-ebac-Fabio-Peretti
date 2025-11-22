public class Main {



    public static void main(String[] args) {

        Produto prd1 = criarProduto(12345L, 100.00, "TV");
        Produto prd2 = criarProduto(123234L, 100.00, "Sofá");
        Produto prd3 = criarProduto(154433L, 100.00, "Smartphone");
        Produto prd4 = criarProduto(87654567L, 100.00, "Headphone");

        Vendedor vnd1 = criarVendedor("Bob", 100.00);
        Vendedor vnd2 = criarVendedor("Alex", 120.00);
        Vendedor vnd3 = criarVendedor("Cris", 110.00);

        Comprador cpr1 = criarComprador("Lucas", 450.00);
        Comprador cpr2 = criarComprador("Marta", 600.00);
        Comprador cpr3 = criarComprador("Jorge", 970.00);


        Venda venda1 = new Venda();
        venda1.setVendedor(vnd1);
        venda1.setComprador(cpr2);
        venda1.add(prd4);
        venda1.add(prd2);
        venda1.add(prd1);

        venda1.concretizarVenda();

    }


    //factoryMethod – Mesma coisa que instanciar objetos com construtores
    private static Produto criarProduto(Long codigo, Double valor, String nome){
      Produto produto = new Produto();
      produto.setCodigo(codigo);
      produto.setValor(valor);
      produto.setNome(nome);

      return produto;
    }

    private static Vendedor criarVendedor(String nome, Double comissao){
        Vendedor vendedor = new Vendedor();
        vendedor.setNome(nome);
        vendedor.setComissao(comissao);

        return vendedor;
    }

    private static Comprador criarComprador(String nome, Double dinheiro){
        Comprador comprador = new Comprador();
        comprador.setNome(nome);
        comprador.setDinheiro(dinheiro);

        return comprador;
    }

}
