package br.com.fabioperettig.root;

public abstract class Car {

    private String flag;
    private int horsePower;
    private String fuelSource;
    private boolean insured;

    //ctor
    public Car(String flag, int horsePower, String fuelSource, boolean insured) {
        this.flag = flag;
        this.horsePower = horsePower;
        this.fuelSource = fuelSource;
        this.insured = insured;
    }

    public void describeCar(){
        System.out.printf("Car:[%s flag | %d horse power | %s | %b]\n",flag,horsePower,fuelSource, insured);
    }

}
