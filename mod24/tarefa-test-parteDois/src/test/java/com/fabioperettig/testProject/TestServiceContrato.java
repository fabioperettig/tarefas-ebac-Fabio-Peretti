package com.fabioperettig.testProject;

import com.fabioperettig.testProject.dao.ClienteMockDAO;
import com.fabioperettig.testProject.dao.ContratoMockDAO;
import com.fabioperettig.testProject.dao.ICliente;
import com.fabioperettig.testProject.dao.IContrato;
import com.fabioperettig.testProject.model.Cliente;
import com.fabioperettig.testProject.model.Contrato;
import com.fabioperettig.testProject.service.ClienteService;
import com.fabioperettig.testProject.service.ContratoService;
import com.fabioperettig.testProject.service.ErrorClientException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestServiceContrato {

    private IContrato iContrato;
    private ICliente iCliente;

    @BeforeEach
    void setup(){
        iContrato = new ContratoMockDAO();
        iCliente = new ClienteMockDAO();
    }

    @Test
    public void testeServiceCREATEContratoSucesso() throws ErrorClientException {
        Cliente cliente = new Cliente("name", "@mail");
        Cliente cliente2 = new Cliente("name", "@mail");
        ContratoService service = new ContratoService(iContrato, iCliente);
        ClienteService serviceCLIENTE = new ClienteService(iCliente);

        serviceCLIENTE.createService(cliente);
        serviceCLIENTE.createService(cliente2);

        Contrato contrato = new Contrato(2,false);

        service.createService(contrato);
        Assertions.assertEquals(100,contrato.getId());
    }

    @Test
    public void testeServiceERROsemCLiente() throws ErrorClientException {
        ContratoService service = new ContratoService(iContrato, iCliente);
        Contrato contrato = new Contrato(1, true);

        Assertions.assertThrows(ErrorClientException.class, () -> {
            service.createService(contrato);
        });
    }

    @Test
    public void testeServiceUPDATEContrato(){
        ContratoService service = new ContratoService(iContrato,iCliente);
        ClienteService clService = new ClienteService(iCliente);

        Cliente clienteTeste = new Cliente("teste", "@mail");
        clService.createService(clienteTeste);

        Contrato contrato = new Contrato(1,true);
        service.createService(contrato);

        service.updateService(100,false);

        Assertions.assertFalse(contrato.isAtivo());
    }
}
