package com.fabioperettig.dao;

import java.util.Collection;

public interface IGenericDAO<T, ID> {
    public T cadastrarEntidade(T entity);
    public T buscarEntidade(ID id);
    public T alterarEntidade(T entity);
    public void deletarEntidade(T entity);
    public Collection<T> buscarTodos();
    public T buscarPorTitulo(String titulo);
}
