package com.fabioperettig.testProject;

import com.fabioperettig.testProject.dao.ClienteMockDAO;
import com.fabioperettig.testProject.dao.ICliente;
import com.fabioperettig.testProject.model.Cliente;
import com.fabioperettig.testProject.service.ClienteService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestServiceClient {

    private ICliente iCliente;

    @BeforeEach
    void setup(){
        iCliente = new ClienteMockDAO();
    }

    @Test
    public void testeServiceCREATEClienteSucesso(){
        Cliente cliente = new Cliente("sucesso", "@mail");
        ClienteService service = new ClienteService(iCliente);
        /**
         * Operação separada para testar a validez do nome
         * e impedir que a Classe Teste tome decisão.
         * @see testeServiceCREATEClienteNomeInvalido()
         */
        //if (cliente.getNome() == null || cliente.getNome().isBlank()){...}

        service.createService(cliente);
        Assertions.assertEquals("sucesso", cliente.getNome());
    }

    @Test
    public void testeServiceCREATEClienteNomeInvalido(){

        ClienteService service = new ClienteService(iCliente);
        Cliente cliente = new Cliente(null, "@mail");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.createService(cliente);
        });
    }

    @Test
    public void testeServiceUPDATECliente(){
        ClienteService service = new ClienteService(iCliente);
        Cliente cliente = new Cliente("testeOLD", "email@mail.com");
        iCliente.create(cliente);

        service.updateService(1,"testeNovoNome", cliente.getEmail());
        Assertions.assertEquals("testeNovoNome", cliente.getNome());
    }
}
