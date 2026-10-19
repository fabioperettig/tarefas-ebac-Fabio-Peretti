package com.fabioperettig.repository;

import com.fabioperettig.domain.Cliente;

import java.util.List;

public interface IClienteRepositoryCriteria {
    List<Cliente> buscaCriteria(String nome, String email);
}
