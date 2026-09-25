package com.fabioperettig.dao;

import com.fabioperettig.config.EntityManagerSingleton;
import com.fabioperettig.domain.Carro;
import com.fabioperettig.domain.Marca;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CarroDao implements ICarroDao {

    @Override
    public Carro create(Carro carro) {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        em.getTransaction().begin();
        em.persist(carro);
        em.getTransaction().commit();
        em.close();

        return carro;
    }

    @Override
    public Carro read(Long id) {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        Carro carro = em.find(Carro.class, id);
        em.close();

        return carro;
    }

    @Override
    public Carro update(Carro carro) {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        em.getTransaction().begin();
        carro = em.merge(carro);
        em.getTransaction().commit();
        em.close();

        return carro;
    }

    @Override
    public void delete(Carro carro) {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        em.getTransaction().begin();
        carro = em.merge(carro);
        em.remove(carro);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public List<Carro> findAll() {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        List<Carro> carros = em.createQuery("SELECT c FROM Carro c", Carro.class).getResultList();
        em.close();

        return carros;
    }

    /**
     * Metodo de estudos extras para createDAO com vários objetos.
     *
     * @author fabioperettig
     */
    @Override
    public List<Carro> createAll(Carro... carros) {
        EntityManager em = EntityManagerSingleton.getEntityManager();
        em.getTransaction().begin();

        for (Carro carro : carros) {
            em.persist(carro);
        }

        em.getTransaction().commit();
        em.close();

        return List.of(carros);
    }

    @Override
    public void deleteAll(Carro... carros) {

    }
}
