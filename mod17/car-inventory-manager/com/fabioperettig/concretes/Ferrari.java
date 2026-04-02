package com.fabioperettig.concretes;

import com.fabioperettig.factory.Car;
import com.fabioperettig.factory.IDelux;

public class Ferrari extends Car implements IDelux {

    public Ferrari() {super("Ferrari", 2018);}
}
