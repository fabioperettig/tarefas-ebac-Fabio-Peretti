# 🎓 Pattern de Criação – Abstract Factory

Este projeto é uma implementação prática do padrão de Patterns de Criação **Abstract Factory** em Java. O objetivo é simular um sistema de fabricação de carros, com base no perfil e poder aquisitivo do cliente. O sistema utiliza uma hierarquia de fábricas para instanciar diferentes categorias de carros **(`Economic, Average, High`)** sem que o cliente precise conhecer as classes concretas.

<br>
Factory: Classe
Customer: Representa o usuário e seu nível de orçamento, servindo de gatilho para a escolha da fábrica.


## 🧩 Estrutura

- **Classe Principal (`abstract`)** → classe abstrata base com atributos como horsePower e fuelSource, que define a interface para os objetos que a fábrica cria, com um método nativo de descrição de objeto instanciado.

````
public abstract class Car {

    private String flag;
    private int horsePower;
    private String fuelSource;
    private boolean insured;

    //ctor
    public Car(String flag, int horsePower, String fuelSource, boolean insured) {
        this.flag = flag;
        this.horsePower = horsePower;
        this.fuelSource = fuelSource;
        this.insured = insured;
    }

    public void describeCar(){
        System.out.printf("Car:[%s flag | %d horse power | %s | %b]\n",flag,horsePower,fuelSource, insured);
    }
}
````
<br>

- **Factory Principal (`abstract`)** → declara os métodos/fluxo de criação (create e retrieveCar), sem tirar a autonomia de implementação para as subclasses **(`EconomicFactory, AverageFactory, HighFactory`)**.

````
public abstract class Factory {

    public Car create(String carRequest) {
        Car car = retrieveCar(carRequest);
        car = prepareCar(car);
        return car;
    }

    private Car prepareCar(Car car){
        car.describeCar();
        return car;
    }

    abstract Car retrieveCar(String carRequest);

}
````
<br>

- **Classe Customer (`abstract`)** → representa o usuário e seu nível de orçamento, servindo de gatilho para a escolha da fábrica.

````
package br.com.fabioperettig.root;

public class Customer {

    private String numRequest;
    private String socialAquisition;


    public Customer(String numRequest, String socialAquisition) {
        this.numRequest = numRequest;
        this.socialAquisition = socialAquisition;
    }

    public String getNumRequest(){
        return numRequest;
    }

    public String getSocialAquisition(){
        return socialAquisition;
    }
}

````

<br>

- **Factory Principal (`abstract`)** → exemplo de uma das Classes de implementação da lógica de negócio específica.

````
import br.com.fabioperettig.factory.brand.*;

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
````
<br>

## 🖥️ Classe Main

````
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

````

---

**👨‍💻 Fabio Peretti Guimarães**  
📘 Projeto EBAC – Módulo: *Padrões de Projeto 001*  
🗓️ Março de 2026