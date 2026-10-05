package com.fabioperettig.CLI;

import com.fabioperettig.domain.Filme;
import com.fabioperettig.service.FilmeService;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
        name = "cadastrar",
        description = "Cadastra um novo filme"
)
public class CadastarFilmeCommand implements Runnable {

    private final FilmeService filmeService = new FilmeService();

    @Option(
            names = {"-c", "--codigo"},
            required = true,
            description = "Código único do filme"
    )
    private String codigo;

    @Option(
            names = {"-n", "--nome"},
            required = true,
            description = "Nome do filme"
    )
    private String nome;

    @Option(
            names = {"-a", "--ano"},
            description = "Ano de lançamento"
    )
    private Integer anoLancamento;

    @Option(
            names = {"--categoria"},
            description = "Categoria do filme"
    )
    private String categoria;

    @Option(
            names = {"-t", "--tempo"},
            required = true,
            description = "Duração do filme em minutos"
    )
    private Integer tempoEmMin;

    @Option(
            names = {"--nota"},
            description = "Nota do filme"
    )
    private Double nota;

    @Override
    public void run() {
        Filme filme = new Filme();

        filme.setCodigo(codigo);
        filme.setNome(nome);
        filme.setAnoLancamento(anoLancamento);
        filme.setCategoria(categoria);
        filme.setTempoEmMin(tempoEmMin);
        filme.setNota(nota);

        filmeService.cadastrar(filme);
        System.out.println("Filme cadastrado com sucesso!");
        System.out.println("-----------------------------");
        System.out.println(filme);
    }
}
