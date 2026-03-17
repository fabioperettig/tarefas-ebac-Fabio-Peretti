package br.com.fabioperettig.observer;

/**
 * Concrete Observer
 */
public class Achievements implements HeroObserver{
    @Override
    public void getXP(String heroName, int totalXP) {
        switch (totalXP){
            case 100 :
                System.out.printf("[NOTIFICATION] %s reached the level Apprendice\n",heroName);
            case 250 :
                System.out.printf("[NOTIFICATION] %s reached the level Adept\n",heroName);
            case 450:
                System.out.printf("[NOTIFICATION] %s reached the level Veteran\n",heroName);
            case 780:
                System.out.printf("[NOTIFICATION] %s reached the level Expert\n",heroName);
            case 1000:
                System.out.printf("[NOTIFICATION] %s reached the level Master\n",heroName);
            default:
                return;
        }
    }
}