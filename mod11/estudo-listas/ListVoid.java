import java.util.Random;
import java.util.List;

public class ListVoid {

    static int HP = 100;
    static Random random = new Random();

    public static void main(String[] args) {

        List<Runnable> eventAcampamento = List.of(
                ListVoid::eventoFogo,
                ListVoid::eventoLobo,
                ListVoid::eventoBarulho,
                ListVoid::eventoLua
        );

        // sorteia um int com base no número de elementos da List.
        int evMathSimples = (int)(Math.random() * eventAcampamento.size());

        System.out.println("\n⛺ Acampamento iniciado ⛺");
        System.out.println("---------------------");
        eventAcampamento.get(evMathSimples).run(); //chama o método com base no int sortado
        System.out.println("---------------------");
        evProbability();
        System.out.println("---------------------");

    }

    /**
     * Método que permite manipular a propabilidade escolha
     * de cada evento da List.
     */
    public static void evProbability(){

        double chance = random.nextDouble();

        if (chance < .05) {eventoLua();}
        else if (chance < .40) {eventoFogo();}
        else if (chance < .80) {eventoLobo();}
        else {eventoLua();}

    }

    /**
     * Com o método via new Random(), é possivel chamar o sorteio
     * fora da Main.
     * <br><br>
     * Um FOR via Math.random primitivo só é possível dentro da Main.
     */
    public static void evLoopFOR(){
        for (int i=0;i<10;i++){
            evProbability();
        }
    }


    public static void eventoFogo(){
        System.out.println("Você descansa ao largo de uma fogueira.");
        HP+=10;
        System.out.println("Bem-estar: " + HP);
    }

    public static void eventoLobo(){
        System.out.println("Você escuta lobos uivando ao longe.");
        HP-=3;
        System.out.println("Bem-estar: " + HP);
    }

    public static void eventoBarulho(){
        System.out.println("Um barulho estranho ecoa perto de seu acampamento.");
        HP-=10;
        System.out.println("Bem-estar: " + HP);
    }

    public static void eventoLua(){
        System.out.println("A luz da lua parece reconfortante.");
        HP+=15;
        System.out.println("Bem-estar: " + HP);
    }

}
