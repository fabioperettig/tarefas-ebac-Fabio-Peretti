import model.Character;
import services.ZombieDAO;

public class Main {
    public static void main(String[] args) {

        ZombieDAO zDAO = new ZombieDAO();

        Character c1 = new Character("Zombie", 1);
        Character c2 = new Character("Chucky", 3);
        Character c3 = new Character("Mummy", 6);
        Character c4 = new Character("Werewolf", 8);
        Character c5 = new Character("Plants", 1);

        zDAO.create(c1);
        zDAO.create(c2);
        zDAO.create(c3);
        zDAO.create(c4);
        zDAO.create(c5);

    }
}
