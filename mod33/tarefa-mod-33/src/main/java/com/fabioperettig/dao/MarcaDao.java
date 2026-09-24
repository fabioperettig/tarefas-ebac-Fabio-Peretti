package com.fabioperettig.dao;

import com.fabioperettig.config.EntityManagerSingleton;
import com.fabioperettig.domain.Marca;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MarcaDao implements IMarcaDao {

    EntityManager em = EntityManagerSingleton.getEntityManager();

    @Override
    public Marca create(Marca marca) {

        em.getTransaction().begin();
        em.persist(marca);
        em.getTransaction().commit();
        em.close();

        return marca;
    }

    @Override
    public Marca read(Long id) {

        Marca marca = em.find(Marca.class, id);
        em.close();

        return marca;
    }

    @Override
    public Marca update(Marca marca) {

        em.getTransaction().begin();
        marca = em.merge(marca);
        em.getTransaction().commit();
        em.close();

        return marca;
    }

    @Override
    public void delete(Marca marca) {

        em.getTransaction().begin();
        marca = em.merge(marca);
        em.remove(marca);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public List<Marca> findAll() {

        List<Marca> marcas = em.createQuery(
                "SELECT m FROM Marca m",
                Marca.class
        ).getResultList();
        em.close();

        return marcas;
    }
}
