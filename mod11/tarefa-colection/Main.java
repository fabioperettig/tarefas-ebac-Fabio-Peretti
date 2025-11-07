import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;


/**
 * <h3>EBAC – Tarefa módulo 11 | Coleções e Manipulação de Listas</h3>
 * <br>
 * Este projeto tem como objetivo demonstrar o uso de
 * <b>listas dinâmicas (ArrayList)</b> e operações básicas
 * de manipulação de String, através da leitura de entrada do usuário
 * via Scanner e da aplicação de regras lógicas para formatação/categorização.
 * <br><br>
 * O programa permite ao usuário inserir uma lista de nomes
 * separados por vírgulas. Em seguida, realiza as seguintes ações:
 *
 * <ol>
 *     <li>Formata a capitalização dos nomes;</li>
 *     <li>Ordena os nomes alfabeticamente;</li>
 *     <li>Analisa cada nome e atribui um gênero com base na última letra;</li>
 *     <li>Separa os nomes em grupos masculinos e femininos, com formatação final.</li>
 * </ol>
 *
 * <h4>Métodos principais</h4>
 * <ul>
 *     <li>{@link #printPrimeiraMaiuscula()} – Formata os nomes com a primeira letra em maiúscula.</li>
 *     <li>{@link #printNomesOrdem()} – Ordena/imprime os nomes alfabeticamente.</li>
 *     <li>{@link #checarVogal()} – Classifica os nomes de acordo com a última letra.</li>
 *     <li>{@link #separarSexo()} – Agrupa/imprime os nomes em listas separadas por gênero.</li>
 * </ul>
 *
 * Todo o fluxo é executado de forma sequencial, com pequenas pausas entre execuções
 * através do método {@link Thread#sleep(long)} para uma melhor experiência do usuário.
 *
 * @author Fabio Guimarães
 * @since Novembro 2025
 *
 * @see #printPrimeiraMaiuscula()
 * @see #printNomesOrdem()
 * @see #checarVogal()
 * @see #separarSexo()
 */
public class Main {

    static int cooldown = 500;
    static Scanner input = new Scanner(System.in);
    static String listaInput;
    static List<String> listaNomes = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {

        System.out.println("\n----- Exercício Ebac – Módulo11 | Parte 01 -----");
        Thread.sleep(cooldown);

        System.out.println("Adicione os nomes desejados, separados por vírgula:");
        listaInput = input.nextLine();
        String[] nomes = listaInput.split("\\s*,\\s*"); //split() que também elimina espaços vazios

        Collections.addAll(listaNomes, nomes);

        // @decrecated
        // System.out.println("\n#### IMPRESSÃO DE NOMES DA LISTA ####");
        // printPrimeiraMaiuscula();

        Thread.sleep(cooldown);
        System.out.println("\n#### IMPRESSÃO DE LISTA ORDENADA ####");
        printNomesOrdem();

        System.out.println("\n----- Exercício Ebac – Módulo11 | Parte 02 -----");
        System.out.println("\nAnalisando nomes e atribuindo sexo/gênero:");

        Thread.sleep(cooldown);
        checarVogal();

        Thread.sleep(cooldown);
        separarSexo();
    }

    /**
     * Método que formata e imprime os nomes armazenados na lista principal,
     * garantindo que apenas o primeiro caractere de cada nome
     * esteja em caixa alta.
     * <br><br>
     * O método percorre toda a lista através de um loop <i>for-each</i>,
     * aplicando a mudança antes da impressão.
     *
     * @deprecated Método redundante e foi substituído por {@link #printNomesOrdem()},
     * que realiza a mesma tarefa e ordenação as Strings de forma alfabética.
     *
     * @see #printNomesOrdem()
     */
    public static void printPrimeiraMaiuscula() {
        for (String localString : listaNomes) {
            String printUpper = localString.substring(0, 1).toUpperCase() + localString.substring(1);
            System.out.printf("%-6s | ", printUpper);
        }

    }

    /**
     * Imprime a lista principal de nomes em ordem alfabética,
     * formatando cada nome para que apenas o primeiro caractere
     * fique em caixa alta.
     * <br><br>
     * O método cria uma cópia da lista original
     * ({@code listaNomes}) e a ordena através da constante
     * {@link String#CASE_INSENSITIVE_ORDER}, garantindo
     * que a ordenação não seja afetada por diferenças
     * de maiúsculas e minúsculas.
     * <br><br>
     * Após a ordenação, os nomes são impressos lado a lado,
     * com espaçamento fixo através de um print format.
     */
    public static void printNomesOrdem() {
        List<String> ordem = new ArrayList<>(listaNomes);
        ordem.sort(String.CASE_INSENSITIVE_ORDER);

        for (String nome : ordem) {
            String printUpper = nome.substring(0, 1).toUpperCase() + nome.substring(1);
            System.out.printf("%-6s | ", printUpper);
        }

        System.out.println();

    }


    /**
     * Método que analisa todos os nomes inseridos pelo input e atribui
     * automaticamente um gênero, com base na última letra de cada nome.
     * <br><br>
     * Antes da análise, o método remove possiveis espaços extras
     * na String, atravé sdo método {@link String#trim()} e extrai o último caractere
     * para a comparação via switch(String).
     * <br><br>
     * <b>O algoritmo baseia-se nas seguintes regras:</b>
     * <ul>
     *     <li>Termina com 'a' → Feminino (F)</li>
     *     <li>Termina com 'o', 'l' → Masculino (M)</li>
     *     <li>Termina com 'e', 'i', 'm', 'n', 'r', 's', 'z' → checa exceções</li>
     *     <li>Qualquer outro caractere → indefinido ("?")</li>
     * </ul>
     *
     * Exceções (nomes que fogem à regra, como “Muriel”, “Beatriz”, etc.)
     * são equiparados a nomes já predefinidos e separados em case, através do método
     * {@link String#equalsIgnoreCase(String)}.
     */
    public static void checarVogal() {

        for (String nome : listaNomes) {
            nome = nome.trim();  // limpa espaços extras
            char ultimaLetra = Character.toLowerCase(nome.charAt(nome.length() - 1));  // pega a última letra da String

            String sexo = null;

            switch (ultimaLetra) {

                case 'a' -> {
                    if (nome.equalsIgnoreCase("Kaka") || nome.equalsIgnoreCase("Zeca"))
                        sexo = "M";
                    else
                        sexo = "F";
                }

                case 'o', 'l' -> {
                    if (nome.equalsIgnoreCase("Muriel"))
                        sexo = "F";
                    else
                        sexo = "M";
                }

                case 'e', 'i' -> {
                    if (nome.equalsIgnoreCase("Alice") || nome.equalsIgnoreCase("Aline") ||
                            nome.equalsIgnoreCase("Daniele") || nome.equalsIgnoreCase("Gisele")
                            || nome.equalsIgnoreCase("Jaqueline") || nome.equalsIgnoreCase("Naomi"))
                        sexo = "F";
                    else
                        sexo = "M";
                }

                case 'm', 'n' -> {
                    if (nome.equalsIgnoreCase("Mirian") || nome.equalsIgnoreCase("Evelin") ||
                            nome.equalsIgnoreCase("Karen") || nome.equalsIgnoreCase("Kathelyn"))
                        sexo = "F";
                    else
                        sexo = "M";
                }

                case 'r', 's' -> {
                    if (nome.equalsIgnoreCase("Nair") || nome.equalsIgnoreCase("Eleonor") ||
                            nome.equalsIgnoreCase("Esther") || nome.equalsIgnoreCase("Jennifer") ||
                            nome.equalsIgnoreCase("Lais") || nome.equalsIgnoreCase("Doris"))
                        sexo = "F";
                    else
                        sexo = "M";
                }

                case 'z' -> {
                    if (nome.equalsIgnoreCase("Beatriz"))
                        sexo = "F";
                    else
                        sexo = "M";
                }

                default -> sexo = "?";

            }

            String nomeFormatado = nome.substring(0, 1).toUpperCase() + nome.substring(1).toUpperCase();
            //System.out.println(nomeFormatado + " – " + sexo);

            System.out.printf("%-6s – %s | ", nomeFormatado,sexo);
        }

        System.out.println();

    }


    /**
     * Um método que funciona com o mesmo princípio do método {@link #checarVogal()},
     * mas que retorna os nomes agrupados em duas arrayList<>() do tipo String.
     *
     * <ul>
     *     <li>List<String> nomesMasculinos = new ArrayList<>();</li>
     *     <li>List<String> nomesFemininos = new ArrayList<>();</li>
     * </ul>
     *
     * Após os agrupamentos, ambas as listas são ordenadas alfabeticamente
     * através do método {@link Collections#sort(List, java.util.Comparator)}
     * utilizando o comparador {@link String#CASE_INSENSITIVE_ORDER},
     * e impressas no console com formatação capitalizada.
     *
     * @see #checarVogal()
     */
    public static void separarSexo() {

        List<String> nomesMasculinos = new ArrayList<>();
        List<String> nomesFemininos = new ArrayList<>();

        for (String nome : listaNomes) {
            nome = nome.trim();

            char ultimaLetra = Character.toLowerCase(nome.charAt(nome.length()-1));

            switch (ultimaLetra) {

                case 'a' -> {
                    if (nome.equalsIgnoreCase("Kaka") || nome.equalsIgnoreCase("Zeca"))
                        nomesMasculinos.add(nome);
                    else
                        nomesFemininos.add(nome);
                }

                case 'o', 'l' -> {
                    if (nome.equalsIgnoreCase("Muriel"))
                        nomesFemininos.add(nome);
                    else
                        nomesMasculinos.add(nome);
                }

                case 'e', 'i' -> {
                    if (nome.equalsIgnoreCase("Alice") || nome.equalsIgnoreCase("Aline") ||
                            nome.equalsIgnoreCase("Daniele") || nome.equalsIgnoreCase("Gisele")
                            || nome.equalsIgnoreCase("Jaqueline") || nome.equalsIgnoreCase("Naomi"))
                        nomesFemininos.add(nome);
                    else
                        nomesMasculinos.add(nome);
                }

                case 'm', 'n' -> {
                    if (nome.equalsIgnoreCase("Mirian") || nome.equalsIgnoreCase("Evelin") ||
                            nome.equalsIgnoreCase("Karen") || nome.equalsIgnoreCase("Kathelyn"))
                        nomesFemininos.add(nome);
                    else
                        nomesMasculinos.add(nome);
                }

                case 'r', 's' -> {
                    if (nome.equalsIgnoreCase("Nair") || nome.equalsIgnoreCase("Eleonor") ||
                            nome.equalsIgnoreCase("Esther") || nome.equalsIgnoreCase("Jennifer") ||
                            nome.equalsIgnoreCase("Lais") || nome.equalsIgnoreCase("Doris"))
                        nomesFemininos.add(nome);
                    else
                        nomesMasculinos.add(nome);
                }

                case 'z' -> {
                    if (nome.equalsIgnoreCase("Beatriz"))
                        nomesFemininos.add(nome);
                    else
                        nomesMasculinos.add(nome);
                }

            }

        }

        Collections.sort(nomesMasculinos, String.CASE_INSENSITIVE_ORDER);
        Collections.sort(nomesFemininos, String.CASE_INSENSITIVE_ORDER);

        System.out.println("\n ---- Nomes Masculinos (M) ----");
        for (String nome : nomesMasculinos){
            String nomeFormatM = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
            System.out.printf("%-6s | ", nomeFormatM);
        }
        System.out.println();

        System.out.println("\n ---- Nomes Femininos (F) ----");
        for (String nome : nomesFemininos){
            String nomeFormatF = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
            System.out.printf("%-6s | ", nomeFormatF);
        }

    }

}

