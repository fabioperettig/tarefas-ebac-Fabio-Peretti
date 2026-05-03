package com.fabioperettig.testProject.controller;

import com.fabioperettig.testProject.model.Contrato;
import com.fabioperettig.testProject.service.ContratoService;
import com.fabioperettig.testProject.service.ErroClientException;

public class ContratoController {

    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    public void novoContrato(int idCliente) throws ErroClientException {
        Contrato contrato = new Contrato(idCliente,true);
        contratoService.createService(contrato);
    }

    public Contrato buscarContrato(int id){
        return contratoService.readService(id);
    }

    public void atualizarContrato(int id, boolean ativo){
        contratoService.updateService(id, ativo);
    }

    public void excluirContrato(int id){
        contratoService.deleteService(id);
    }

}
