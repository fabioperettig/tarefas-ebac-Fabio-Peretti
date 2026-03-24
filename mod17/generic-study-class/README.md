## 🛡️ Java Generics: Warrior Army Project
This project is a practical study of Java Generics, focusing on type safety, code reusability, and clean architecture using Interfaces and Lambda expressions.

## 📝 Concepts Explored
- Type Parameters (<T>): Using placeholders to create flexible and reusable classes;

- Bounded Type Parameters (<T extends Warrior>): Restricting generic types to a specific hierarchy  (Interface);

````java
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
````
- Method References & Lambdas: Implementing clean iteration over lists using Warrior::attack and warrior -> { ... };

- Type Safety: Ensuring that an Alliance army cannot accidentally include Horde units at compile time.

## 🛠️ Project Structure
The project simulates a battle system with two main factions: Alliance and Horde. Both implement a common interface to ensure they follow the same combat rules.

**1. The Contract (Warrior.java)** An interface defining the core behaviors of any unit.

**2. The Factions**
Alliance: Represents noble warriors (e.g., Arthas).<br>
Horde: Represents tribal warriors (e.g., Bolg).

````java
public interface Warrior {
    void attack();
    void defense();
    void group();
}

------------------------------

import com.fabioperettig.GenericStudy.Warrior;

public class Alliance implements Warrior {

    private String name;

    public Alliance(String name) {
        this.name = name;
    }

    @Override
    public void attack() {
        System.out.printf("Warrior %s from Alliance, attacks",name);
    }

    @Override
    public void defense() {...}

    @Override
    public void group() {...}

}

public class Horde implements Warrior {...}
````

## 🚀 How it works
By using <T extends Warrior>, the Army class is "smart" enough to know that any object inside the list has the attack() method, even if it doesn't know the specific faction yet.

````java
public static void main(String[] args) {

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
````
