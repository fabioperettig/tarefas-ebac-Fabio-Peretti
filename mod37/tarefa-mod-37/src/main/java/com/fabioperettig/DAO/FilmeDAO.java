package com.fabioperettig.DAO;

import com.fabioperettig.config.ConfigManager;
import com.fabioperettig.domain.Filme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.Collection;

public class FilmeDAO implements IGenericDAO<Filme, Long> {
    @Override
    public Filme cadastrarEntidade(Filme filme) {

        EntityManager entityManager = ConfigManager.getEntityInstance();

        entityManager.getTransaction().begin();
        entityManager.persist(filme);
        entityManager.getTransaction().commit();
        entityManager.close();

        return filme;
    }

    @Override
    public Filme buscarEntidadePorID(Long id) {

        EntityManager entityManager = ConfigManager.getEntityInstance();

        Filme filmeBusca = entityManager.find(Filme.class, id);
        entityManager.close();

        return filmeBusca;
    }

    @Override
    public Filme alterarEntidade(Filme filme) {

        EntityManager entityManager = ConfigManager.getEntityInstance();

        entityManager.getTransaction().begin();
        filme = entityManager.merge(filme);
        entityManager.getTransaction().commit();
        entityManager.close();

        return filme;
    }

    @Override
    public void deletarEntidade(Filme filme) {

        EntityManager entityManager = ConfigManager.getEntityInstance();

        entityManager.getTransaction().begin();
        filme = entityManager.merge(filme);
        entityManager.remove(filme);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Collection<Filme> buscarTodos() {

        EntityManager entityManager = ConfigManager.getEntityInstance();

        try {
            CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();

            CriteriaQuery<Filme> cQuerry = cBuilder.createQuery(Filme.class);
            Root<Filme> rootJPA = cQuerry.from(Filme.class);
            cQuerry.select(rootJPA);

            return entityManager.createQuery(cQuerry).getResultList();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Filme buscarPorTitulo(String nomeFilme) {

        EntityManager entityManager = ConfigManager.getEntityInstance();

        try {
            CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Filme> cQuerry = cBuilder.createQuery(Filme.class);

            Root<Filme> rootJPA = cQuerry.from(Filme.class);
            cQuerry.select(rootJPA).where(cBuilder.equal(rootJPA.get("nome"), nomeFilme));
            TypedQuery<Filme> typedQuery = entityManager.createQuery(cQuerry);

            return entityManager.createQuery(cQuerry).getSingleResult();
        } finally {
            entityManager.close();
        }
    }
}
