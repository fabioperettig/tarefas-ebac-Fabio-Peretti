package com.fabioperettig.GenericStudy.GenHorde;

import com.fabioperettig.GenericStudy.Warrior;

public class Horde implements Warrior {

    private String name;

    public Horde(String name) {
        this.name = name;
    }

    @Override
    public void attack() {
        System.out.printf("Warrior %s from Horde, attacks",name);
    }

    @Override
    public void defense() {
        System.out.printf("Warrior %s from Horde, defends",name);
    }

    @Override
    public void group() {
        System.out.printf("Warrior %s joined to the army.",name);
    }
}
