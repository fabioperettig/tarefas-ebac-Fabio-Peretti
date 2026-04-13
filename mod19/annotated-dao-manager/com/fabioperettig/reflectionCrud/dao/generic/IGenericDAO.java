package com.fabioperettig.reflectionCrud.dao.generic;

import com.fabioperettig.reflectionCrud.domain.*;

import java.util.Collection;

/**
 * Generic Interface to CRUD methods
 * (create, read, update, delete)
 *
 * @param <T>
 */
public interface IGenericDAO <T extends Persistent> {

    public Boolean create(T entity);
    public T read (Long value);
    public void update (T entity);
    public void delete (Long value);

    /**
     * Returning every record from database
     */
    public Collection<T> searchAll();

}
