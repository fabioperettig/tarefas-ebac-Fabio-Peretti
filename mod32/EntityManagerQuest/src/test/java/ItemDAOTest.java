import com.fabioperettig.dao.ItemDAO;
import com.fabioperettig.domain.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemDAOTest {

    ItemDAO itemDAO;

    public ItemDAOTest() {
        itemDAO = new ItemDAO();
    }

    @Test
    public void createItemTest(){
        Item item1 = new Item();

        item1.setName("Espada de Madeira");
        item1.setType("Espada");
        item1.setRarity(1);
        item1.setDamage(6);

        itemDAO.create(item1);
        Assertions.assertNotNull(item1);
        Assertions.assertSame("Espada de Madeira", item1.getName());

    }

    @Test
    public void readItemTest() {
        Item item2 = new Item();

        item2.setName("Arco de Boldo");
        item2.setType("Arco");
        item2.setRarity(1);
        item2.setDamage(4);

        itemDAO.create(item2);
        Assertions.assertNotNull(item2);

        Item itemDB = itemDAO.readById(item2.getId());
        Assertions.assertNotNull(itemDB);
        Assertions.assertEquals(item2.getId(), itemDB.getId());
        Assertions.assertEquals(item2.getName(), itemDB.getName());
    }

    @Test
    public void updateItemTest() {
        Item item3 = new Item();

        item3.setName("Espada de Esgrima");
        item3.setType("Espada");
        item3.setRarity(3);
        item3.setDamage(0);

        itemDAO.create(item3);
        Assertions.assertNotNull(item3);

        Item itemDB = itemDAO.readById(item3.getId());
        Assertions.assertNotNull(itemDB);
        Assertions.assertEquals(item3.getId(), itemDB.getId());
        Assertions.assertEquals(item3.getName(), itemDB.getName());

        itemDB.setName("Sabre de Esgrima");
        itemDB.setDamage(10);

        Item itemUp = itemDAO.update(itemDB);

        Assertions.assertEquals("Sabre de Esgrima", itemUp.getName());
        Assertions.assertEquals(10, itemUp.getDamage());

    }

    @Test
    public void deleteClientTest() {
        Item item4 = new Item();

        item4.setName("Espada de Madeira");
        item4.setType("Espada");
        item4.setRarity(1);
        item4.setDamage(6);

        itemDAO.create(item4);
        Assertions.assertNotNull(item4);

        itemDAO.delete(item4);
        Item itemDel = itemDAO.readById(item4.getId());
        Assertions.assertNull(itemDel);
    }
}
