public class Main {

    public static void main(String[] args){

        Hero h = new Hero();


        try {
            GameEngine.processAnnotations(h);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
