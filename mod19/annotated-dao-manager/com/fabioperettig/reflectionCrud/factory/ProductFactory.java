package com.fabioperettig.reflectionCrud.factory;

import com.fabioperettig.reflectionCrud.domain.Persistent;
import com.fabioperettig.reflectionCrud.domain.Product;

public class ProductFactory implements FactoryPersistent{
    /**
     * Method that can create application objects
     *
     * @param data record data in the database
     * @return Persistent object
     */
    @Override
    public Persistent createObject(String[] data) {
        if (data == null || data.length < 3){
            return null;
        }

        String name = data[0];
        Long code = Long.valueOf(data[1]);
        String brand = data[0];

        return new Product(name, code, brand);
    }
}
