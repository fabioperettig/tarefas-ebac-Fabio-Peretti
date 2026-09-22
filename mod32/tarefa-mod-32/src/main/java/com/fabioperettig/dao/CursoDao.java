package com.fabioperettig.dao;

import com.fabioperettig.config.ConnectionManager;
import com.fabioperettig.domain.Curso;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CursoDao implements ICursoDao {
    @Override
    public Curso create(Curso curso) {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(curso);
        entityManager.getTransaction().commit();

        entityManager.close();

        return curso;
    }

    @Override
    public Curso readById(Long id) {

        ///métodos de leitura não exige .begin() nem .commit();
        EntityManager entityManager = ConnectionManager.getEntityManager();
        Curso curso = entityManager.find(Curso.class, id);
        entityManager.close();

        return curso;
    }

    @Override
    public Curso update(Curso curso) {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        curso = entityManager.merge(curso);
        entityManager.getTransaction().commit();

        entityManager.close();

        return curso;
    }

    @Override
    public void delete(Curso curso) {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        curso = entityManager.merge(curso);
        entityManager.remove(curso);
        entityManager.getTransaction().commit();

        entityManager.close();

    }

    @Override
    public List<Curso> findAll() {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        List<Curso> cursos = entityManager.createQuery (
                "SELECT c FROM Curso c", Curso.class).getResultList();
        entityManager.close();

        return cursos;
    }
}
