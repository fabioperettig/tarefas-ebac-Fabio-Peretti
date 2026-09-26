package com.fabioperettig.dao;

import com.fabioperettig.domain.Acessorio;

public interface IAcessorioDao extends IGenericDao<Acessorio, Long> {

    ///metodo findBy com CRITERIA
    public Acessorio findyByCode(String codigo);

}
