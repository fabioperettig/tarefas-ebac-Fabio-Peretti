package com.fabioperettig.dao;

import java.util.List;

public interface IGenericDao<T, ID> {

    T create(T entity);
    T read (ID id);
    T update(T entity);
    void delete(T entity);

    List<T> findAll();

}
