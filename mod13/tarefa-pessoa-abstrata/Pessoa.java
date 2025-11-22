/**
 * Representa um modelo genérico de pessoa, contendo apenas os atributos e
 * comportamentos que são comuns a todos os tipos de pessoas do sistema.
 * <br><br>
 * Esta classe é abstrata pois não faz sentido instanciá-la diretamente,
 * servindo apenas como base para as Classes {@code PFisica} e {@code PJuridica},
 * garantindo que ambas herdem nome e endereço.
 */
public abstract class Pessoa {

    private String nome;
    private String endereco;

    //ctor
    public Pessoa(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    //getterSetter
    public String getNome() {
        return nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Exibe as informações específicas do tipo de pessoa.
     * Cada subclasse deve implementar este método com sua própria lógica.
     */
    public abstract void discriminar();
}