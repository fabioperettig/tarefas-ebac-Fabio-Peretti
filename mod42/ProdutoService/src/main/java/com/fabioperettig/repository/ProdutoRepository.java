package com.fabioperettig.repository;

import com.fabioperettig.domain.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
}
