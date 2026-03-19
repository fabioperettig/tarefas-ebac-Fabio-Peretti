

public class Apartment {

    private int serialNumber;
    private String adress;

    //ctor
    public Apartment(int serialNumber, String adress) {
        this.serialNumber = serialNumber;
        this.adress = adress;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
