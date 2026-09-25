package com.fabioperettig.dao;

import com.fabioperettig.domain.Carro;
import com.fabioperettig.domain.Marca;

import java.util.List;

public interface IMarcaDao extends IGenericDao<Marca, Long> {

    List<Marca> createAll(Marca... marcas);
    public void deleteAll(Marca... marcas);
}
