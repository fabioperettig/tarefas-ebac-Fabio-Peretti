package com.fabioperettig.factory;

import java.util.ArrayList;
import java.util.List;

public class Garage{

    private List<Car> GarageSUV = new ArrayList<>();
    private List<Car> GarageDelux = new ArrayList<>();

    public<T extends Car & ISUV> void addSUV(T car) {
        GarageSUV.add(car);
        System.out.println("New SUV: " + car.getClass().getSimpleName());
    }

    public<T extends Car & IDelux> void addDelux(T car) {
        GarageDelux.add(car);
        System.out.println("New Deluxe: " + car.getClass().getSimpleName());
    }

    public void getSUV(){
        GarageSUV.stream()
                .map(car -> car.getClass().getSimpleName())
                .forEach(System.out::println);  ;
    }

}
