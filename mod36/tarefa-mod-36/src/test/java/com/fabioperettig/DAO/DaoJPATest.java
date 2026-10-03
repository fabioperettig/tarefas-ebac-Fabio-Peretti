package com.fabioperettig.DAO;


import com.fabioperettig.domain.ClienteJPA;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DaoJPATest {

    private final IGenericDAO<ClienteJPA, Long> daoJPA = new DaoJPA();

    private final List<ClienteJPA> clientesCriados = new ArrayList<>();

    @AfterEach
    public void removerClientes() {
        for (ClienteJPA c : clientesCriados) {
            ClienteJPA encontrado = daoJPA.buscarEntidadePorID(c.getId());
            if (encontrado != null) {
                daoJPA.deletarEntidade(encontrado);
            }
        }
    }

    @Test
    public void cadastrarEntidadeTeste() {

        ClienteJPA cliente = new ClienteJPA();
        cliente.setNome("Fabio Peretti");
        cliente.setCpf(1234567890L);
        cliente.setEmail("fabioperettig@mail.com");

        daoJPA.cadastrarEntidade(cliente);
        clientesCriados.add(cliente);

        Assertions.assertNotNull(cliente);
        Assertions.assertEquals(1234567890L,cliente.getCpf());
    }

    @Test
    public void buscarEntidadeTeste() {

        ClienteJPA cliente = new ClienteJPA();
        cliente.setNome("Fabio Peretti");
        cliente.setCpf(1234567890L);
        cliente.setEmail("fabioperettig@mail.com");

        daoJPA.cadastrarEntidade(cliente);
        clientesCriados.add(cliente);
        Assertions.assertNotNull(cliente);

        ClienteJPA cResult = daoJPA.buscarEntidadePorID(cliente.getId());
        Assertions.assertNotNull(cResult);
        Assertions.assertEquals(cResult.getNome(), cliente.getNome());
    }

    @Test
    public void alterarEntidadeTeste() {

        ClienteJPA cliente = new ClienteJPA();
        cliente.setNome("Fabio peretti");
        cliente.setCpf(123456780L);
        cliente.setEmail("fabioperettig@mail.com");

        daoJPA.cadastrarEntidade(cliente);
        clientesCriados.add(cliente);
        Assertions.assertNotNull(cliente);

        cliente.setNome("Fabio Peretti");
        cliente.setCpf(1234567890L);
        daoJPA.alterarEntidade(cliente);

        Assertions.assertSame("Fabio Peretti", cliente.getNome());
        Assertions.assertEquals(1234567890L, cliente.getCpf());
    }

    @Test
    public void deletarEntidadeTeste() {

        ClienteJPA cliente = new ClienteJPA();
        cliente.setNome("Fabio peretti");
        cliente.setCpf(123456780L);
        cliente.setEmail("fabioperettig@mail.com");

        daoJPA.cadastrarEntidade(cliente);
        clientesCriados.add(cliente);
        Assertions.assertNotNull(cliente);

        daoJPA.deletarEntidade(cliente);

        ClienteJPA cDelete = daoJPA.buscarEntidadePorID(cliente.getId());
        Assertions.assertNull(cDelete);
    }

    @Test
    public void buscarTodosTeste() {

        List<ClienteJPA> jpaList = new ArrayList<>();

        ClienteJPA cliente1 = new ClienteJPA();
        cliente1.setNome("Fabio Peretti");
        cliente1.setCpf(1234567890L);
        cliente1.setEmail("fabioperettig@mail.com");

        ClienteJPA cliente2 = new ClienteJPA();
        cliente2.setNome("Don Lotário");
        cliente2.setCpf(2345678901L);
        cliente2.setEmail("donltr@mail.com");

        ClienteJPA cliente3 = new ClienteJPA();
        cliente3.setNome("Laura Caixão");
        cliente3.setCpf(3456789012L);
        cliente3.setEmail("lauracx@mail.com");

        daoJPA.cadastrarEntidade(cliente1);
        daoJPA.cadastrarEntidade(cliente2);
        daoJPA.cadastrarEntidade(cliente3);

        jpaList.add(cliente1);
        jpaList.add(cliente2);
        jpaList.add(cliente3);

        ///lista AfterEach
        clientesCriados.add(cliente1);
        clientesCriados.add(cliente2);
        clientesCriados.add(cliente3);

        Assertions.assertNotNull(jpaList);
        Assertions.assertEquals(3, jpaList.size());
        Assertions.assertSame(cliente2, jpaList.get(1));
    }
}
