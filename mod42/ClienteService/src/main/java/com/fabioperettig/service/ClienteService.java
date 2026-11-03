package com.fabioperettig.service;

import com.fabioperettig.domain.Cliente;
import com.fabioperettig.repository.ClienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    /// Injeção de Dependência
    /// Dois ou mais construtores == uso de @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrar(Cliente cliente) {
        return clienteRepository.insert(cliente);
    }

    public Cliente buscarPorId(String id) {
        return clienteRepository.findById(id).orElseThrow();
    }

    public Cliente buscarPorCpf(Long cpf) {
        return clienteRepository.findByCpf(cpf).orElseThrow();
    }

    ///save == update
    public Cliente atualizar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deletarPorId(String id) {
        clienteRepository.deleteById(id);
    }

    public Page<Cliente> buscarTodos(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }
}
