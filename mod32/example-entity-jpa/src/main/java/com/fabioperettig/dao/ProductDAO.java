package com.fabioperettig.dao;

import com.fabioperettig.config.ConnectionManager;
import com.fabioperettig.domain.Product;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProductDAO implements IProductDAO {

    @Override
    public Product create(Product product) {
        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();

        entityManager.close();

        return product;
    }

    @Override
    public Product readById(Long id) {
        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        entityManager.getTransaction().commit();;

        entityManager.close();

        return product;
    }

    @Override
    public Product update(Product product) {
        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        product = entityManager.merge(product);
        entityManager.getTransaction().commit();

        entityManager.close();

        return product;
    }

    @Override
    public void delete(Product product) {
        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        product = entityManager.merge(product);
        entityManager.remove(product);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public List<Product> listAll() {
        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        List<Product> list = entityManager.createQuery(
                "SELECT p FROM Product p", Product.class).getResultList();
        entityManager.getTransaction().commit();

        entityManager.close();

        return list;
    }
}
