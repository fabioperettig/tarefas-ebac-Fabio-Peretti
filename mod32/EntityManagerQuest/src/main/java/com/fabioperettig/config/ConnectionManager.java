package com.fabioperettig.config;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.engine.spi.EntityUniqueKey;

import java.util.HashMap;
import java.util.Map;

public class ConnectionManager {

    private static volatile EntityManagerFactory emFactory;

    public static EntityManager getEntityManager() {

        if (emFactory == null) {
            synchronized (EntityManager.class) {
                if (emFactory == null) {
                    Dotenv dotenv = Dotenv.load();

                    Map<String, String> inputMap = new HashMap<>();
                    inputMap.put("jakarta.persistence.jdbc.url", dotenv.get("DB_URL"));
                    inputMap.put("jakarta.persistence.jdbc.user", dotenv.get("DB_USER"));
                    inputMap.put("jakarta.persistence.jdbc.password", dotenv.get("DB_PASS"));

                    emFactory = Persistence.createEntityManagerFactory("emquest", inputMap);
                }
            }
        }
        return emFactory.createEntityManager();
    }

}
