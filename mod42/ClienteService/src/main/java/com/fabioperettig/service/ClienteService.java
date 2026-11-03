package com.fabioperettig.service;

import com.fabioperettig.domain.Cliente;
import com.fabioperettig.repository.IClienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final IClienteRepository iClienteRepository;

    /// Injeção de Dependência
    /// Dois ou mais construtores == uso de @Autowired
    public ClienteService(IClienteRepository iClienteRepository) {
        this.iClienteRepository = iClienteRepository;
    }

    public Cliente cadastrar(Cliente cliente) {
        return iClienteRepository.insert(cliente);
    }

    public Cliente buscarPorId(String id) {
        return iClienteRepository.findById(id).orElseThrow();
    }

    public Cliente buscarPorCpf(Long cpf) {
        return iClienteRepository.findByCpf(cpf).orElseThrow();
    }

    ///save == update
    public Cliente atualizar(Cliente cliente) {
        return iClienteRepository.save(cliente);
    }

    public void deletarPorId(String id) {
        iClienteRepository.deleteById(id);
    }

    public Page<Cliente> buscarTodos(Pageable pageable) {
        return iClienteRepository.findAll(pageable);
    }
}
