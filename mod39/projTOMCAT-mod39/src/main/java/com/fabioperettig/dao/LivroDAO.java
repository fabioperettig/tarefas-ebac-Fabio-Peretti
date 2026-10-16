package com.fabioperettig.dao;

import com.fabioperettig.config.ConfigManager;
import com.fabioperettig.domain.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.Collection;

public class LivroDAO implements IGenericDAO<Livro, Long> {
    @Override
    public Livro cadastrarEntidade(Livro livro) {
        EntityManager entityManager = ConfigManager.getEntityInstance();

        entityManager.getTransaction().begin();
        entityManager.persist(livro);
        entityManager.getTransaction().commit();
        entityManager.close();

        return livro;
    }

    @Override
    public Livro buscarEntidade(Long id) {
        EntityManager entityManager = ConfigManager.getEntityInstance();

        Livro livroBusca =  entityManager.find(Livro.class, id);
        entityManager.close();

        return livroBusca;
    }

    @Override
    public Livro alterarEntidade(Livro livro) {
        EntityManager entityManager = ConfigManager.getEntityInstance();

        entityManager.getTransaction().begin();
        entityManager.merge(livro);
        entityManager.getTransaction().commit();
        entityManager.close();

        return livro;
    }

    @Override
    public void deletarEntidade(Livro livro) {
        EntityManager entityManager = ConfigManager.getEntityInstance();

        entityManager.getTransaction().begin();
        livro = entityManager.merge(livro);
        entityManager.remove(livro);
        entityManager.getTransaction().commit();
    }

    @Override
    public Collection<Livro> buscarTodos() {
        EntityManager entityManager = ConfigManager.getEntityInstance();

        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Livro> query = builder.createQuery(Livro.class);
            Root<Livro> root = query.from(Livro.class);
            query.select(root);

            return entityManager.createQuery(query).getResultList();
        } finally {
          entityManager.close();
        }
    }

    @Override
    public Livro buscarPorTitulo(String titulo) {
        EntityManager entityManager = ConfigManager.getEntityInstance();

        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Livro> query = builder.createQuery(Livro.class);
            Root<Livro> root = query.from(Livro.class);
            query.select(root).where(builder.equal(root.get("titulo"), titulo));

            TypedQuery<Livro> typedQuery = entityManager.createQuery(query);
            return typedQuery.getSingleResult();
        } finally {
            entityManager.close();
        }
    }
}
