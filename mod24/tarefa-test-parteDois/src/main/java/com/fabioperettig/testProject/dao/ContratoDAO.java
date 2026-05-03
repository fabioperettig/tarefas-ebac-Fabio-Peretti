package com.fabioperettig.testProject.dao;

import com.fabioperettig.testProject.model.Cliente;
import com.fabioperettig.testProject.model.Contrato;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContratoDAO implements IContrato{

    private final List<Contrato> contratoList = new ArrayList<>();
    private int contadorID = 100;

    /// CRUD methods
    @Override
    public void create(Contrato contrato) {
        contrato.setId(contadorID++);
        contratoList.add(contrato);
    }

    @Override
    public Optional<Contrato> read(int id) {
        return contratoList.stream()
                .filter(contrato -> contrato.getId() == id)
                .findFirst();
    }

    @Override
    public void update(Contrato contratoUpdate) {
        read(contratoUpdate.getId())
                .ifPresent(contrato -> {
                    contrato.setClienteID(contratoUpdate.getClienteID());
                    contrato.setAtivo(contratoUpdate.isAtivo());
                });
    }

    @Override
    public void delete(int id) {
        contratoList.removeIf(contrato -> contrato.getId()==id);
    }
}
