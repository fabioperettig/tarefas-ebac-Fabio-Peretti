package br.com.fabioperettig.factory;

import br.com.fabioperettig.factory.brand.BYD;
import br.com.fabioperettig.root.Car;

public class HighFactory extends Factory{
    @Override
    Car retrieveCar(String carRequest) {
        switch (carRequest){
            case "001" :
                return new BYD("china", 500, "electric", true);
            case "002" :
                return new BYD("china", 650, "electric", true);
            case "003" :
                return new BYD("china", 550, "electric", true);
            default:
                return null;
        }
    }
}
