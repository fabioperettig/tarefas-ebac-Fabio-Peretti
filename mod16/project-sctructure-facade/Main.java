public class Main {

    public static void main(String[] args) {

        iAppartement service = new AppartementService();
        service.inscrireAppartement(new Appartement(12345, "Appartement Champz"));

    }

}
