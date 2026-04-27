package com.fabioperettig.testProject.dao;

import com.fabioperettig.testProject.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteMockDAO implements ICliente{
    private final List<Cliente> clienteList = new ArrayList<>();
    private int contadorID = 1;

    @Override
    public void create(Cliente cliente) {
        System.out.printf("\n[RECEBENDO PEDIDO] Cliente: %s", cliente.getNome());
        cliente.setId(contadorID++);
        clienteList.add(cliente);

        System.out.printf("\n[CLIENTE REGISTRADO] ID: %08d | %s | %s\n",
                cliente.getId(), cliente.getNome(), cliente.getEmail());

    }

    @Override
    public Optional<Cliente> read(int id) {

        Optional<Cliente> resultado = clienteList.stream()
                .filter(c -> c.getId() == id)
                .findFirst();

        resultado.ifPresent(cliente -> System.out.printf("\n[CLIENTE ENCONTRADO] ID: %08d | %s | %s\n",
                cliente.getId(), cliente.getNome(), cliente.getEmail()));
        return resultado;
    }

    @Override
    public void update(Cliente clienteUpdate) {
        read(clienteUpdate.getId())
                .ifPresent(c -> {
                    c.setNome(clienteUpdate.getNome());
                    c.setEmail(clienteUpdate.getEmail());
                });

        System.out.printf("\n[CLIENTE ATUALIZADO] ID: %08d | %s | %s\n",
                clienteUpdate.getId(), clienteUpdate.getNome(), clienteUpdate.getEmail());

    }

    @Override
    public void delete(int id) {
        clienteList.removeIf(c -> c.getId() == id);
    }

    @Override
    public List<Cliente> findAll() {
        System.out.println("\n[LISTANDO CLIENTES]");
        clienteList.forEach(cliente ->
                System.out.printf("\nID: %08d | %s | %s",
                        cliente.getId(), cliente.getNome(), cliente.getEmail()));
        return new ArrayList<>(clienteList);
    }
}
