import java.util.ArrayList;
import java.util.List;


/**
 * <h2>Classe {@code autoAddList}</h2>
 *
 * <p>Representa um modelo de jogador com atributos básicos, como
 * {@code name}, {@code level} e {@code readyReset}.</p>
 *
 * <p>A classe mantém uma lista estática de todas as instâncias criadas,
 * adicionando automaticamente cada novo objeto à lista {@code players}
 * no momento da sua instanciação.</p>
 *
 * <p>Inclui métodos para retornar informações específicas sobre
 * os jogadores (como nomes e níveis), além de um método de checagem
 * que define se o jogador está pronto para reset com base em seu nível.</p>
 *
 * <h3>Resumo de funcionalidades:</h3>
 * <ul>
 *   <li>Criação automática e registro de objetos na lista {@code players};</li>
 *   <li>Filtragem e retorno de dados específicos (nomes, níveis, etc.);</li>
 *   <li>Validação automática de status de reset;</li>
 *   <li>Exibição formatada via método {@code toString()}.</li>
 * </ul>
 *
 * @author Fabio
 * @since november 2025
 */
public class autoAddList {

    private String name;
    private int level;
    private boolean readyReset;

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public boolean isReadyReset() {
        return readyReset;
    }

    /**
     * <h3>## CONSTRUTOR ##</h3>
     * <p>Construtor com método <u>.add()</u> implementado,
     * adicionando o objeto à Lista no momento de sua criação.</p>
     * @param name adiciona uma String ao valor;
     * @param level adiciona um int ao valor;
     */
    public autoAddList(String name, int level) {
        this.name = name;
        this.level = level;
        this.readyReset = false;
        checkReset();
        players.add(this);
    }

    // listas e métodos
    private static final List <autoAddList> players = new ArrayList<>();

    /**
     * <p>Método de retorno {@link List} que funciona como Getter para os objetos armazenados
     * em: <br><br> <u>{@code List <autoAddList> players}</u><br><br></p>
     *
     * <p>Cada elemento desta lista representa uma instância da classe {@code autoAddList}
     * criada automaticamente no momento da sua instanciação.</p>
     *
     * @return uma {@link List} contendo todos os objetos {@code autoAddList} criados.
     */
    public static List<autoAddList> getPlayers(){
        return players;
    }



    // MÉTODOS PARA PEGAR OS DADOS DA LISTA


    /**
     * Método para pegar apenas a variável name (String) e retorná-los
     * ao chamar o método.<br>
     *
     * <ul>
     *     <li> Cria uma nova Lista com retorno <<b>String</b>>;</li>
     *     <li> Executa um loop For-each, percorrendo todos os objetos da lista players,
     *     armazenando cada um na variável 'local durante a iteração.”;</li>
     *     <li> Adiciona cada nome à variável Local através do Getter GetName()
     *     criado na Classe;</li>
     *     <li>Retorna os nomes de todos os Objetos da List</li>
     * </ul>
     * @return todos os nomes da List
     */
    public static List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (autoAddList local : players) {
            names.add(local.getName());
        }
        return names;
    }

    public static List<Integer> getLevels() {
        List<Integer> levels = new ArrayList<>();
        for (autoAddList local : players){
            levels.add(local.getLevel());
        }
        return levels;
    }

    public void checkReset(){
        if (level >= 350 ) {
            readyReset = true;
        } else {
            readyReset = false;
        }
    }


    /**
     * <b>toString()</b><br>
     *
     * Este método sobrescreve (override) o método {@code toString()} herdado da classe {@link Object}.<br>
     * Em Java, toda classe herda de {@code Object}, que fornece um comportamento padrão
     * para representar o objeto como texto — normalmente algo como o nome da classe seguido do endereço de memória.<br><br>
     *
     * Ao sobrescrever este método, podemos definir uma forma personalizada de exibir
     * as informações do objeto, tornando a saída mais legível ao usar
     * {@code System.out.println()} ou operações de log.<br><br>
     *
     * <b>Exemplo de uso:</b><br>
     * {@code System.out.println(meuObjeto);} → exibirá o texto definido neste método.
     *
     * @return Uma representação textual (String) personalizada do objeto atual.
     */
    @Override
    public String toString() {
        return name + " | lvl: " + level + " | " + (readyReset ? "Pronto para reset. \n" : "Faltam " + (350-level) + " levels para reset.\n" );
    }


    static {
        autoAddList player1 = new autoAddList("Aron", 320);
        autoAddList player2 = new autoAddList("Bob", 150);
        autoAddList player3 = new autoAddList("Coil", 70);
        autoAddList player4 = new autoAddList("Dylan", 10);
        autoAddList player5 = new autoAddList("Edy", 400);
    }

    public static void main(String[] args) {



        //System.out.println(autoAddList.getNames());
        System.out.println(autoAddList.getPlayers());
    }

}