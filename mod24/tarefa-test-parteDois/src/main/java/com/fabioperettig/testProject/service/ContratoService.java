package com.fabioperettig.testProject.service;

import com.fabioperettig.testProject.dao.ICliente;
import com.fabioperettig.testProject.dao.IContrato;
import com.fabioperettig.testProject.model.Contrato;

public class ContratoService {

    private IContrato iContrato;
    private ICliente iCliente;

    public ContratoService(IContrato iContrato, ICliente iCliente) {
        this.iContrato = iContrato;
        this.iCliente = iCliente;
    }

    public void createService(Contrato contrato) throws ErroClientException {

        iCliente.read(contrato.getClienteID())
                .orElseThrow(() -> new ErroClientException("Cliente não existe."));

        iContrato.create(contrato);
    }

    public Contrato readService(int id){
        return iContrato.read(id)
                .orElseThrow(() -> new IllegalArgumentException("Contrato não encontrado."));
    }

    public void updateService(int id, boolean ativo){
        Contrato contrato = readService(id);
        ativo = !contrato.isAtivo();
        contrato.setAtivo(ativo);
    }

    public void deleteService(int id){
        readService(id);
        iContrato.delete(id);
    }

}
