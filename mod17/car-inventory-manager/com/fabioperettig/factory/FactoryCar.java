package com.fabioperettig.factory;

public class FactoryCar {

    public <T extends Car> T factory(Class<T> cars){
        try{
            return cars.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Error in car manufacturing.", e);
        }
    }

}
