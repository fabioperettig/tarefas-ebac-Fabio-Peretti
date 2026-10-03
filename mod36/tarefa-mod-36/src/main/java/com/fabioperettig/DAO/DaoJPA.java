package com.fabioperettig.DAO;

import com.fabioperettig.config.EntityManagerJPA;
import com.fabioperettig.domain.ClienteJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.Collection;

public class DaoJPA implements IGenericDAO<ClienteJPA, Long> {

    @Override
    public ClienteJPA cadastrarEntidade(ClienteJPA cliente) {

        EntityManager em = EntityManagerJPA.getEntitymanager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();

        return cliente;
    }

    @Override
    public ClienteJPA buscarEntidadePorID(Long id) {

        EntityManager em = EntityManagerJPA.getEntitymanager();

        ClienteJPA jpaResult = em.find(ClienteJPA.class, id);
        em.close();

        return jpaResult;
    }

    @Override
    public ClienteJPA alterarEntidade(ClienteJPA cliente) {

        EntityManager em = EntityManagerJPA.getEntitymanager();

        em.getTransaction().begin();
        cliente = em.merge(cliente);
        em.getTransaction().commit();
        em.close();

        return cliente;
    }

    @Override
    public void deletarEntidade(ClienteJPA cliente) {

        EntityManager em = EntityManagerJPA.getEntitymanager();

        em.getTransaction().begin();
        cliente = em.merge(cliente);
        em.remove(cliente);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Collection<ClienteJPA> buscarTodos() {

        EntityManager em = EntityManagerJPA.getEntitymanager();

        try {
            CriteriaBuilder cBuilder = em.getCriteriaBuilder();

            CriteriaQuery<ClienteJPA> cQuerry = cBuilder.createQuery(ClienteJPA.class);
            Root<ClienteJPA> rootJPA = cQuerry.from(ClienteJPA.class);
            cQuerry.select(rootJPA);

            return em.createQuery(cQuerry).getResultList();
        } finally {
            em.close();
        }

    }
}
