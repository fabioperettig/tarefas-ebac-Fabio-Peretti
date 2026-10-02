package com.fabioperettig.config;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class EntityManagerJPA {

    private static volatile EntityManagerFactory emFactory;

    public static EntityManager getEntitymanager() {

        if (emFactory == null) {
            synchronized (EntityManagerJPA.class) {
                if (emFactory == null) {
                    Dotenv dotenv = Dotenv.load();

                    String url = dotenv.get("DB_URL");
                    String user = dotenv.get("DB_USER");
                    String pass = dotenv.get("DB_PASS");

                    Map<String, String> input = new HashMap<>();
                    input.put("jakarta.persistence.jdbc.url", url);
                    input.put("jakarta.persistence.jdbc.user", user);
                    input.put("jakarta.persistence.jdbc.password", pass);

                    emFactory = Persistence.createEntityManagerFactory("postgresdb", input);

                }
            }
        }
         return emFactory.createEntityManager();
    }
}
