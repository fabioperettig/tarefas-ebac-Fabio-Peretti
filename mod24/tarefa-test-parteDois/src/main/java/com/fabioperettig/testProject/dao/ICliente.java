package com.fabioperettig.testProject.dao;

import com.fabioperettig.testProject.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ICliente {

    /// CRUD methods
    void create(Cliente cliente);
    Optional<Cliente> read(int id);
    void update(Cliente cliente);
    void delete(int id);

    List<Cliente>findAll();
}
