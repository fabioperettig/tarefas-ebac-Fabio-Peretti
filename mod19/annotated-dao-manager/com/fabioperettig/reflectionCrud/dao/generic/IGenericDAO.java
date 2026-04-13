package com.fabioperettig.reflectionCrud.dao;

import com.fabioperettig.reflectionCrud.domain.*;
import com.fabioperettig.reflectionCrud.exception.KeyNotFoundException;

import java.util.Collection;

/**
 * Generic Interface to CRUD methods
 * (create, read, update, delete)
 *
 * @param <T>
 */
public interface IGenericDAO <T extends Persistent> {

    public Boolean create(T entity) throws KeyNotFoundException;
    public T read (Long value);
    public void update (T entity) throws KeyNotFoundException;
    public void delete (Long value);

    /**
     * Returning every record from database
     */
    public Collection<T> searchAll();

}
