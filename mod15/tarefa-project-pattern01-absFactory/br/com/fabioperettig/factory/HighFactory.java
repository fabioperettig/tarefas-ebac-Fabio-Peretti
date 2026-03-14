package br.com.fabioperettig.factory;

import br.com.fabioperettig.factory.brand.BMW;
import br.com.fabioperettig.factory.brand.BYD;
import br.com.fabioperettig.factory.brand.Iveco;
import br.com.fabioperettig.root.Car;

public class HighFactory extends Factory{
    @Override
    Car retrieveCar(String carRequest) {
        switch (carRequest){
            case "001" :
                return new BYD("china", 2500, "electric", true);
            case "002" :
                return new BMW("german", 1800, "gasoline", true);
            case "003" :
                return new Iveco("italy", 1750, "CNG", true);
            default:
                return null;
        }
    }
}
