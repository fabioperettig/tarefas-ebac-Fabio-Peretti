package com.fabioperettig.dao;

import com.fabioperettig.config.EntityManagerSingleton;
import com.fabioperettig.domain.Acessorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

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

    ///findByCode via CRITERIA
    @Override
    public Acessorio findyByCode(String codigo) {

        EntityManager em = EntityManagerSingleton.getEntityManager();

        CriteriaBuilder cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Acessorio> querry = cBuilder.createQuery(Acessorio.class);

        ///FROM Acessorio 'a'(alias)
        Root<Acessorio> acessorioRoot = querry.from(Acessorio.class);

        ///SELECT a + WHERE a.codigo=:codigoInput(parametro)
        querry.select(acessorioRoot).where(cBuilder.equal(acessorioRoot.get("codigo"),codigo));

        TypedQuery<Acessorio> typedQuery = em.createQuery(querry);

        return typedQuery.getSingleResult();
    }

}
