package br.com.fabioperettig.factory;
import br.com.fabioperettig.root.Car;

import br.com.fabioperettig.factory.brand.Wolksvagen;
import br.com.fabioperettig.factory.brand.Lecar;
import br.com.fabioperettig.factory.brand.Chevrolet;

public class EcominicFactory extends Factory{
    @Override
    Car retrieveCar(String carRequest) {
        switch (carRequest){
            case "001":
                return new Wolksvagen("german", 180, "gasoline", false);
            case "002" :
                return new Lecar("brazil", 260, "electric", false);
            case "003" :
                return new Chevrolet("german", 320, "gasoline", false);
            default :
                return null;
        }
    }
}
