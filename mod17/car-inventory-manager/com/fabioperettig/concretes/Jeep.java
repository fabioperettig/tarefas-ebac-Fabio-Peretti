package com.fabioperettig.concretes;

import com.fabioperettig.factory.Car;
import com.fabioperettig.factory.ISUV;

public class Jeep extends Car implements ISUV {

    public Jeep() {super("Jeep", 2010);}

}
