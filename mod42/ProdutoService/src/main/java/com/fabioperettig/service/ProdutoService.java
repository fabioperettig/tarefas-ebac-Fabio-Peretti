package com.fabioperettig.service;

import com.fabioperettig.domain.Produto;
import com.fabioperettig.repository.IProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final IProdutoRepository iProdutoRepository;



    public ProdutoService(IProdutoRepository iProdutoRepository) {
        this.iProdutoRepository = iProdutoRepository;
    }

    public Produto cadastrar(Produto produto) {
        return iProdutoRepository.insert(produto);
    }

    public Produto buscarPorId(String id) {
        return iProdutoRepository.findById(id).orElseThrow();
    }

    public Produto buscarPorCodigo(String codigo) {
        return iProdutoRepository.findByCodigo(codigo).orElseThrow();
    }

    public Produto atualizar(Produto produto) {
        return iProdutoRepository.save(produto);
    }

    public void deletarPorId(String id) {
        iProdutoRepository.deleteById(id);
    }

    public Page<Produto> buscarTodos(Pageable pageable) {
        return iProdutoRepository.findAll(pageable);
    }
}
