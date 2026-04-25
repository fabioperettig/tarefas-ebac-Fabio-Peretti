package com.fabioperettig.test;

import com.fabioperettig.Cliente;
import com.fabioperettig.controller.ClienteController;
import com.fabioperettig.dao.ClienteDAO;
import com.fabioperettig.dao.ClienteMockDAO;
import com.fabioperettig.dao.IClienteDAO;
import com.fabioperettig.service.ClienteService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.rmi.UnexpectedException;

public class ServiceTest {
    private IClienteDAO iClienteDAO = new ClienteDAO();

    ClienteService service = new ClienteService(iClienteDAO);
    ClienteController controller = new ClienteController(service);

    @Test()
    public void cadastroTest(){
        controller.novoCadastro("ClienteTeste");
    }


}
