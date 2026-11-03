package com.fabioperettig.service;

import com.fabioperettig.domain.Produto;
import com.fabioperettig.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto cadastrar(Produto produto) {
        return produtoRepository.insert(produto);
    }
}
