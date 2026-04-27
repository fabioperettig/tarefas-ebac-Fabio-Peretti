package com.fabioperettig.testProject.controller;

import com.fabioperettig.testProject.model.Cliente;
import com.fabioperettig.testProject.service.ClienteService;

import java.util.List;

public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void novoCliente(String nome, String email) {
        Cliente cliente = new Cliente(nome, email);
        clienteService.createService(cliente);
    }

    public Cliente buscarCliente(int id){
        return clienteService.readService(id);
    }

    public void atualizarCliente(int id, String novoNome, String novoEmail){
        clienteService.updateService(id, novoNome, novoEmail);
    }

    public void excluirCliente(int id){
        clienteService.deleteService(id);
    }

    public List<Cliente> listarClientes(){
        return clienteService.listarCLientes();
    }

}
