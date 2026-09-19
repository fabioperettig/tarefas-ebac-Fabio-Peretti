package com.fabioperettig.dao;

import com.fabioperettig.domain.Client;
import com.fabioperettig.domain.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ProductDAO implements IProductDAO {

    @Override
    public Product create(Product product) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("firstJPA");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();

        managerFactory.close();
        entityManager.close();

        return product;
    }

    @Override
    public Product readById(Long id) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("firstJPA");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        entityManager.getTransaction().commit();;

        managerFactory.close();
        entityManager.close();

        return product;
    }

    @Override
    public Product update(Product product) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("firstJPA");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        product = entityManager.merge(product);
        entityManager.getTransaction().commit();

        managerFactory.close();
        entityManager.close();

        return product;
    }

    @Override
    public void delete(Product product) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("firstJPA");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        product = entityManager.merge(product);
        entityManager.remove(product);

        managerFactory.close();
        entityManager.close();
    }

    @Override
    public List<Product> listAll() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("firstJPA");
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        List<Product> list = entityManager.createQuery(
                "SELECT p FROM Product p", Product.class).getResultList();
        entityManager.getTransaction().commit();

        managerFactory.close();
        entityManager.close();

        return list;
    }
}
