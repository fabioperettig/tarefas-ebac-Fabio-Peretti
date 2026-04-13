package com.fabioperettig.reflectionCrud.dao.generic;

import com.fabioperettig.reflectionCrud.SingletonMap;
import com.fabioperettig.reflectionCrud.annotation.TypeKey;
import com.fabioperettig.reflectionCrud.domain.*;
import com.fabioperettig.reflectionCrud.exception.KeyNotFoundException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    public Long getKey(T entity) throws KeyNotFoundException{
        Field[] fields = entity.getClass().getDeclaredFields();
        Long returnValue = null;

        for (Field field : fields){
            if (field.isAnnotationPresent(TypeKey.class)){
                TypeKey typeKey = field.getAnnotation(TypeKey.class);
                String methodName = typeKey.value();

                try{
                    Method method = entity.getClass().getMethod(methodName);
                    returnValue = (Long) method.invoke(entity);
                    return returnValue;

                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    throw new KeyNotFoundException("Key object " + entity.getClass() + " not found.", e);
                }
            }
        }

        if (returnValue == null) {
            String msg = "Key object " + entity.getClass() + " not found.";
            System.out.printf("\n--- ERROR ---\n%s", msg);
            throw new KeyNotFoundException(msg);
        }
        return null;
    }

    @Override
    public Boolean create(T entity) throws KeyNotFoundException {
        Map<Long, T> internMap = (Map<Long, T>) this.singletonMap.getMap().get(getClassType());
        Long key = getKey(entity);
        if (internMap.containsKey(key)){
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
    public void update(T entity) throws KeyNotFoundException {
        Map <Long, T> internMap = (Map<Long, T>) this.singletonMap.getMap().get(getClassType());
        Long key = getKey(entity);
        T registeredObj = internMap.get(key);
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
