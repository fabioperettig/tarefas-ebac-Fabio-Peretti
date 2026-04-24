package com.fabioperettig.dao;

import com.fabioperettig.Cliente;

import java.util.List;

public interface IClienteDAO {

    void salvar(Cliente cliente);
    List<Cliente> trazerLista();

}
