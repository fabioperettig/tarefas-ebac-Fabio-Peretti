import br.com.fabioperettig.observer.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject, also known as 'Observable',
 * 'Publisher', 'Dispatcher'
 */
public class Hero {

    String heroName;
    int totalXP = 0;

    private List<HeroObserver> observers = new ArrayList<>();

    //ctor
    public Hero(String heroName) {
        this.heroName = heroName;
    }

    public void addObserver(HeroObserver obs){
        observers.add(obs);
    }

    //Subject NOTIFY ALL
    private void notifyAllObs(){
        for(HeroObserver obs : observers){
            obs.getXP(this.heroName, this.totalXP);

        }
    }

    public void winXP(){
        this.totalXP += 50;
        System.out.println("\n--- Victory! ---");
        notifyAllObs();
    }

}
