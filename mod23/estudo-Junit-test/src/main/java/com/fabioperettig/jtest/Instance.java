package com.fabioperettig.jtest;

public class Instance {

    User userA = new User("Ava", 10);
    User userB = new User("Leon", 6);
    User userC = new User("Jean", 13);
    User userD = new User("Marta", 29);


    public User getUserA() {
        return userA;
    }

    public User getUserB() {
        return userB;
    }

    public User getUserC() {
        return userC;
    }

    public User getUserD() {
        return userD;
    }

    public double averagelvl(){
        double soma = userA.getLevel() + userB.getLevel() + userC.getLevel() + userD.getLevel();
        return soma/4;
    }

}
