package com.fabioperettig.controller;

import com.fabioperettig.domain.Produto;
import com.fabioperettig.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    private ResponseEntity<Produto> cadastrar(@Valid @RequestBody Produto produto) {
        Produto produtoCadastro = produtoService.cadastrar(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCadastro);
    }
}
