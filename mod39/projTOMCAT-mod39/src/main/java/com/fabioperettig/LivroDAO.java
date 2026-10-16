package com.fabioperettig;

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

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(livro);
            entityManager.getTransaction().commit();

            return livro;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Livro buscarEntidade(Long id) {
        EntityManager entityManager = ConfigManager.getEntityInstance();

        try {
            return entityManager.find(Livro.class, id);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Livro alterarEntidade(Livro livro) {
        EntityManager entityManager = ConfigManager.getEntityInstance();

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(livro);
            entityManager.getTransaction().commit();

            return livro;
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void deletarEntidade(Livro livro) {
        EntityManager entityManager = ConfigManager.getEntityInstance();

        try {
            entityManager.getTransaction().begin();
            livro = entityManager.merge(livro);
            entityManager.remove(livro);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            entityManager.close();
        }
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

// MODELO PADRÃO ROLLBACK JPA
//
//try {
//     manager.getTransaction().begin();
//
//     // Suas operações aqui (ex: manager.persist(objeto);)
//
//     manager.getTransaction().commit();
// } catch (Exception e) {
//     if (manager.getTransaction().isActive()) {
//         manager.getTransaction().rollback(); // Desfaz as alterações no banco
//     }
//     e.printStackTrace();
// } finally {
//     if (manager != null && manager.isOpen()) {
//         manager.close(); // Fecha o EntityManager
//     }
//     if (factory != null && factory.isOpen()) {
//         factory.close();
//     }
// }