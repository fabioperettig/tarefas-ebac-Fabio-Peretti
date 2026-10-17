package com.fabioperettig.service;

import java.util.Collection;
import java.util.Optional;

public interface IService<T, ID> {
    T create(T entity);
    Optional<T> findById(ID id);
    T update(T entity);
    void delete(T entity);
    Collection<T> findAll();
    Optional<T> findByTitle(String title);
}
