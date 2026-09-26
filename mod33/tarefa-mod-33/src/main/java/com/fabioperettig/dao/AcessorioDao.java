package com.fabioperettig.dao;

import com.fabioperettig.config.EntityManagerSingleton;
import com.fabioperettig.domain.Acessorio;
import com.fabioperettig.domain.Carro;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AcessorioDao implements IAcessorioDao {
    @Override
    public Acessorio create(Acessorio acessorio) {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        em.getTransaction().begin();
        em.persist(acessorio);
        em.getTransaction().commit();
        em.close();

        return acessorio;
    }

    @Override
    public Acessorio read(Long id) {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        Acessorio acessorio = em.find(Acessorio.class, id);
        em.close();

        return acessorio;
    }

    @Override
    public Acessorio update(Acessorio acessorio) {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        em.getTransaction().begin();
        acessorio = em.merge(acessorio);
        em.getTransaction().commit();
        em.close();

        return acessorio;
    }

    @Override
    public void delete(Acessorio acessorio) {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        em.getTransaction().begin();
        acessorio = em.merge(acessorio);
        ///para desassociar o a cessório do carro para evitar rollback
        acessorio.getCarro().setAcessorio(null);
        em.remove(acessorio);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public List<Acessorio> findAll() {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        List<Acessorio> acessorios = em.createQuery("SELECT c FROM Carro c", Acessorio.class).getResultList();
        em.close();

        return acessorios;
    }
}
