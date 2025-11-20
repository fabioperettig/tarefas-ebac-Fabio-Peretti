public abstract class Empregado {

    private String nome;
    private String sobrenome;
    private String CPF;

    public abstract Double vencimento();

    //getterSetter
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    //ctor
    public Empregado(String nome, String sobrenome, String CPF) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.CPF = CPF;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                " | Sobrenome:" + sobrenome +
                " | CPF: " + CPF;
    }
}
