/**
 * Representa uma pessoa jurídica no sistema, herdando os atributos de
 * {@code Pessoa} e adicionando atributos específicos como CNPJ e nome fantasia.
 * <br><br>
 * A classe também implementa o método {@code discriminar()} exibindo seus dados
 * característicos.
 */
public class PJuridica extends Pessoa{

    private String cnpj;
    private String nomeFantasia;

    //ctor
    public PJuridica(String nome, String endereco, String cnpj, String nomeFantasia) {
        super(nome, endereco);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }

    @Override
    public void discriminar() {
        System.out.printf("Tipo de cadastro: %s | Nome: %s | CNPJ: %s", getClass().getSimpleName(), getNome(), this.cnpj);
        System.out.println("\nNome fantasia: " + this.nomeFantasia);
        System.out.println("Endereço: " + getEndereco());

    }

}