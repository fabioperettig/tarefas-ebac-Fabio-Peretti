

public class Main {

    public static void main(String[] args) {

        if(User.class.isAnnotationPresent(Tabela.class)){

            Tabela tabela = User.class.getAnnotation(Tabela.class);
            System.out.printf("nome: %s | id: %d.", tabela.nome(), tabela.id());

        }

    }

}
