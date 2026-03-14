import br.com.fabioperettig.factory.*;

public class Main {

    public static void main(String[] args) {

        Customer newCustomer = new Customer("002", false);
        Factory factory = getFactory(newCustomer);
        Car car = factory.create(newCustomer.getGradeRequest());
        car.startEngine();
        car.mechanicCheck();

    }

    private static Factory getFactory(Customer newCustomer) {
        if (newCustomer.HasBusinessContract()){
            return new BusinessFactory();
        } else {
            return new PersonalFactory();
        }
    }

}
