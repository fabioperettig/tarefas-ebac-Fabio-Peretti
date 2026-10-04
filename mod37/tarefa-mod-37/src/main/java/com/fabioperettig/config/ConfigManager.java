package com.fabioperettig.config;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class ConfigManager {

    private static volatile EntityManagerFactory emFactory;

    public static EntityManager getEntityInstance() {

        if (emFactory == null) {
            synchronized (ConfigManager.class) {
                if (emFactory == null){

                    Dotenv env = Dotenv.load();

                    String url = env.get("DB_URL");
                    String user = env.get("DB_USER");
                    String pass = env.get("DB_PASS");

                    Map<String, String> prop = new HashMap<>();
                    prop.put("jakarta.persistence.jdbc.url", url);
                    prop.put("jakarta.persistence.jdbc.user", user);
                    prop.put("jakarta.persistence.jdbc.password", pass);

                    emFactory = Persistence.createEntityManagerFactory("postgresmovdb", prop);
                }
            }
        }

        return emFactory.createEntityManager();
    }

}
