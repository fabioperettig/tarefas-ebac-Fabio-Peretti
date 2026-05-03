package com.fabioperettig.testProject.dao;

import com.fabioperettig.testProject.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteDAO implements ICliente{

    private final List<Cliente> clienteList = new ArrayList<>();
    private int contadorID = 1;

    @Override
    public void create(Cliente cliente) {
        cliente.setId(contadorID++);
        clienteList.add(cliente);
    }

    @Override
    public Optional<Cliente> read(int id) {
        return clienteList.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    @Override
    public void update(Cliente clienteUpdate) {
        read(clienteUpdate.getId())
                .ifPresent(c -> {
                    c.setNome(clienteUpdate.getNome());
                    c.setEmail(clienteUpdate.getEmail());
                });
    }

    @Override
    public void delete(int id) {
        clienteList.removeIf(c -> c.getId() == id);
    }

    @Override
    public List<Cliente> findAll() {
        return new ArrayList<>(clienteList);
    }
}
