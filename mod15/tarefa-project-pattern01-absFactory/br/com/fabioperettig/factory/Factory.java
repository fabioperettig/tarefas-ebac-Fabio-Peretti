package br.com.fabioperettig.factory;

import br.com.fabioperettig.root.*;

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