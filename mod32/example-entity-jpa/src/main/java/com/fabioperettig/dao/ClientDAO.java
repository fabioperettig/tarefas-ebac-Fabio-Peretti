package com.fabioperettig.dao;

import com.fabioperettig.domain.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ClientDAO implements IClientDAO {
    @Override
    public Client create(Client client) {

        ///testar se é viável uma abstract com parâmetro ENTITY para evitar boilerplate
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("firstJPA");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();

        return client;
    }

    @Override
    public Client readById(Long id) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("firstJPA");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        ///aqqui também é viável um abstract Entity
        Client client = entityManager.find(Client.class, id);
        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();

        return client;
    }

    @Override
    public Client update(Client client) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("firstJPA");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        client = entityManager.merge(client);
        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();

        return client;
    }

    @Override
    public void delete(Client client) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("firstJPA");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        client = entityManager.merge(client);
        entityManager.remove(client);
        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();
    }

    @Override
    public List<Client> listAll() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("firstJPA");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        List<Client> list = entityManager.createQuery(
                "SELECT c FROM Cliente c", Client.class).getResultList();
        entityManager.getTransaction().commit();

        entityManager.close();
        managerFactory.close();

        return list;
    }
}
