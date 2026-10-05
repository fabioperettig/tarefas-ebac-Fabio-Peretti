package com.fabioperettig.service;

import com.fabioperettig.DAO.FilmeDAO;
import com.fabioperettig.domain.Filme;

public class FilmeService {

    private final FilmeDAO filmeDAO;

    public FilmeService() {
        this.filmeDAO = new FilmeDAO();
    }

    public void cadastrar(Filme filme) {
        filmeDAO.cadastrarEntidade(filme);
    }

}
