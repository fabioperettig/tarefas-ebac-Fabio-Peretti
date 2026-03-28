package com.fabioperettig.crud.dao;

import com.fabioperettig.crud.SingletonMap;
import com.fabioperettig.crud.dao.generic.GenericDAO;
import com.fabioperettig.crud.domain.Client;

import java.util.HashMap;
import java.util.Map;

public class ClientDAO extends GenericDAO<Client> implements IClientDAO {

    public ClientDAO(){
        super();
        Map<Long, Client> internMap = (Map<Long, Client>) SingletonMap.getInstance().getMap().get(getClassType());
        if (internMap == null) {
            internMap = new HashMap<>();
            SingletonMap.getInstance().getMap().put(getClassType(), internMap);
        }
    }

    @Override
    public Class<Client> getClassType() {
        return Client.class;
    }

    @Override
    public void updateData(Client entity, Client registeredEntity) {
        registeredEntity.setName(entity.getName());
        registeredEntity.setCode(entity.getCode());
        registeredEntity.setCountry(entity.getCountry());
    }
}
