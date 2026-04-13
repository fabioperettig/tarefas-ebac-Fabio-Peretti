package com.fabioperettig.reflectionCrud.factory;

import com.fabioperettig.reflectionCrud.domain.Persistent;
import com.fabioperettig.reflectionCrud.exception.InvalidDataException;

public interface FactoryPersistent {

    /**
     * Method that can create application objects
     *
     * @param data record data in the database
     * @return Persistent object
     */
    Persistent createObject(String[] data) throws InvalidDataException;

}
