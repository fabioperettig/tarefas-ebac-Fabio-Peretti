package com.fabioperettig.crud.factory;

import com.fabioperettig.crud.domain.Persistent;

public interface FactoryPersistent {

    /**
     * Method that can create application objects
     *
     * @param data record data in the database
     * @return Persistent object
     */
    Persistent createObject(String[] data);

}
