package com.fabioperettig.dao;

import com.fabioperettig.domain.Product;

import java.util.List;

public interface IProductDAO {

    public Product create(Product client);
    public Product readById(Long id);
    public Product update(Product client);
    public void delete(Product client);
    public List<Product> listAll();

}
