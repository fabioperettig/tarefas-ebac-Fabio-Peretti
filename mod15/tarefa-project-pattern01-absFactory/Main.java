import br.com.fabioperettig.root.Car;
import br.com.fabioperettig.root.Customer;
import br.com.fabioperettig.factory.*;

public class Main {

    public static void main(String[] args) {

        Customer newCustomer = new Customer(001, "economic", true);
        Factory factory = getFactory(newCustomer);


    }

}
