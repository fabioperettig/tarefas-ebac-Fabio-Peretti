package com.fabioperettig.repository;

import com.fabioperettig.domain.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IProdutoRepository extends MongoRepository<Produto, String> {

    Optional<Produto> findByCodigo(String codigo);

}
