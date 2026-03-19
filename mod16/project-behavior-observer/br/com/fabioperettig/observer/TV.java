package br.com.fabioperettig.observer;

public class TV implements Observer{
    @Override
    public void update(Subject subject) {
        System.out.println("Telejornal: " + subject.toString());
    }
}
