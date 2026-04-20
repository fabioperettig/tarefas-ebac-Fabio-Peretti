import java.util.List;
import java.util.Objects;

public class Monsters {

    private String id;
    private String name;
    private int atk;
    private int def;


    public Monsters() {/*empty ctor*/}

    public Monsters(String id, String name, int atk, int def) {
        this.id = id;
        this.name = name;
        this.atk = atk;
        this.def = def;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public List<Monsters> monstersList(){
        Monsters m0 = new Monsters("m0", "Zombie", 3,0);
        Monsters m1 = new Monsters("m1", "Zombie", 5,0);
        Monsters m2 = new Monsters("m2", "Chuckie", 15,2);
        Monsters m3 = new Monsters("m3", "Mummy", 18,6);
        Monsters m4 = new Monsters("m4", "Werewolf", 20,10);
        Monsters m5 = new Monsters("m5", "Chainsaw", 25,25);
        Monsters m6 = new Monsters("m6", "Clone Bulb", 3,0);

        return List.of(m0,m1,m2,m3,m4,m5,m6);
    }

    @Override
    public String toString() {
        return "Monsters{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", atk=" + atk +
                ", def=" + def +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Monsters monsters = (Monsters) o;
        return Objects.equals(id, monsters.id) && Objects.equals(name, monsters.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
