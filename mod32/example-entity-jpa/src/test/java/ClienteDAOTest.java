import com.fabioperettig.dao.ClientDAO;
import com.fabioperettig.dao.IClientDAO;
import com.fabioperettig.domain.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ClienteDAOTest {

    IClientDAO clientDAO;
    Client client;

    public ClienteDAOTest() {
        clientDAO = new ClientDAO();
    }

    @BeforeEach
    public void setUp() {
        client = createClient();
        Assertions.assertNotNull(client);
    }

    @AfterEach
    public void end() {
        List<Client> list = clientDAO.listAll();
        list.forEach(c -> clientDAO.delete(c));
    }

    @Test
    public void createClientTest() {
        Client clientDB = clientDAO.readById(client.getId());
        Assertions.assertNotNull(clientDB);
        Assertions.assertEquals(client.getId(), clientDB.getId());
        Assertions.assertEquals(client.getName(), clientDB.getName());
    }

    @Test
    public void readClientTest() {
        Client clientDB = clientDAO.readById(client.getId());
        Assertions.assertNotNull(clientDB);
        Assertions.assertEquals(client.getId(), clientDB.getId());
        Assertions.assertEquals(client.getName(), clientDB.getName());
    }

    @Test
    public void updateClientTest() {
        Client clientDB = clientDAO.readById(client.getId());
        Assertions.assertNotNull(clientDB);
        Assertions.assertEquals(client.getId(), clientDB.getId());
        Assertions.assertEquals(client.getName(), clientDB.getName());

        clientDB.setName("Don Lotário");
        Client clientUp = clientDAO.update(clientDB);
        Assertions.assertEquals("Don Lotário", clientUp.getName());
    }

    @Test
    public void deleteClientTest() {
        clientDAO.delete(client);
        Client clientDel = clientDAO.readById(client.getId());
        Assertions.assertNull(clientDel);
    }

    private Client createClient() {
        Client client = new Client();
        client.setName("Fabio");
        client.setCpf(12345678901L);
        client.setMail(client.getName().toLowerCase()+"@mail.com");
        client = clientDAO.create(client);

        return client;
    }
}
