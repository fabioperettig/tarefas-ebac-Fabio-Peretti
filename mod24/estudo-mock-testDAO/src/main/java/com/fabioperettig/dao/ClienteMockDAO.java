package com.fabioperettig.dao;

import com.fabioperettig.Cliente;

import java.util.List;

public class ClienteMockDAO implements IClienteDAO{
    @Override
    public void salvar(Cliente cliente) {
        System.out.println("Teste executado com sucesso.");
    }

    @Override
    public List<Cliente> trazerLista() {
        System.out.println("Teste executado com sucesso.");
        return List.of();
    }
}
