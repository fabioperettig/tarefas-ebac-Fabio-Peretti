package com.fabioperettig;

import com.fabioperettig.domain.Livro;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class DaoTest {

    private IGenericDAO<Livro, Long> livroDAO;
    private Livro livroCadastrado;

    public DaoTest() {
        this.livroDAO = new LivroDAO();
    }

    @AfterEach
    public void safeDelete() {
        if (livroCadastrado != null) {
            livroDAO.deletarEntidade(livroCadastrado);
        }
    }

    @Test
    public void cadastrarLivroTeste() {

        Livro livro = new Livro();
        livro.setCodigo(1L);
        livro.setAutor("J.R.R.Tolkien");
        livro.setTitulo("Contos Inacabados");
        livro.setSinopse("""
        Uma coletânea de histórias, rascunhos, ensaios e notas de J.R.R. Tolkien que não foram concluídos
        em vida e publicados postumamente por seu filho, Christopher Tolkien, em 1980
        """);
        livro.setNota(9.0);

        livroCadastrado = livroDAO.cadastrarEntidade(livro);
        Assertions.assertNotNull(livro.getId());
        Livro result = livroDAO.buscarEntidade(livro.getId());

        Assertions.assertNotNull(result);
        Assertions.assertEquals(livro.getId(), result.getId());
        Assertions.assertEquals("Contos Inacabados", result.getTitulo());
        Assertions.assertEquals(livro.getSinopse(), result.getSinopse());

    }

    @Test
    public void buscarLivroTeste() {
        Livro livro = new Livro();
        livro.setCodigo(1L);
        livro.setAutor("J.R.R.Tolkien");
        livro.setTitulo("Contos Inacabados");

        livroCadastrado = livroDAO.cadastrarEntidade(livro);
        Assertions.assertNotNull(livro.getId());
        Livro result = livroDAO.buscarEntidade(livro.getId());

        Assertions.assertNotNull(result);
        Assertions.assertEquals(livro.getId(), result.getId());
        Assertions.assertEquals("Contos Inacabados", result.getTitulo());
        Assertions.assertEquals(livro.getSinopse(), result.getSinopse());
    }

    @Test
    public void alterarLivroTeste() {
        Livro livro = new Livro();
        livro.setCodigo(1L);
        livro.setAutor("J.R.R.Tolkien");
        livro.setTitulo("Contos Inacabados");

        livroCadastrado = livroDAO.cadastrarEntidade(livro);
        Assertions.assertNotNull(livro.getId());
        Livro result = livroDAO.buscarEntidade(livro.getId());
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1L, result.getCodigo());

        livro.setCodigo(2L);
        livroDAO.alterarEntidade(livro);
        Livro update = livroDAO.buscarEntidade(livro.getId());
        Assertions.assertNotNull(update);
        Assertions.assertEquals(2L, update.getCodigo());
    }

}
