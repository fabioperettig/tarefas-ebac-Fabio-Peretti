package com.fabioperettig.DAO;

import com.fabioperettig.config.MongoConnection;
import com.fabioperettig.domain.ClienteMorphia;
import dev.morphia.Datastore;
import dev.morphia.query.MorphiaCursor;
import dev.morphia.query.filters.Filters;
import org.bson.types.ObjectId;

import java.util.Collection;

public class DaoMongo implements IGenericDAO<ClienteMorphia, ObjectId> {

    @Override
    public ClienteMorphia cadastrarEntidade(ClienteMorphia cliente) {

        Datastore datastore = MongoConnection.getDatastore();
        cliente = datastore.save(cliente);
        return cliente;
    }

    @Override
    public ClienteMorphia buscarEntidadePorID(ObjectId id) {

        Datastore datastore = MongoConnection.getDatastore();
        ClienteMorphia cliente = datastore.find(ClienteMorphia.class)
                .filter(Filters.eq("_id", id)).first();

        return cliente;
    }

    @Override
    public ClienteMorphia alterarEntidade(ClienteMorphia cliente) {

        if (cliente.getId() == null) {
            throw new IllegalArgumentException("O cliente precisa ter ID para ser alterado.");
        }

        Datastore datastore = MongoConnection.getDatastore();
        cliente = datastore.save(cliente);
        return cliente;
    }

    @Override
    public void deletarEntidade(ClienteMorphia cliente) {

        if (cliente.getId() == null) {
            throw new IllegalArgumentException("O cliente precisa ter ID para ser excluído.");
        }

        Datastore datastore = MongoConnection.getDatastore();
        datastore.delete(cliente);
    }

    @Override
    public Collection<ClienteMorphia> buscarTodos() {

        Datastore datastore = MongoConnection.getDatastore();

        try (MorphiaCursor<ClienteMorphia> cursor = datastore.find(ClienteMorphia.class).iterator()) {
            return cursor.toList();
        }
    }
}
