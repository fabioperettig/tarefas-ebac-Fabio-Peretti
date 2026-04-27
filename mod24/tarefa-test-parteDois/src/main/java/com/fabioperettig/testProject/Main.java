package com.fabioperettig.testProject;

import com.fabioperettig.testProject.controller.ClienteController;
import com.fabioperettig.testProject.dao.ClienteMockDAO;
import com.fabioperettig.testProject.dao.ICliente;
import com.fabioperettig.testProject.service.ClienteService;

public class Main {

    public static void main(String[] args) {

//        ICliente cliente = new ClienteDAO();
        ICliente cliente = new ClienteMockDAO();
        ClienteService service = new ClienteService(cliente);
        ClienteController controller = new ClienteController(service);


        /// create
        controller.novoCliente("Fabio","fabio@mail.com");
        controller.novoCliente("Rhaissa", "rha@mail.com");
        controller.novoCliente("Flavio", "flv@mail.com");
        controller.novoCliente("Anna", "anna@mail.com");

        controller.listarClientes();

    }
}
