package com.fabioperettig.test;

import com.fabioperettig.Cliente;
import com.fabioperettig.controller.ClienteController;
import com.fabioperettig.dao.ClienteDAO;
import com.fabioperettig.dao.ClienteMockDAO;
import com.fabioperettig.dao.IClienteDAO;
import com.fabioperettig.service.ClienteService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServiceTest {
    private IClienteDAO iClienteDAO = new ClienteMockDAO();

    ClienteService service = new ClienteService(iClienteDAO);
    ClienteController controller = new ClienteController(service);

    @Test
    public void cadastroTest(){
        Cliente cliente = new Cliente("Teste");
        service.cadastrar(cliente);
        //Assertions.assertEquals(1, iClienteDAO.trazerLista().size());
    }


}
