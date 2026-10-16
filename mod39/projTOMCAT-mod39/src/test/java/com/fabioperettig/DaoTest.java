package com.fabioperettig;

import com.fabioperettig.domain.Livro;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class DaoTest {

    private IGenericDAO<Livro, Long> livroDAO;
    private final Collection<Livro> safeDeleteList = new ArrayList<>();

    public DaoTest() {
        this.livroDAO = new LivroDAO();
    }

    @AfterEach
    public void safeDelete() {
        for (Livro livro : safeDeleteList) {
            this.livroDAO.deletarEntidade(livro);
        }
    }

    @Test
    public void cadastrarLivroTeste() {

        Livro livro = new Livro();
        livro.setCodigo(novoCodigo());
        livro.setAutor("J.R.R.Tolkien");
        livro.setTitulo("Contos Inacabados");
        livro.setSinopse("""
        Uma coletânea de histórias, rascunhos, ensaios e notas de J.R.R. Tolkien que não foram concluídos
        em vida e publicados postumamente por seu filho, Christopher Tolkien, em 1980
        """);
        livro.setNota(9.0);

        livroDAO.cadastrarEntidade(livro);
        safeDeleteList.add(livro);
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
        livro.setCodigo(novoCodigo());
        livro.setAutor("J.R.R.Tolkien");
        livro.setTitulo("Contos Inacabados");

        livroDAO.cadastrarEntidade(livro);
        safeDeleteList.add(livro);
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
        livro.setCodigo(novoCodigo());
        livro.setAutor("J.R.R.Tolkien");
        livro.setTitulo("Contos Inacabados");

        livroDAO.cadastrarEntidade(livro);
        safeDeleteList.add(livro);
        Assertions.assertNotNull(livro.getId());
        Livro result = livroDAO.buscarEntidade(livro.getId());
        Assertions.assertNotNull(result);
        Assertions.assertEquals(livro.getCodigo(), result.getCodigo());

        Long novoCodigo = novoCodigo();
        livro.setCodigo(novoCodigo);
        livroDAO.alterarEntidade(livro);
        Livro update = livroDAO.buscarEntidade(livro.getId());
        Assertions.assertNotNull(update);
        Assertions.assertEquals(novoCodigo, update.getCodigo());
    }

    @Test
    public void deletarLivroTeste() {
        Livro livro = new Livro();
        livro.setCodigo(novoCodigo());
        livro.setAutor("J.R.R.Tolkien");
        livro.setTitulo("Contos Inacabados");

        livroDAO.cadastrarEntidade(livro);
        safeDeleteList.add(livro);
        Assertions.assertNotNull(livro.getId());

        livroDAO.deletarEntidade(livro);
        Livro delete = livroDAO.buscarEntidade(livro.getId());
        Assertions.assertNull(delete);
        safeDeleteList.remove(livro);
    }

    @Test
    public void buscarTodosTeste() {
        int quantidadeInicial = livroDAO.buscarTodos().size();
        Livro l1 = novoLivro(novoCodigo(), "Tolkien", "Contos Inacabados");
        Livro l2 = novoLivro(novoCodigo(), "J.K.Rolling", "Harry Potter");
        Livro l3 = novoLivro(novoCodigo(), "Fabio Peretti", "Contos de CobbledCreek");

        Collection<Livro> livros = livroDAO.buscarTodos();
        Assertions.assertNotNull(livros);
        Assertions.assertEquals(quantidadeInicial + 3, livros.size());
        for (Livro criado : List.of(l1, l2, l3)) {
            Assertions.assertTrue(livros.stream().anyMatch(livro -> livro.getId().equals(criado.getId())));
        }


        for (Livro livro : List.of(l1, l2, l3)) {
            this.livroDAO.deletarEntidade(livro);
            safeDeleteList.remove(livro);
        }

        livros = livroDAO.buscarTodos();
        Assertions.assertNotNull(livros);
        Assertions.assertEquals(quantidadeInicial, livros.size());
    }

    @Test
    public void buscaCriteriaTeste() {
        Livro livro = novoLivro(novoCodigo(), "Eduardo Spohr", "A Batalha do Apocalipse - " + UUID.randomUUID());

        Livro result = livroDAO.buscarPorTitulo(livro.getTitulo());

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getTitulo(), livro.getTitulo());
    }


    ///auxiliar
    private Livro novoLivro(Long codigo, String autor, String titulo) {
        Livro livro = new Livro();
        livro.setCodigo(codigo);
        livro.setAutor(autor);
        livro.setTitulo(titulo);

        livroDAO.cadastrarEntidade(livro);
        safeDeleteList.add(livro);

        return livro;
    }

    /// gera um codigo randomizado
    private Long novoCodigo() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
}
