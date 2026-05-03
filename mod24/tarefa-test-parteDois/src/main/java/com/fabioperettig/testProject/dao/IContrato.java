package com.fabioperettig.testProject.dao;

import com.fabioperettig.testProject.model.Contrato;

import java.util.Optional;

public interface IContrato {

    /// CRUD methods
    void create(Contrato contrato);
    Optional<Contrato> read(int id);
    void update(Contrato contrato);
    void delete(int id);
}
