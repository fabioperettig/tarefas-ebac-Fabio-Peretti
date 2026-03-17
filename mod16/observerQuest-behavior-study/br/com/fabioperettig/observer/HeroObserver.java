package br.com.fabioperettig.observer;

/**
 * Observer, generally used as Interface,
 * also known as 'Event-Subscriber' or 'Listener';
 */
public interface HeroObserver {

    void getXP(String heroName, int totalXP);

}
