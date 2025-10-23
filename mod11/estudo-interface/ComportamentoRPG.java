/**
 * <p>Esta é uma interface define o contrato básico de comportamento para classes que representem personagens
 * em um sistema de RPG. Toda classe que implementar esta interface deve fornecer sua
 * própria versão (implementação) de cada um dos métodos abstratos definidos aqui.</p>
 *
 * <p>Os métodos representam ações comuns em personagens de jogos do tipo RPG, como
 * atacar, descansar, definir objetivos e reagir à derrota.</p>
 *
 * <p>Além dos métodos obrigatórios, esta interface também fornece:</p>
 * <ul>
 *   <li>Um método {@code default} chamado {@link #intro()}, que fornece um
 *   comportamento padrão de introdução para qualquer personagem que não o sobrescreva.</li>
 *   <li>Um método {@code static} chamado {@link #credito()}, que exibe uma mensagem
 *   fixa de autoria do jogo. Métodos estáticos em interfaces não podem ser sobrescritos.</li>
 * </ul>
 *
 * <p><b>Contrato:</b> toda classe que implementar {@code ComportamentoRPG} deve obrigatoriamente
 * implementar os seguintes métodos:</p>
 * <ul>
 *   <li>{@link #intro()} ()}</li>
 *   <li>{@link #ataque()}</li>
 *   <li>{@link #ataqueEspecial()}</li>
 *   <li>{@link #respouso()}</li>
 *   <li>{@link #objetivo()}</li>
 *   <li>{@link #derrota()}</li>
 * </ul>
 *
 * @author Fabio Peretti Guimarães
 * @version 1.0
 */
public interface ComportamentoRPG {

    String getNome();
    int dano = 10;

    /**
     * Método {@code default} para pegar o nome do Objeto por uma String getNome()
     * + um construtor na Classe implementada.
     */
    default void intro() {System.out.println(getNome() + " é da classe " + getClass().getSimpleName());};
    void ataque();
    void ataqueEspecial();
    void respouso();
    void objetivo();
    void derrota();

    static void credito(){
        System.out.println("Desenvolvido por Fabio Peretti Guimarães");
    };

}