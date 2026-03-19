public class Main {

    public static void main(String[] args) {

        iAppartement service = new AppartementService();
        service.inscriteAppartement(new Appartement(12345, "Appartement Champz"));

    }

}
