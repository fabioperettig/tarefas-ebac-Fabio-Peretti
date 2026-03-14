package br.com.fabioperettig.factory;

import br.com.fabioperettig.factory.brands.GWM;
import br.com.fabioperettig.factory.brands.Iveco;
import br.com.fabioperettig.factory.brands.Toyota;
import br.com.fabioperettig.factory.brands.Volvo;

public class BusinessFactory extends Factory{

    @Override
    Car retrieveCar(String requestGrade) {
        switch (requestGrade) {

            case "001" :
                return new Volvo(500, "suécia", "diesel", "silver");
            case "002" :
                return new GWM(300, "china", "eletric", "terracota");
            case "003" :
                return new Iveco(450, "itália", "CNG", "navy");
            case "004" :
                return new Toyota(350, "germany", "gasoline", "black");
            default:
                return null;
        }
    }
}
