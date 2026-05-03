package com.fabioperettig.testProject.dao;

import com.fabioperettig.testProject.model.Contrato;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContratoMockDAO implements IContrato {
    private final List<Contrato> contratoList = new ArrayList<>();
    private int contratorID = 100;

    @Override
    public void create(Contrato contrato) {
        System.out.printf("\n[RECEBENDO PEDIDO] Contrato: %d", contrato.getId());
        contrato.setId(contratorID++);
        contratoList.add(contrato);

        System.out.printf("\n[CONTRATO REGISTRADO] ID: %d | Cliente: %d\n",
                contrato.getId(), contrato.getClienteID());
    }

    @Override
    public Optional<Contrato> read(int id) {

        Optional<Contrato> resultado = contratoList.stream()
                .filter(contrato -> contrato.getId()==id)
                .findFirst();

        resultado.ifPresent(contrato -> System.out.printf("\n[CONTRATO REGISTRADO] ID: %d | Cliente: %d | Ativo: %b\n",
                contrato.getId(), contrato.getClienteID(), contrato.isAtivo()));

        return resultado;
    }

    @Override
    public void update(Contrato contratoUpdate) {
        read(contratoUpdate.getId())
                .ifPresent(contrato -> {
                    contrato.setClienteID(contratoUpdate.getClienteID());
                    contrato.setAtivo(contratoUpdate.isAtivo());
                });


        System.out.printf("\n[CLIENTE ATUALIZADO] ID: %d | Cliente: %d | Ativo:%b\n",
                contratoUpdate.getId(), contratoUpdate.getClienteID(), contratoUpdate.isAtivo());
    }

    @Override
    public void delete(int id) {
        contratoList.removeIf(contrato -> contrato.getId()==id);
    }
}
