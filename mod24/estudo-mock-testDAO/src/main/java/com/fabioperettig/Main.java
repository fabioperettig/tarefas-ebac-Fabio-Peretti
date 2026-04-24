package com.fabioperettig;

import com.fabioperettig.controller.ClienteController;
import com.fabioperettig.dao.ClienteDAO;
import com.fabioperettig.dao.IClienteDAO;
import com.fabioperettig.service.ClienteService;

public class Main {

    public static void main(String[] args) {

        IClienteDAO dao = new ClienteDAO();
        ClienteService service = new ClienteService(dao);
        ClienteController controller = new ClienteController(service);

        controller.novoCadastro("Fabio");
        controller.novoCadastro("Ana");
        controller.novoCadastro("Flavio");
        controller.novoCadastro("Agatha");

        controller.trazerLista()
                .forEach(cliente ->
                        System.out.println(cliente.getNome()));
    }

}
