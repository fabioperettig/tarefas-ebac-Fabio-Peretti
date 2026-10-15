package com.fabioperettig.dao;

import com.fabioperettig.config.ConfigManager;
import com.fabioperettig.domain.Livro;
import jakarta.persistence.EntityManager;

import java.util.Collection;
import java.util.List;

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
        return null;
    }

    @Override
    public Livro alterarEntidade(Livro livro) {
        return null;
    }

    @Override
    public void deletarEntidade(Livro livro) {

    }

    @Override
    public Collection<Livro> buscarTodos() {
        return List.of();
    }

    @Override
    public Livro buscarPorTitulo(String titulo) {
        return null;
    }
}
