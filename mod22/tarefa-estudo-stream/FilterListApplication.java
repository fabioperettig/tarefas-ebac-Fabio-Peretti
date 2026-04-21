import java.util.List;
import java.util.stream.Stream;

public class FilterListApplication {

    public static void main(String[] args) {

        List<Pessoa> pessoaList = new Pessoa().pessoaList();

        System.out.println("\n--- VIA STREAM PURO ---\n");

        Stream<String> streamFiltro = pessoaList.stream()
                .filter(p -> p.getSexo().equals("Feminino"))
                .map(p -> p.getNome() + " – " + p.getSexo());

        streamFiltro.forEach(System.out::println);

        System.out.println("\n--- VIA STREAM PARA LISTA ---\n");

        List<Pessoa> listaFeminina = pessoaList.stream()
                .filter(pessoa -> pessoa.getSexo().equals("Feminino"))
                .map(pessoa -> new Pessoa(pessoa.getNome(), pessoa.getSexo()))
                .toList();

        listaFeminina.forEach(System.out::println);

        /// Erro ao tentar chamar novamente a streamFiltro
        try {
            long totalStream = streamFiltro.count();
        } catch (IllegalStateException e) {
            throw new StreamException("Ciclo de vida da Stream já encerrada.");
        } finally {
            long totalStream = listaFeminina.stream().count();
            System.out.println("Número total: "+totalStream);
        }
    }

}
