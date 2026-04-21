import java.util.List;

public class Pessoa {

    private String nome;
    private String sexo;

    /// construtor vazio
    public Pessoa(){};

    /// construtor default
    public Pessoa(String nome, String sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public List<Pessoa> pessoaList(){
        Pessoa p1 = new Pessoa("Fabio","Masculino");
        Pessoa p2 = new Pessoa("Miguel","Masculino");
        Pessoa p3 = new Pessoa("Helena","Feminino");
        Pessoa p4 = new Pessoa("Arthur","Masculino");
        Pessoa p5 = new Pessoa("Alice","Feminino");
        Pessoa p6 = new Pessoa("Laura","Feminino");
        Pessoa p7 = new Pessoa("Manuel","Masculino");
        Pessoa p8 = new Pessoa("David","Masculino");
        Pessoa p9 = new Pessoa("Daniela","Feminino");
        Pessoa p10 = new Pessoa("Bernardo","Masculino");
        Pessoa p11 = new Pessoa("Maria","Feminino");
        Pessoa p12 = new Pessoa("Eduarda","Feminino");
        Pessoa p13 = new Pessoa("Cecília","Feminino");
        Pessoa p14 = new Pessoa("Diego","Masculino");

        return List.of(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14);
    }


    @Override
    public String toString() {
        return "Nome: " + nome + " – Sexo: " + sexo;
    }
}
