package com.fabioperettig.CLI;

import com.fabioperettig.DAO.FilmeDAO;
import com.fabioperettig.domain.Filme;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CadastarFilmeCommandTest {

    private final FilmeDAO filmeDAO = new FilmeDAO();

    @AfterEach
    void limparFilmes() {
        for (Filme filme : filmeDAO.buscarTodos()) {
            filmeDAO.deletarEntidade(filme);
        }
    }

    @Test
    void cadastroFilmeTest() {
        String codigo = UUID.randomUUID().toString();
        StringWriter erros = new StringWriter();

        CommandLine cli = new CommandLine(new PicocliCommnand());
        cli.setErr(new PrintWriter(erros));

        int resultado = cli.execute(
                "cadastrar",
                "--codigo", codigo,
                "--nome", "Alien",
                "--ano", "1979",
                "--categoria", "Ficção Científica",
                "--tempo", "117",
                "--nota", "8.5"
        );

        Assertions.assertEquals(CommandLine.ExitCode.OK, resultado, erros.toString());

        List<Filme> encontrados = filmeDAO.buscarTodos().stream()
                .filter(filme -> codigo.equals(filme.getCodigo()))
                .toList();

        assertEquals(1, encontrados.size());
        Filme salvo = encontrados.get(0);

        ///
        Assertions.assertAll(
                () -> assertNotNull(salvo.getId()),
                () -> assertEquals(codigo, salvo.getCodigo()),
                () -> assertEquals("Alien", salvo.getNome()),
                () -> assertEquals(Integer.valueOf(1979), salvo.getAnoLancamento()),
                () -> assertEquals("Ficção Científica", salvo.getCategoria()),
                () -> assertEquals(Integer.valueOf(117), salvo.getTempoEmMin()),
                () -> assertEquals(Double.valueOf(8.5), salvo.getNota())
        );
    }


    @Test
    void falhaCadastroTest() {
        StringWriter erros = new StringWriter();

        CommandLine cli = new CommandLine(new PicocliCommnand());
        cli.setErr(new PrintWriter(erros));

        int resultado = cli.execute(
                "cadastrar",
                "--codigo", "FILM001",
                "--nome", "Alien"
        );

        assertEquals(CommandLine.ExitCode.USAGE, resultado);
        assertTrue(erros.toString().contains("--tempo"));
    }
}