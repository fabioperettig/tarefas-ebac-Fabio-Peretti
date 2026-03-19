import br.com.fabioperettig.observer.*;
import br.com.fabioperettig.publisher.Jornalista;

public class Main {

    public static void main(String[] args) {

        Jornalista jornalista = new Jornalista();
        jornalista.add(new TV());
        jornalista.notifyAll("aula feita");
    }

}
