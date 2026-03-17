package br.com.fabioperettig.observer;

/**
 * Concrete Observer
 */
public class Progressbar implements HeroObserver{
    @Override
    public void getXP(String heroName, int totalXP) {
        System.out.printf("%s agora está com um total de %d XP!",heroName,totalXP);
    }
}
