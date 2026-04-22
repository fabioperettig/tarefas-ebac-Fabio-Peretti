import com.fabioperettig.user.Pessoa;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Pessoa> pessoaList = new Pessoa().pessoaList();

        List<String> femList = pessoaList.stream()
                .filter(sexo -> sexo.getSexo().equals("Feminino"))
                .map(pessoa -> pessoa.getNome() + " | " + pessoa.getSexo())
                .toList();

        femList.forEach(System.out::println);

    }

}
