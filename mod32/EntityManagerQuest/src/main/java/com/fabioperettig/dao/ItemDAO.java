package com.fabioperettig.dao;

import com.fabioperettig.config.ConnectionManager;
import com.fabioperettig.domain.Item;
import jakarta.persistence.EntityManager;

public class ItemDAO {

    public Item create(Item item) {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(item);
        entityManager.getTransaction().commit();

        entityManager.close();
        
        return item;
    }

}
