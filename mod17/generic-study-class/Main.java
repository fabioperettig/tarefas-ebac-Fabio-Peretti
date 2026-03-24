import com.fabioperettig.GenericStudy.Army;
import com.fabioperettig.GenericStudy.GenAlliance.Alliance;
import com.fabioperettig.GenericStudy.GenHorde.Horde;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*GenericClass t1 = new GenericClass<>(1);
        System.out.println(t1.getData());*/

        Alliance h1 = new Alliance("Arthas");
        Horde o1 = new Horde("Bolg");

        List<Alliance> allianceFirstArmy = new ArrayList<>();
        allianceFirstArmy.add(h1);
        allianceFirstArmy.add(new Alliance("Horizon"));
        allianceFirstArmy.add(new Alliance("Kalel"));
        allianceFirstArmy.add(new Alliance("Phelkan"));

        Army.form(allianceFirstArmy);

        List<Horde> hordeTankers = new ArrayList<>();
        hordeTankers.add(o1);
        hordeTankers.add(new Horde("Azog"));
        hordeTankers.add(new Horde("Fyror"));
        hordeTankers.add(new Horde("Zagael"));

        Army.form(hordeTankers);
        Army.attack(allianceFirstArmy);
    }

}
