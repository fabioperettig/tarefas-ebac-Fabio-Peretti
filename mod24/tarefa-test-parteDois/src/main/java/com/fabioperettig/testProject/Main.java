package com.fabioperettig.testProject;

import com.fabioperettig.testProject.controller.ClienteController;
import com.fabioperettig.testProject.controller.ContratoController;
import com.fabioperettig.testProject.dao.ClienteMockDAO;
import com.fabioperettig.testProject.dao.ContratoMockDAO;
import com.fabioperettig.testProject.dao.ICliente;
import com.fabioperettig.testProject.dao.IContrato;
import com.fabioperettig.testProject.service.ClienteService;
import com.fabioperettig.testProject.service.ContratoService;
import com.fabioperettig.testProject.service.ErroClientException;

public class Main {

    public static void main(String[] args) throws ErroClientException {

//        ICliente cliente = new ClienteDAO();
        ICliente cliente = new ClienteMockDAO();
        ClienteService service = new ClienteService(cliente);
        ClienteController controller = new ClienteController(service);

        IContrato contrato = new ContratoMockDAO();
        ContratoService contService = new ContratoService(contrato, cliente);
        ContratoController contController = new ContratoController(contService);



        /// create
        controller.novoCliente("Fabio","fabio@mail.com");
        controller.novoCliente("Rhaissa", "rha@mail.com");
        controller.novoCliente("Flavio", "flv@mail.com");
        controller.novoCliente("Anna", "anna@mail.com");


        contController.novoContrato(4);
        contController.buscarContrato(100);

        ///
        contController.atualizarContrato(100,false);
        contController.buscarContrato(100);
    }
}
