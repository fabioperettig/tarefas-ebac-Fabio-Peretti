public class Appartement {

    private int inscription;
    private String adresse;

    //ctor
    public Appartement(int inscription, String adresse) {
        this.inscription = inscription;
        this.adresse = adresse;
    }

    public int getInscription() {
        return inscription;
    }

    public void setInscription(int inscription) {
        this.inscription = inscription;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
