package br.com.fabioperettig.factory;

import br.com.fabioperettig.factory.brands.BYD;
import br.com.fabioperettig.factory.brands.Chevrolet;
import br.com.fabioperettig.factory.brands.Lecar;
import br.com.fabioperettig.factory.brands.Toyota;

public class PersonalFactory extends Factory{

    @Override
    Car retrieveCar(String requestGrade) {
        switch (requestGrade){

            case "001" :
                return new Chevrolet(300, "germany", "gasoline", "dark silver");
            case "002" :
                return new Toyota(280, "japan", "gasoline", "white");
            case "003" :
                return new BYD(250, "china", "eletric", "red");
            case "004" :
                return new Lecar(275, "brazil", "eletric", "blue");
            default:
                return null;
        }
    }
}
