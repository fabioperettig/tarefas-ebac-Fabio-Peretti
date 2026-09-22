package com.fabioperettig.dao;

import com.fabioperettig.domain.Curso;

import java.util.List;

public interface ICursoDao {

    public Curso create(Curso curso);
    public Curso readById(Long id);
    public Curso update(Curso curso);
    public void delete(Curso curso);

    public List<Curso> findAll();
}
