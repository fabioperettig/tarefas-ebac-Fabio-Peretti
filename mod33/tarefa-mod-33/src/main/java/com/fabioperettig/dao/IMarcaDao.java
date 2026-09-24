package com.fabioperettig.dao;

import com.fabioperettig.domain.Carro;
import com.fabioperettig.domain.Marca;

import java.util.List;

public interface IMarcaDao {

    public Marca create(Marca marca);
    public Marca read (Long id);
    public Marca update(Marca marca);
    public void delete(Marca marca);

    public List<Marca> findAll();

}
