package com.fabioperettig.reflectionCrud.dao;

import com.fabioperettig.reflectionCrud.SingletonMap;
import com.fabioperettig.reflectionCrud.dao.generic.GenericDAO;
import com.fabioperettig.reflectionCrud.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductDAO extends GenericDAO<Product> implements IProductDAO {

    public ProductDAO() {
        super();
        Map<Long, Product> internMap = (Map<Long, Product>) SingletonMap.getInstance().getMap().get(getClassType());
        if (internMap == null) {
            internMap = new HashMap<>();
            SingletonMap.getInstance().getMap().put(getClassType(), internMap);
        }
    }

    @Override
    public Class<Product> getClassType() {
        return Product.class;
    }

    @Override
    public void updateData(Product entity, Product registeredEntity) {
        registeredEntity.setName(entity.getName());
        registeredEntity.setCode(entity.getCode());
        registeredEntity.setBrand(entity.getBrand());
    }
}
