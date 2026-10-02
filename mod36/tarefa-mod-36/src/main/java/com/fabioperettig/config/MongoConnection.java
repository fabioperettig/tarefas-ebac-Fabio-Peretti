package com.fabioperettig.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.config.MorphiaConfig;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.List;

public class MongoConnection {

    private static MongoClient mongoClient;
    private static volatile Datastore mongoDatastore;

    public static Datastore getDatastore() {

        if (mongoDatastore == null) {
            synchronized (MongoConnection.class) {
                if (mongoDatastore == null) {

                    ///MongoDB já contém USER e PASS embutidas na URI
                    Dotenv dotenv = Dotenv.load();
                    String uri = dotenv.get("MONGO_URI");
                    mongoClient = MongoClients.create(uri);

                    MorphiaConfig mConfig = MorphiaConfig
                            .load().database("mongodb")
                            .packages(List.of("com.fabioperettig.domain"));

                    mongoDatastore = Morphia.createDatastore(mongoClient, mConfig);
                }
            }
        }
        return mongoDatastore;
    }
}
