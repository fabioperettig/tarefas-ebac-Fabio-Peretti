import com.fabioperettig.concretes.*;
import com.fabioperettig.factory.FactoryCar;
import com.fabioperettig.factory.Garage;


public class Main {

    public static void main(String[] args) {

        FactoryCar car = new FactoryCar();
        Garage garageCar = new Garage();


        Jeep jeepCompass = new Jeep();///ULTRAPASSADO SEM FACTORY

        Jeep jeepRenegade = car.factory(Jeep.class);///MODERNO COM FACTORY
        Ferrari ferrariSpider = car.factory(Ferrari.class);

        //ARCHMotorcycle krgt = car.factory(ARCHMotorcycle.class); ///BARRADO PELA FACTORY


        garageCar.addSUV(jeepRenegade);
        garageCar.addSUV(jeepCompass);
        //garageCar.addSUV(ferrariSpider);//barrado na lista de SUV
        garageCar.addDelux(ferrariSpider);
        garageCar.addDelux(new Ferrari());

        garageCar.getSUV();

    }

}
