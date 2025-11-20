/**
 * Projeto de estudo sobre Classes Abstratas, Herança e Polimorfismo em Java.
 *
 * <p>Este projeto demonstra:
 *
 * <ul>
 *     <li><b>Classe Abstrata:</b> a classe {@code Empregado} funciona como modelo para
 *     diferentes tipos de funcionários. Ela não pode ser instanciada diretamente e contém
 *     tanto atributos comuns (nome, sobrenome, CPF) quanto o método abstrato {@code vencimento()},
 *     que obriga cada subclasse a implementar sua própria forma de calcular o salário.</li>
 *
 *     <li><b>Herança:</b> as classes {@code Assalariado}, {@code Horario} e {@code Comissionado}
 *     estendem {@code Empregado}, herdando seus atributos e comportamentos básicos.
 *     Cada classe adiciona seus próprios atributos específicos e implementa o método
 *     {@code vencimento()} de acordo com sua regra de pagamento.</li>
 *
 *     <li><b>Construtores com super():</b> A classe {@code Empregado} possui um construtor que
 *     inicializa nome, sobrenome e CPF. As subclasses chamam este construtor utilizando
 *     {@code super(...)} para garantir que todos os empregados sejam criados corretamente.</li>
 *
 *     <li><b>Polimorfismo:</b> O código demonstra que é possível declarar variáveis do tipo
 *     {@code Empregado} referenciando objetos de subclasses (ex.: {@code new Assalariado()}).
 *     Assim, o método {@code vencimento()} executa a implementação correspondente ao tipo real
 *     do objeto, mesmo quando a referência é do tipo genérico {@code Empregado}.</li>
 *
 *     <li><b>toString() Sobrescrito:</b> Cada subclasse sobrescreve o método {@code toString()}
 *     combinando os dados herdados de {@code Empregado} com informações próprias.
 *     Isso permite impressões claras e formatadas, incluindo valores numéricos com
 *     duas casas decimais via {@code String.format()}.</li>
 * </ul>
 *
 * <p>No método {@code main()}, diferentes tipos de empregados são instanciados e impressos.
 * O projeto evidencia como a herança organiza o código, como o polimorfismo flexibiliza
 * o uso das classes e como cada tipo de funcionário pode se comportar de forma especializada.
 *
 * <p>Este é um excelente exemplo de aplicação dos pilares da Programação Orientada a Objetos:
 * <b>abstração, herança e polimorfismo</b>.
 */
public class Main {

    public static void main(String[] args) {

        Assalariado a1 = new Assalariado("Fabio", "Peretti", "123.345.567-3", 100.00);
        Comissionado a2 = new Comissionado("Pedro", "Felix", "192.188.123-4", 450.40, 100.0);
        Horario a3 = new Horario("Maria", "Rita", "234.567.896-4", 75.0, 8.5);
        Empregado a4 = new Assalariado("Cris", "Ruppert", "123.456.789-0", 300.00);


        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
    }

}
