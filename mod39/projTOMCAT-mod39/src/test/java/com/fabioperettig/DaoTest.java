package com.fabioperettig;

import com.fabioperettig.domain.Livro;
import org.junit.jupiter.api.AfterEach;

import java.util.Collection;

public class DaoTest {

    private IGenericDAO<Livro, Long> livroDAO;

    public DaoTest() {
        this.livroDAO = new LivroDAO();
    }

    @AfterEach
    public void safeDelete() throws Exception {
        Collection<Livro> livroCollection = livroDAO.buscarTodos();
        livroCollection.forEach(livro -> {
            try {
                livroDAO.deletarEntidade(livro);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
