package com.fabioperettig.dao;

import com.fabioperettig.domain.Client;

import java.util.List;

public interface IClientDAO {

    public Client create(Client client);
    public Client readById(Long id);
    public Client update(Client client);
    public void delete(Client client);
    public List<Client> listAll();
}
