package com.fabioperettig.dao;

import com.fabioperettig.config.EntityManagerSingleton;
import com.fabioperettig.domain.Marca;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MarcaDao implements IMarcaDao {

    @Override
    public Marca create(Marca marca) {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        em.getTransaction().begin();
        em.persist(marca);
        em.getTransaction().commit();
        em.close();

        return marca;
    }

    @Override
    public Marca read(Long id) {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        Marca marca = em.find(Marca.class, id);
        em.close();

        return marca;
    }

    @Override
    public Marca update(Marca marca) {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        em.getTransaction().begin();
        marca = em.merge(marca);
        em.getTransaction().commit();
        em.close();

        return marca;
    }

    @Override
    public void delete(Marca marca) {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        em.getTransaction().begin();
        marca = em.merge(marca);
        em.remove(marca);
        em.getTransaction().commit();
        em.close();

    }

    /**
     * Metodo de estudos extras para createDAO com vários objetos.
     *
     * @author fabioperettig
     */
    @Override
    public List<Marca> createAll(Marca... marcas) {

        EntityManager em = EntityManagerSingleton.getEntityManager();
        em.getTransaction().begin();

        for (Marca marca : marcas) {
            em.persist(marca);
        }

        em.getTransaction().commit();
        em.close();

        return List.of(marcas);
    }

    @Override
    public List<Marca> findAll() {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        List<Marca> marcas = em.createQuery("SELECT m FROM Marca m", Marca.class).getResultList();
        em.close();

        return marcas;
    }

    @Override
    public void deleteAll(Marca... marcas) {

        EntityManager em = EntityManagerSingleton.getEntityManager();
        em.getTransaction().begin();

        for (Marca marca : marcas) {
            Marca mDel = em.merge(marca);
            em.remove(mDel);
        }

        em.getTransaction().commit();
        em.close();
    }

}
