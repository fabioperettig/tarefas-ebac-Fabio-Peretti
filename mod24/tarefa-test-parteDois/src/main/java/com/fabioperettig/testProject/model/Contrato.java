package com.fabioperettig.testProject.model;

import com.fabioperettig.testProject.model.Cliente;

public class Contrato {

    private int id;
    private int clienteID;
    private boolean ativo;

    public Contrato(int clienteID, boolean ativo) {
        this.clienteID = clienteID;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }
    public int getClienteID() {
        return clienteID;
    }
    public boolean isAtivo() {
        return ativo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }
}
