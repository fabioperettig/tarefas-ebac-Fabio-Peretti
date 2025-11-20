public class Assalariado extends Empregado{

    private double salario;

    @Override
    public Double vencimento() {
        return salario;
    }

    //getterSetter
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    //ctor
    public Assalariado(String nome, String sobrenome, String CPF, double salario) {
        super(nome, sobrenome, CPF);
        this.salario = salario;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " – " +
                super.toString() +
                " | Salário: R$ " +
                String.format("%.2f", salario);
    }
}
