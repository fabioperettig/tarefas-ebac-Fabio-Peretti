package com.fabioperettig.DAO;

import java.util.Collection;

public interface IGenericDAO<T, ID> {
    public T cadastrarEntidade(T entity);
    public T buscarEntidadePorID(ID id);
    public T alterarEntidade(T entity);
    public void deletarEntidade(T entity);
    public Collection<T> buscarTodos();
    public T buscarPorTitulo(String nomeFilme);
}
