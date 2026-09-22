package com.fabioperettig.dao;

import com.fabioperettig.domain.Produto;

import java.util.List;

public interface IProdutoDao {

    public Produto create(Produto produto);
    public Produto readById(Long id);
    public Produto update(Produto produto);
    public void delete(Produto produto);

    public List<Produto> findAll();
}
