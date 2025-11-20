public class Horario extends Empregado{

    private Double precoHora;
    private Double horaTrabalhada;

    @Override
    public Double vencimento() {
        return precoHora*horaTrabalhada;
    }

    //getterSetter
    public Double getPrecoHora() {
        return precoHora;
    }
    public void setPrecoHora(Double precoHora) {
        this.precoHora = precoHora;
    }
    public Double getHoraTrabalhada() {
        return horaTrabalhada;
    }
    public void setHoraTrabalhada(Double horaTrabalhada) {
        this.horaTrabalhada = horaTrabalhada;
    }

    //ctor
    public Horario(String nome, String sobrenome, String CPF, Double precoHora, Double horaTrabalhada) {
        super(nome, sobrenome, CPF);
        this.precoHora = precoHora;
        this.horaTrabalhada = horaTrabalhada;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " – " +
                super.toString() +
                " | Preço/Hora: " + precoHora +
                " | Horas trabalhadas: " + horaTrabalhada +
                " | Valor total: R$ " + vencimento();
    }
}