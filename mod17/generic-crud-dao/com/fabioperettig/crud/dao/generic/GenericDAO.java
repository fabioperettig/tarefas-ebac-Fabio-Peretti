package com.fabioperettig.crud.dao.generic;

import com.fabioperettig.crud.SingletonMap;
import com.fabioperettig.crud.domain.*;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class GenericDAO<T extends Persistent> implements IGenericDAO<T> {

    private SingletonMap singletonMap;

    public abstract Class<T> getClassType();
    public abstract void updateData(T entity, T registeredEntity);

    public GenericDAO() {
        this.singletonMap = SingletonMap.getInstance();
    }

    @Override
    public Boolean create(T entity) {
        Map<Long, T> internMap = (Map<Long, T>) this.singletonMap.getMap().get(getClassType());
        if (internMap.containsKey(entity.getCode())){
            return false;
        }
        internMap.put(entity.getCode(), entity);
        return true;
    }


    @Override
    public T read(Long value) {
        Map<Long, T> interMap = (Map<Long, T>) this.singletonMap.getMap().get(getClassType());
        return interMap.get(value);
    }

    @Override
    public void update(T entity) {
        Map <Long, T> internMap = (Map<Long, T>) this.singletonMap.getMap().get(getClassType());
        T registeredObj = internMap.get(entity.getCode());
        if (registeredObj != null) {
            updateData(entity, registeredObj);
        }

    }

    @Override
    public void delete(Long value) {
        Map <Long, T> internMap = (Map<Long, T>) this.singletonMap.getMap().get(getClassType());
        T registeredObj = internMap.get(value);
        if (registeredObj != null){
            internMap.remove(value, registeredObj);
        }
    }

    /**
     * Returning every record from database
     */
    @Override
    public Collection<T> searchAll() {
        return List.of();
    }
}
