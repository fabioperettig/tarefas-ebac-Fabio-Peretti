/**
 * Representa uma pessoa física no sistema, herdando a classe abstrata
 * {@code Pessoa} e atribuindo valores próprios como "CPF".
 * <br><br>
 * Esta classe fornece sua própria implementação do método {@code discriminar()},
 * exibindo os dados específicos de uma pessoa física.
 */
public class PFisica extends Pessoa{

    private String cpf;

    //ctor
    public PFisica(String nome, String endereco, String cpf) {
        super(nome, endereco);
        this.cpf = cpf;
    }

    @Override
    public void discriminar() {
        System.out.printf("Tipo de cadastro: %s | Nome: %s | CPF: %s", getClass().getSimpleName(), getNome(), this.cpf);
        System.out.println("\nEndereço: " + getEndereco());

    }

}