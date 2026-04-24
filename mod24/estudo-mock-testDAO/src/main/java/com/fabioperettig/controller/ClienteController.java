package com.fabioperettig.controller;

import com.fabioperettig.Cliente;
import com.fabioperettig.service.ClienteService;

import java.util.List;

public class ClienteController {

    private ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    public void novoCadastro(String nome){
        Cliente cliente = new Cliente(nome);
        service.cadastrar(cliente);
    }

    public List<Cliente> trazerLista(){
        return service.listaCliente();
    }

}
