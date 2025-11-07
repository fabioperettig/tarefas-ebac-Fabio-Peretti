/**
 * Esta Classe representa um pequeno cadastro, contendo
 * um parâmetro String para nome e um parâmetro
 * Character para o sexo, sendo representado por:
 * <ul>
 *     <li>'M' – Masculino</li>
 *     <li>'F' – Feminino</li>
 * </ul>
 *
 */
public class exercClass {

    private String nome;
    private Character sexo;

    /**
     * Um construtor modificado, servido para intanciar o Objeto
     * de forma prática, mas que também já inclua o Objeto
     * em uma lista de forma automática.
     * <br><br>
     * Para que isso fosse possível, foi também necessário
     * criar os devidos métodos <b><u>.addAutomatico()</u></b>
     * nas Classes onde as Listas foram criadas.
     *
     * @author Fabio Peretti Guimarães
     * @param nome retorna uma String com o nome;
     * @param sexo retorna um Character com o sexo.
     */
    public exercClass(String nome, Character sexo) {
        this.nome = nome;
        this.sexo = sexo;
        exercParte01.addAutomatico01(this);
        exercParte02.addAutomatico02(this);
    }

    // Getters //
    public String getNome() {
        return nome;
    }
    public Character getSexo() {
        return sexo;
    }

}