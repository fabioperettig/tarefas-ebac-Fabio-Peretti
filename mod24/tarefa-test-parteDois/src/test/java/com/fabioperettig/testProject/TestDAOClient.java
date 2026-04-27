package com.fabioperettig.testProject;

import com.fabioperettig.testProject.dao.ClienteMockDAO;
import com.fabioperettig.testProject.dao.ICliente;
import com.fabioperettig.testProject.model.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestDAOClient {

    private ICliente iCliente;

    @BeforeEach
    void setup(){
        iCliente = new ClienteMockDAO();
    }

    @Test
    public void testeDAOCREATEClienteIDAutomatico(){
        Cliente cliente1 = new Cliente("cliente1", "cliente1@mail");
        Cliente cliente2 = new Cliente("cliente2", "cliente1@mail");
        Cliente cliente3 = new Cliente("cliente3", "cliente1@mail");

        iCliente.create(cliente1);
        iCliente.create(cliente2);

        Assertions.assertEquals(2, cliente2.getId());
    }

    @Test
    public void testeDAOREADCliente() {
        Cliente cliente = new Cliente("testeREAD", "email@mail.com");
        iCliente.create(cliente);

        Optional<Cliente> resultado = iCliente.read(cliente.getId());

        Assertions.assertTrue(resultado.isPresent());
        Assertions.assertEquals("testeREAD", resultado.get().getNome());
    }

    @Test
    public void testeDELETEDAOCliente(){
        Cliente cliente = new Cliente("NomeLista1", "email1@mail.com");
        Cliente clienteDEL = new Cliente("NomeLista2", "email2@mail.com");
        iCliente.create(cliente);
        iCliente.create(clienteDEL);

        iCliente.delete(clienteDEL.getId());
        Optional<Cliente> deletar = iCliente.read(clienteDEL.getId());

        Assertions.assertTrue(deletar.isEmpty());
    }

    @Test
    public void testeDAOListarCliente(){

        Cliente cliente1 = new Cliente("Cliente1", "cliente1@mail");
        Cliente cliente2 = new Cliente("Cliente2", "cliente1@mail");

        iCliente.create(cliente1);
        iCliente.create(cliente2);

        List<Cliente> result = iCliente.findAll();

        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void testeDAOListaInicialVazia(){
        List<Cliente> listaVazia = iCliente.findAll();

        Assertions.assertTrue(listaVazia.isEmpty());
    }
}
