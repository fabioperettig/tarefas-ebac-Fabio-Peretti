import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


/**
 * Classe responsável por gerenciar o sorteio
 * de jogadores da lista {@code autoAddList}.
 * Ela embaralha a lista de jogadores disponíveis
 * e retorna uma sublista com os jogadores selecionados.
 */
public class SorteioLista {

    private static final List<autoAddList> playerDisponiveis = new ArrayList<>();

    /**
     * Embaralha a lista de jogadores disponíveis e seleciona
     * uma quantidade específica de jogadores.
     *
     * @param quantidade o número de jogadores a serem sorteados..
     */
    public static void sortear (int quantidade){
        List<autoAddList> todos = new ArrayList<>(autoAddList.getPlayers()); //pega a lista original
        Collections.shuffle(todos);//embaralha a ordem

        playerDisponiveis.clear(); // limpa histórico

        for (int i = 0; i < quantidade && i < todos.size(); i++){
            playerDisponiveis.add(todos.get(i));
        }
    }

    /**
     * Retorna a lista com os jogadores que foram sorteados
     * na última execução do método {@code sortear}.
     *
     * @return lista dos jogadores disponíveis/sorteados.
     */
    public static List<autoAddList> getPlayerDisponiveis(){
        return playerDisponiveis;
    }

    /**
     * Executa um exemplo prático de sorteio, selecionando
     * um número X de jogadores e exibe-os no console.
     *
     * @param args argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        SorteioLista.sortear(3);

        System.out.println(SorteioLista.getPlayerDisponiveis());
    }

}
