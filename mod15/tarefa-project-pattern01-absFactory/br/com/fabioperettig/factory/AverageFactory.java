package br.com.fabioperettig.factory;
import br.com.fabioperettig.root.Car;

import br.com.fabioperettig.factory.brand.BYD;
import br.com.fabioperettig.factory.brand.Chevrolet;
import br.com.fabioperettig.factory.brand.Wolksvagen;

public class AverageFactory extends Factory{
    @Override
    Car retrieveCar(String carRequest) {
        switch (carRequest){
            case "001" :
                return new Wolksvagen("german", 800, "gasoline", true);
            case "002" :
                return new Chevrolet("german", 1500, "gasoline", false);
            case "003" :
                return new BYD("china", 1200, "electric", false);
            default :
                return null;
        }
    }
}
