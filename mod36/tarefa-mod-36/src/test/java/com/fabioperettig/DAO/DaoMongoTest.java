package com.fabioperettig.DAO;

import com.fabioperettig.domain.ClienteMorphia;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class DaoMongoTest {

    private final IGenericDAO<ClienteMorphia, ObjectId> daoMongo = new DaoMongo();
    private final List<ClienteMorphia> clientesCriados = new ArrayList<>();

    @AfterEach
    public void removerClientes() {
        for (ClienteMorphia cM : clientesCriados) {
            ClienteMorphia encontrado = daoMongo.buscarEntidadePorID(cM.getId());
            if (encontrado != null) {
                daoMongo.deletarEntidade(encontrado);
            }
        }
    }

    @Test
    public void cadastrarEntidadeTeste() {

        ClienteMorphia cliente = new ClienteMorphia();
        cliente.setNome("Fabio Peretti");
        cliente.setCpf(1234567890L);
        cliente.setEmail("fabioperettig@mail.com");

        daoMongo.cadastrarEntidade(cliente);
        clientesCriados.add(cliente);

        Assertions.assertNotNull(cliente.getId());

        ClienteMorphia cSalvo = daoMongo.buscarEntidadePorID(cliente.getId());

        Assertions.assertNotNull(cSalvo);
        Assertions.assertEquals(cliente.getNome(), cSalvo.getNome());
        Assertions.assertEquals(cliente.getCpf(), cSalvo.getCpf());
        Assertions.assertEquals(cliente.getEmail(), cSalvo.getEmail());
    }

    @Test
    public void buscarEntidadeTest() {

        ClienteMorphia cliente = new ClienteMorphia();
        cliente.setNome("Fabio Peretti");
        cliente.setCpf(1234567890L);
        cliente.setEmail("fabioperettig@mail.com");

        daoMongo.cadastrarEntidade(cliente);
        clientesCriados.add(cliente);
        Assertions.assertNotNull(cliente);

        ClienteMorphia cResult = daoMongo.buscarEntidadePorID(cliente.getId());
        Assertions.assertNotNull(cResult);
        Assertions.assertEquals(cResult.getNome(), cliente.getNome());
    }

    @Test
    public void alterarEntidadeTeste() {

        ClienteMorphia cliente = new ClienteMorphia();
        cliente.setNome("Fabiopereti");
        cliente.setCpf(12345670L);
        cliente.setEmail("fabioperettig@mail.com");

        daoMongo.cadastrarEntidade(cliente);
        clientesCriados.add(cliente);
        Assertions.assertNotNull(cliente);

        cliente.setNome("Fabio Peretti");
        cliente.setCpf(1234567890L);
        daoMongo.alterarEntidade(cliente);

        ClienteMorphia cAlterado = daoMongo.buscarEntidadePorID(cliente.getId());

        Assertions.assertNotNull(cAlterado);
        Assertions.assertEquals("Fabio Peretti", cAlterado.getNome());
        Assertions.assertEquals(1234567890L, cAlterado.getCpf());
    }

    @Test
    public void deletarEntidadeTeste() {

        ClienteMorphia cliente = new ClienteMorphia();
        cliente.setNome("Fabio Peretti");
        cliente.setCpf(1234567890L);
        cliente.setEmail("fabioperettig@mail.com");

        daoMongo.cadastrarEntidade(cliente);
        clientesCriados.add(cliente);
        Assertions.assertNotNull(cliente);

        daoMongo.deletarEntidade(cliente);

        ClienteMorphia cDelete = daoMongo.buscarEntidadePorID(cliente.getId());
        Assertions.assertNull(cDelete);
    }

    @Test
    public void buscarTodosTeste() {

        ClienteMorphia cliente1 = new ClienteMorphia();
        cliente1.setNome("Fabio Peretti");
        cliente1.setCpf(1234567890L);
        cliente1.setEmail("fabioperettig@mail.com");

        ClienteMorphia cliente2 = new ClienteMorphia();
        cliente2.setNome("Don Lotário");
        cliente2.setCpf(2345678901L);
        cliente2.setEmail("donltr@mail.com");

        ClienteMorphia cliente3 = new ClienteMorphia();
        cliente3.setNome("Laura Caixão");
        cliente3.setCpf(3456789012L);
        cliente3.setEmail("lauracx@mail.com");

        daoMongo.cadastrarEntidade(cliente1);
        clientesCriados.add(cliente1);

        daoMongo.cadastrarEntidade(cliente2);
        clientesCriados.add(cliente2);

        daoMongo.cadastrarEntidade(cliente3);
        clientesCriados.add(cliente3);

        Collection<ClienteMorphia> listaBusca = daoMongo.buscarTodos();

        for (ClienteMorphia criado : clientesCriados) {
            Assertions.assertTrue(
                    listaBusca.stream()
                            .anyMatch(c -> c.getId().equals(criado.getId()))
            );
        }
    }
}
