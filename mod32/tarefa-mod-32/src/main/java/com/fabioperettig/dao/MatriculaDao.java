package com.fabioperettig.dao;

import com.fabioperettig.config.ConnectionManager;
import com.fabioperettig.domain.Curso;
import com.fabioperettig.domain.Matricula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatriculaDao implements IMatriculaDao {
    @Override
    public Matricula create(Matricula matricula) {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(matricula);
        entityManager.getTransaction().commit();

        return matricula;
    }

    @Override
    public Matricula readById(Long id) {

        EntityManager entityManager = ConnectionManager.getEntityManager();
        Matricula matricula = entityManager.find(Matricula.class, id);
        entityManager.close();

        return matricula;
    }


    @Override
    public Matricula update(Matricula matricula) {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        matricula = entityManager.merge(matricula);
        entityManager.getTransaction().commit();

        entityManager.close();

        return matricula;
    }

    @Override
    public void delete(Matricula matricula) {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        matricula = entityManager.merge(matricula);
        entityManager.remove(matricula);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public List<Matricula> findAll() {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        List<Matricula> matriculas = entityManager.createQuery(
                "SELECT m FROM Matricula m", Matricula.class).getResultList();
        entityManager.close();

        return matriculas;
    }

    @Override
    public List<Curso> findByFilter(String nome, String codigo, String categoria) {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        StringBuilder stringBuilder = new StringBuilder("SELECT c FROM Curso c WHERE 1=1 ");
        Map<String, Object> param = new HashMap<>();

        if (nome != null && !nome.isBlank()) {
            stringBuilder.append("AND LOWER(c.nome) LIKE LOWER(:nome) ");
            param.put("nome", "%" + nome + "%");
        }

        if (codigo != null && !codigo.isBlank()) {
            stringBuilder.append("AND c.codigo = :codigo ");
            param.put("codigo", codigo);
        }

        if (categoria != null && !categoria.isBlank()) {
            stringBuilder.append("AND c.categoria = :categoria ");
            param.put("categoria", categoria);
        }

        TypedQuery<Curso> query = entityManager.createQuery(stringBuilder.toString(), Curso.class);

        param.forEach(query::setParameter);

        List<Curso> cursos = query.getResultList();
        entityManager.close();

        return cursos;
    }

}
