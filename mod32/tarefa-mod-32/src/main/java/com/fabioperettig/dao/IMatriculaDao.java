package com.fabioperettig.dao;

import com.fabioperettig.domain.Matricula;
import com.fabioperettig.domain.Curso;

import java.util.List;

public interface IMatriculaDao {

    public Matricula create(Matricula matricula);
    public Matricula readById(Long id);
    public Matricula update(Matricula matricula);
    public void delete(Matricula matricula);

    public List<Matricula> findAll();
    public List<Curso> findByFilter(String nome, String codigo, String categoria);
}
