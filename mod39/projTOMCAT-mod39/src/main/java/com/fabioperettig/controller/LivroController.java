package com.fabioperettig.controller;

import com.fabioperettig.domain.Livro;
import com.fabioperettig.exception.CodigoDuplicadoExc;
import com.fabioperettig.service.IService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named("livroController") //Disponibiliza o bean no xhtml como #{livroController}
@ViewScoped
public class LivroController implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(LivroController.class.getName());

    @Inject
    private IService<Livro, Long> livroService;

    private List<Livro> livros;

    @PostConstruct
    public void init() {
        carregarLivros();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    /// Sessão de cadastro de Livro

    private Livro novoLivro = new Livro();

    public Livro getNovoLivro() {
        return novoLivro;
    }

    public void setNovoLivro(Livro novoLivro) {
        this.novoLivro = novoLivro;
    }

    public void salvar() {
        boolean editando = novoLivro.getId() != null;
        Livro salvarLivro = editando ? novoLivro : dadosParaCadastro(novoLivro);

        try {
            if (editando) {
                livroService.update(salvarLivro);
            } else {
                livroService.create(salvarLivro);
            }
        } catch (CodigoDuplicadoExc e) {
            FacesContext.getCurrentInstance().validationFailed();

            mensagem(
                    FacesMessage.SEVERITY_WARN,
                    "Código já cadastrado",
                    e.getMessage()
            );
            return;
        } catch (RuntimeException e) {
            LOG.log(Level.SEVERE, "Falha ao salvar livro.", e);

            FacesContext.getCurrentInstance().validationFailed();
            mensagem(FacesMessage.SEVERITY_ERROR,
                    "Não foi possível salvar",
                    "Confira os dados e tente novamente"
            );

            return;
        }

        novoLivro = new Livro();

        try {
            carregarLivros();
            mensagem(FacesMessage.SEVERITY_INFO,
                    "Sucesso", editando ? "Livro atualizado." : "Livro cadastrado."
            );
        } catch (RuntimeException e) {
            LOG.log(Level.WARNING, "Livro salvo, mas a listagem não pôde ser atualizada.", e);
            mensagem(FacesMessage.SEVERITY_WARN,
                    "Livro salvo",
                    "Não foi possível atualizar a listagem. Recarregue a página");
        }
    }

    public void editar(Livro livro) {
        Livro encontrado;

        try {
            encontrado = livroService
                    .findById(livro.getId())
                    .orElse(null);
        } catch (RuntimeException e) {
            LOG.log(Level.SEVERE, "Falha ao carregar livro para edição.", e);

            FacesContext.getCurrentInstance().validationFailed();

            mensagem(
                    FacesMessage.SEVERITY_ERROR,
                    "Não foi possível carregar o livro",
                    "Tente novamente."
            );

            return;
        }

        if (encontrado == null) {
            FacesContext.getCurrentInstance().validationFailed();

            mensagem(
                    FacesMessage.SEVERITY_WARN,
                    "Livro não encontrado",
                    "Recarregue a página para atualizar a listagem."
            );

            return;
        }

        novoLivro = encontrado;
    }


    public void deletar(Livro livro) {
        livroService.delete(livro);
        if (livro.getId().equals(novoLivro.getId())) {
            cancelar();
        }
        carregarLivros();

        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(
                        FacesMessage.SEVERITY_INFO,"Sucesso", "Livro removido."
                )
        );
    }

    public void cancelar() {
        novoLivro = new Livro();
    }

    /// auxiliares
    private void carregarLivros() {
        livros = new ArrayList<>(livroService.findAll());
    }

    private void mensagem(FacesMessage.Severity severidade, String resumo, String detalhe) {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(severidade, resumo, detalhe)
        );
    }

    private Livro dadosParaCadastro(Livro origem) {
        Livro copia = new Livro();

        copia.setCodigo(origem.getCodigo());
        copia.setTitulo(origem.getTitulo());
        copia.setAutor(origem.getAutor());
        copia.setSinopse(origem.getSinopse());
        copia.setNota(origem.getNota());

        return copia;
    }
}


