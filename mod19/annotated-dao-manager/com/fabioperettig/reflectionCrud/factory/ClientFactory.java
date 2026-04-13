package com.fabioperettig.reflectionCrud.factory;

import com.fabioperettig.reflectionCrud.domain.Client;
import com.fabioperettig.reflectionCrud.domain.Persistent;
import com.fabioperettig.reflectionCrud.exception.InvalidDataException;

public class ClientFactory implements FactoryPersistent{
    /**
     * Method that can create application objects
     *
     * @param data record data in the database
     * @return Persistent object
     */
    @Override
    public Persistent createObject(String[] data) throws InvalidDataException {

        String name = data[0];
        Long code = Long.valueOf(data[1]);
        String country = data[2];

        try{
            return new Client(name, code, country);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidDataException("Invalid data.");
        }
    }
}
