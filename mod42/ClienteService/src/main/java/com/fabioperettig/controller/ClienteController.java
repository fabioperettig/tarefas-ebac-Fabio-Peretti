package com.fabioperettig.controller;

import com.fabioperettig.domain.Cliente;
import com.fabioperettig.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@Valid @RequestBody Cliente cliente) {
        Cliente clienteCadastro = clienteService.cadastrar(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCadastro);
    }

    @GetMapping(value = "/id/{id}")
    @Operation(summary = "Busca um cliente pelo id")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable(value = "id", required = true) String id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @GetMapping(value = "/cpf/{cpf}")
    @Operation(summary = "Busca um cliente pelo cpf")
    public ResponseEntity<Cliente> buscarPorCpf(@PathVariable(value = "cpf", required = true) Long cpf) {
        return ResponseEntity.ok(clienteService.buscarPorCpf(cpf));
    }

    @GetMapping
    public ResponseEntity<Page<Cliente>> buscarTodos(Pageable pageable) {
        return ResponseEntity.ok(clienteService.buscarTodos(pageable));
    }

    @PutMapping
    @Operation(summary = "Atualiza um cliente")
    public ResponseEntity<Cliente> atualizar(@Valid @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.atualizar(cliente));
    }

    @DeleteMapping(value = "/delete/{id}")
    @Operation(summary = "Remove um cliente pelo id")
    public ResponseEntity<String> remover(@PathVariable(value = "id") String id) {
        clienteService.deletarPorId(id);
        return ResponseEntity.ok("Cliente removido");
    }
}
