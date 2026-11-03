package com.fabioperettig.controller;

import com.fabioperettig.domain.Produto;
import com.fabioperettig.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    @Operation(summary = "Registrar um novo produto")
    public ResponseEntity<Produto> cadastrar(@Valid @RequestBody Produto produto) {
        Produto produtoCadastro = produtoService.cadastrar(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCadastro);
    }

    @GetMapping(value = "/id/{id}")
    @Operation(summary = "Buscar um produto pelo id")
    public ResponseEntity<Produto> buscarPorId(@PathVariable(value = "id", required = true)String id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    @GetMapping(value = "/codigo/{codigo}")
    @Operation(summary = "Buscar um produto pelo codigo")
    public ResponseEntity<Produto> buscarPorCodigo(@PathVariable(value = "codigo", required = true)String codigo) {
        return ResponseEntity.ok(produtoService.buscarPorCodigo(codigo));
    }

    @GetMapping
    public ResponseEntity<Page<Produto>> buscarTodos(Pageable pageable) {
        return ResponseEntity.ok(produtoService.buscarTodos(pageable));
    }

    @PutMapping
    @Operation(summary = "Atualizar um produto")
    public ResponseEntity<Produto> atualizar(@Valid @RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.atualizar(produto));
    }

    @DeleteMapping(value = "/delete/{id}")
    @Operation(summary = "Remover um produto pelo id")
    public ResponseEntity<String> remover(@PathVariable(value = "id") String id) {
        produtoService.deletarPorId(id);
        return ResponseEntity.ok("Produto removido");
    }
}
