package com.fabioperettig.testProject;

import com.fabioperettig.testProject.dao.ClienteMockDAO;
import com.fabioperettig.testProject.dao.ContratoMockDAO;
import com.fabioperettig.testProject.dao.ICliente;
import com.fabioperettig.testProject.dao.IContrato;
import com.fabioperettig.testProject.model.Cliente;
import com.fabioperettig.testProject.model.Contrato;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class TestDAOContrato {

    private IContrato iContrato;
    private ICliente iCliente;

    @BeforeEach
    void detup(){
        iContrato = new ContratoMockDAO();
        iCliente = new ClienteMockDAO();
    }

    @Test
    public void testeDAOCREATEContratoIDAutomatico(){
        Cliente clienteTest = new Cliente("Teste", "contrato@mail.com");
        iCliente.create(clienteTest);

        Contrato contrato = new Contrato(1,true);
        iContrato.create(contrato);

        Optional<Contrato> resultado = iContrato.read(contrato.getId());

        Assertions.assertTrue(resultado.isPresent());
    }

    @Test
    public void testeDELETEDAOContrato(){
        Contrato contratoDEL = new Contrato(1,false);
        iContrato.create(contratoDEL);

        iContrato.delete(contratoDEL.getId());
        Optional<Contrato> delete = iContrato.read(contratoDEL.getId());

        Assertions.assertTrue(delete.isEmpty());
    }

}
