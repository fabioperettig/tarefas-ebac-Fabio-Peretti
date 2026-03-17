import br.com.fabioperettig.observer.Achievements;
import br.com.fabioperettig.observer.Progressbar;

public class Main {

    public static void main(String[] args) {
        Hero algalord = new Hero("Algalord");

        //observers
        Achievements achievement = new Achievements();
        Progressbar progressbar = new Progressbar();

        algalord.addObserver(achievement);
        algalord.addObserver(progressbar);

        for (int i=0; i<5; i++){
            algalord.winXP();
        }

    }

}
