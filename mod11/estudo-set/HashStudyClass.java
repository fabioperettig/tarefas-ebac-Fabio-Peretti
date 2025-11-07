import java.util.Objects;

/**
 *  <h4>Exemplo de Classe para instanciar objetos usados em uma Hash.</h4>
 *  <br>
 *  <p>É necessário criar alguns métodos particulares da Classe para
 *  que o Hash funcione da forma correta. É preciso consiga comparar
 *  os <b><u>atributos</u></b> dos objetos instanciados, ao invés
 *  de comparar o Objeto/Memória alocada, e transformar estes dados
 *  para serem exibidos corretamente.</p>
 *  <ul>
 *      <li>toString()</li>
 *      <li>equals() and hashCode()</li>
 *  </ul>
 *  A boa notícia é que todos os métodos usados podem ser gerados
 *  instantaneamente na Classe, com o mesmo protocolo de criação
 *  de Construtores e Getters/Setters.
 */
public class HashStudyClass {

    private String band;
    private String style;
    private int songs;

    public HashStudyClass(String band, String style, int songs) {
        this.band = band;
        this.style = style;
        this.songs = songs;
    }

    /**
     * Método que transforma todos os dados dos objetos instanciados
     * para Strings.
     * @return dados do objeto formatados como println ou printf.
     */
    @Override
    public String toString() {
        return "Band: " + band +
                " | Style: " + style +
                " | Songs: " + songs +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashStudyClass that = (HashStudyClass) o;
        return songs == that.songs && Objects.equals(band, that.band) && Objects.equals(style, that.style);
    }

    @Override
    public int hashCode() {
        return Objects.hash(band, style, songs);
    }
}
