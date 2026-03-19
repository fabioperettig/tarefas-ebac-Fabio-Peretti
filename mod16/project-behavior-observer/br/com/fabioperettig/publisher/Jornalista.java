package br.com.fabioperettig.publisher;
import br.com.fabioperettig.observer.Observer;
import br.com.fabioperettig.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class Jornalista implements Subject {

    public List<Observer> observerList = new ArrayList<>();
    private String titulo;


    @Override
    public void add(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyAll(String titulo) {
        this.titulo = titulo;
        for (Observer observer : this.observerList){
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return "jornalista{" +
                "titulo='" + titulo + '\'' +
                '}';
    }
}
