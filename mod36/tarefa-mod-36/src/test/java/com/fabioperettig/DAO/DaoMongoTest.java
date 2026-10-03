package com.fabioperettig.DAO;

import com.fabioperettig.domain.ClienteMorphia;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


public class DaoMongoTest {

    private IGenericDAO<ClienteMorphia, ObjectId> daoMongo = new DaoMongo();

    @AfterEach
    public void removerClientes() {
    }

    @Test
    public void cadastrarEntidadeTeste() {
    }

    @Test
    public void buscarEntidadeTest() {
    }

    @Test
    public void alterarEntidadeTeste() {
    }

    @Test
    public void deletarEntidadeTeste() {
    }

    @Test
    public void buscarTodosTeste() {
    }
}
