package com.fabioperettig.repository;

import com.fabioperettig.domain.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
