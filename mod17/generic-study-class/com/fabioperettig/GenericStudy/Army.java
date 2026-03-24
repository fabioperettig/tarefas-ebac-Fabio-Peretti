package com.fabioperettig.GenericStudy;

import java.util.List;

public class Army <T extends Warrior> {

    public static <T extends Warrior> void form (List<T> list){
        list.forEach(warrior -> {
            warrior.group();
            System.out.println();
        });
    }

    public static <T extends Warrior> void attack (List<T> list){
        list.forEach(Warrior::attack);
        System.out.println();
    }

}
