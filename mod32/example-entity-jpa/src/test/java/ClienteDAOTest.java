import com.fabioperettig.dao.ClientDAO;
import com.fabioperettig.dao.IClientDAO;
import com.fabioperettig.domain.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClienteDAOTest {

    IClientDAO clientDAO;

    public ClienteDAOTest() {
        clientDAO = new ClientDAO();
    }

    @Test
    public void createTest() {
        Client client = createClient();
        Assertions.assertNotNull(client);

        Client clientDB = clientDAO.readById(client.getId());
        Assertions.assertNotNull(clientDB);
        Assertions.assertEquals(client.getId(), clientDB.getId());
        Assertions.assertEquals(client.getName(), clientDB.getName());
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
