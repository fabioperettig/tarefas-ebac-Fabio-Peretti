package com.fabioperettig.dao;

import com.fabioperettig.config.ConnectionManager;
import com.fabioperettig.domain.Curso;
import com.fabioperettig.domain.Matricula;
import com.fabioperettig.domain.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProdutoDao implements IProdutoDao {

    @Override
    public Produto create(Produto produto) {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();
        entityManager.close();

        return produto;
    }

    @Override
    public Produto readById(Long id) {

        EntityManager entityManager = ConnectionManager.getEntityManager();
        Produto produto = entityManager.find(Produto.class, id);
        entityManager.close();

        return produto;
    }

    @Override
    public Produto update(Produto produto) {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        produto = entityManager.merge(produto);
        entityManager.getTransaction().commit();
        entityManager.close();

        return produto;
    }

    @Override
    public void delete(Produto produto) {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        entityManager.getTransaction().begin();
        produto = entityManager.merge(produto);
        entityManager.remove(produto);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public List<Produto> findAll() {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        List<Produto> produtos = entityManager.createQuery(
                "SELECT m FROM Produto m", Produto.class).getResultList();
        entityManager.close();

        return produtos;
    }

    public Produto findByCode(String codigoProduto) {

        EntityManager entityManager = ConnectionManager.getEntityManager();

        String jpql = "SELECT p FROM Produto p WHERE p.codigo = :codigo";

        TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);

        query.setParameter("codigo", codigoProduto);

        Produto produto = query.getSingleResult();
        entityManager.close();

        return produto;
    }
}
