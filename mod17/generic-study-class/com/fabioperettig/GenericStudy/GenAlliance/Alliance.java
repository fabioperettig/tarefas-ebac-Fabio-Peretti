package com.fabioperettig.GenericStudy.GenAlliance;

import com.fabioperettig.GenericStudy.Warrior;

public class Alliance implements Warrior {

    private String name;

    public Alliance(String name) {
        this.name = name;
    }

    @Override
    public void attack() {
        System.out.printf("Warrior %s from Alliance, attacks",name);
    }

    @Override
    public void defense() {
        System.out.printf("Warrior %s from Alliance, defends",name);
    }

    @Override
    public void group() {
        System.out.printf("Warrior %s joined to the army.",name);
    }

}
