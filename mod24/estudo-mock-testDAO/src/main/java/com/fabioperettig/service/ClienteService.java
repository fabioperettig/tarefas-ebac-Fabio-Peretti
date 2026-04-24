package com.fabioperettig.service;

import com.fabioperettig.Cliente;
import com.fabioperettig.dao.IClienteDAO;

import java.util.List;

public class ClienteService {

    private IClienteDAO iClienteDAO;

    public ClienteService(IClienteDAO iClienteDAO) {
        this.iClienteDAO = iClienteDAO;
    }

    public void cadastrar(Cliente cliente){
        if (cliente.getNome() == null){
            throw new IllegalArgumentException();
        }
        iClienteDAO.salvar(cliente);
    }

    public List<Cliente> listaCliente(){
        List<Cliente> list = iClienteDAO.trazerLista();
        if (list.isEmpty()){
            throw new IllegalArgumentException("Lista vazia");
        }
        return list;
    }

}
