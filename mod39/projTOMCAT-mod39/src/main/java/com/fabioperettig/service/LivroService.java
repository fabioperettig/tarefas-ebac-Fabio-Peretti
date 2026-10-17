package com.fabioperettig.service;

import com.fabioperettig.dao.IGenericDAO;
import com.fabioperettig.domain.Livro;

import java.util.Collection;
import java.util.Optional;

public class LivroService implements IService<Livro, Long> {

    private final IGenericDAO<Livro, Long> livroDAO;

    public LivroService(IGenericDAO<Livro, Long> livroDAO) {
        this.livroDAO = livroDAO;
    }

    @Override
    public Livro create(Livro livro) {
        return livroDAO.cadastrarEntidade(livro);
    }

    @Override
    public Optional<Livro> findById(Long id) {
        return Optional.ofNullable(livroDAO.buscarEntidade(id));
    }

    @Override
    public Livro update(Livro livro) {
        return livroDAO.alterarEntidade(livro);
    }

    @Override
    public void delete(Livro livro) {
        livroDAO.deletarEntidade(livro);
    }

    @Override
    public Collection<Livro> findAll() {
        return livroDAO.buscarTodos();
    }

    @Override
    public Optional<Livro> findByTitle(String titulo) {
        return Optional.ofNullable(livroDAO.buscarPorTitulo(titulo));
    }
}
