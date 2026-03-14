import br.com.fabioperettig.root.Car;
import br.com.fabioperettig.root.Customer;
import br.com.fabioperettig.factory.*;

public class Main {

    public static void main(String[] args) {

        Customer newCustomer01 = new Customer("003", "average");
        Factory factory = getFactory(newCustomer01);
        Car car = factory.create(newCustomer01.getNumRequest());

    }

    private static Factory getFactory(Customer newCustomer){
        switch (newCustomer.getSocialAquisition()){
            case "economic" :
                return new EcominicFactory();
            case "average" :
                return new AverageFactory();
            case "high" :
                return new HighFactory();
            default:
                return null;
        }
    }

}
