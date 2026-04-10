package com.fabioperettig.rpg.entities;

import com.fabioperettig.rpg.annotations.MagicItem;
import com.fabioperettig.rpg.annotations.Skill;

public class Hero {

    private int Strength;
    private int Constitution;
    private int Mana = 40;

    public int getStrength() {
        return Strength;
    }

    public int getConstitution() {
        return Constitution;
    }

    public int getMana() {
        return Mana;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    public void setConstitution(int constitution) {
        Constitution = constitution;
    }

    public void setMana(int mana) {
        Mana = mana;
    }

    @MagicItem(name = "Excalibur", atkBonus = 15)
    private String sword;

    @MagicItem(name = "Oak Shield", defBonus = 20)
    private String shield;

    @MagicItem(name = "Dark ring", cursed = true)
    private String accessory;

    @Skill(name = "Fury slash", manaCost = 10, baseDamage = 30)
    public void attack(){
        System.out.println("The hero attacks vigorously!");
    }

}
