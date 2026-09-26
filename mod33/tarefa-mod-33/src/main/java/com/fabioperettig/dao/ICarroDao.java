package com.fabioperettig.dao;

import com.fabioperettig.domain.Carro;

import java.util.List;

public interface ICarroDao extends IGenericDao<Carro, Long> {

    ///metodo findBy com JPQL
    public Carro findyByCode(String codigo);

    ///metodos extras
    List<Carro> createAll(Carro... carros);
    public void deleteAll(Carro... carros);

}
