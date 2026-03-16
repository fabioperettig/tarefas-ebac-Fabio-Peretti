

public class Main {

    public static void main(String[] args) {
        Worker w1 = new Police();
        Worker w2 = new Paramedic();

        w1.execute();
        w2.execute();
    }

}
