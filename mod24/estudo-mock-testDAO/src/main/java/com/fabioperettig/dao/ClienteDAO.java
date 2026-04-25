package com.fabioperettig.dao;

import com.fabioperettig.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO{

    List<Cliente> listaCliente = new ArrayList<>();

    @Override
    public void salvar(Cliente cliente) {
//        listaCliente.add(cliente);
        throw new IllegalArgumentException("Precisa de acesso ao banco de dados.");
    }

    @Override
    public List<Cliente> trazerLista() {
        return new ArrayList<>(listaCliente);
    }
}
