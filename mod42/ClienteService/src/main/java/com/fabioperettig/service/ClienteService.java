package com.fabioperettig.service;

import com.fabioperettig.domain.Cliente;
import com.fabioperettig.repository.ClienteRepository;
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
}
