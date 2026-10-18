package com.fabioperettig.dao;

import com.fabioperettig.config.ConfigManager;
import com.fabioperettig.domain.Livro;
import com.fabioperettig.exception.CodigoDuplicadoExc;
import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.exception.ConstraintViolationException;

import java.io.Serializable;
import java.util.Collection;

@Dependent
public class LivroDAO implements IGenericDAO<Livro, Long>, Serializable {

    private static final long serialVersionUID = 1L;
    private static final String CODIGO_DUPLICADO_EXC = "ukepbmm1dm38kh3jl100l32n6jj";

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

            if (isCodigoDuplicado(e)) {
                throw new CodigoDuplicadoExc(livro.getCodigo(), e);
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
            if (isCodigoDuplicado(e)) {
                throw new CodigoDuplicadoExc(livro.getCodigo(), e);
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
            throw e;
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
        } catch (NoResultException e) {
            return null;
        } finally {
            entityManager.close();
        }
    }

    ///auxiliares
    private boolean isCodigoDuplicado(Throwable erro) {
        Throwable causa = erro;

        while (causa != null) {

            if (causa instanceof ConstraintViolationException violacao) {
                boolean duplicidade =
                        "23505".equals(violacao.getSQLState());

                boolean restricaoDoCodigo =
                        CODIGO_DUPLICADO_EXC.equalsIgnoreCase(
                                violacao.getConstraintName()
                        );

                if (duplicidade && restricaoDoCodigo) {
                    return true;
                }
            }
            causa = causa.getCause();
        }
        return false;
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
