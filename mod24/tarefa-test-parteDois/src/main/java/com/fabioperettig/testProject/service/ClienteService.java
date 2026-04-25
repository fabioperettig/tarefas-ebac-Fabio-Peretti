package com.fabioperettig.testProject.service;

import com.fabioperettig.testProject.dao.ICliente;
import com.fabioperettig.testProject.model.Cliente;

import java.util.List;

public class ClienteService {

    private ICliente iCliente;

    public ClienteService(ICliente iCliente) {
        this.iCliente = iCliente;
    }

    public void createService(Cliente cliente){

        boolean idCadastrado = iCliente.read(cliente.getId()).isPresent();

        if (idCadastrado) {
            throw new IllegalArgumentException("Esta ID já está em uso.");
        }

        if (cliente.getNome() == null || cliente.getNome().isBlank()){
            throw new IllegalArgumentException("O cliente precisa de um nome");
        }

        iCliente.create(cliente);
    }

    public Cliente readService(int id){
        return iCliente.read(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
    }

    public void updateService(int id, String novoNome, String novoEmail){
        Cliente cliente = readService(id);

        cliente.setNome(novoNome);
        cliente.setEmail(novoEmail);

        iCliente.update(cliente);
    }

    public void deleteService(int id){
        readService(id);
        iCliente.delete(id);
    }

    public List<Cliente> listarCLientes(){
        return iCliente.findAll();
    }

}
