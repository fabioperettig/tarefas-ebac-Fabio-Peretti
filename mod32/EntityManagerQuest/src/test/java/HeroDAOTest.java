import com.fabioperettig.dao.HeroDAO;
import com.fabioperettig.domain.Hero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeroDAOTest {

    HeroDAO heroDAO;

    public HeroDAOTest() {
        heroDAO = new HeroDAO();
    }

    @Test
    public void createHeroTest(){
        Hero hero1 = new Hero("Algalord", "Guerreiro");

        heroDAO.create(hero1);
        Assertions.assertNotNull(hero1);
        Assertions.assertSame("Algalord", hero1.getName());

    }

    @Test
    public void readHeroTest() {
        Hero hero2 = new Hero("Kadaj", "Mago");

        heroDAO.create(hero2);
        Assertions.assertNotNull(hero2);

        Hero heroDB = heroDAO.readById(hero2.getId());
        Assertions.assertNotNull(heroDB);
        Assertions.assertEquals(hero2.getId(), heroDB.getId());
        Assertions.assertEquals(hero2.getName(), heroDB.getName());
    }

    @Test
    public void updateHeroTest() {
        Hero hero3 = new Hero("Fabiolione", "Guerreiro");

        heroDAO.create(hero3);
        Assertions.assertNotNull(hero3);

        Hero heroDB = heroDAO.readById(hero3.getId());
        Assertions.assertNotNull(heroDB);
        Assertions.assertEquals(hero3.getId(), heroDB.getId());
        Assertions.assertEquals(hero3.getName(), heroDB.getName());

        heroDB.setName("Fabio Lione");

        Hero heroUp = heroDAO.update(heroDB);

        Assertions.assertEquals("Fabio Lione", heroUp.getName());

    }

    @Test
    public void deleteClientTest() {
        Hero hero4 = new Hero("Nori", "Ranger");

        heroDAO.create(hero4);
        Assertions.assertNotNull(hero4);

        heroDAO.delete(hero4);
        Hero heroDel = heroDAO.readById(hero4.getId());
        Assertions.assertNull(heroDel);
    }
}
