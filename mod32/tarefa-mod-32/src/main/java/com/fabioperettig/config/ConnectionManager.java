package com.fabioperettig.config;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class ConnectionManager {

    private static volatile EntityManagerFactory managerFactory;

    public static EntityManager getEntityManager() {
        if (managerFactory == null) {
            synchronized (EntityManager.class) {
                if (managerFactory == null) {
                    Dotenv dotenv = Dotenv.load();

                    String url = dotenv.get("DB_URL");
                    String user = dotenv.get("DB_USER");
                    String pass = dotenv.get("DB_PASS");

                    Map<String, String> propriedades = new HashMap<>();
                    propriedades.put("jakarta.persistence.jdbc.url", url);
                    propriedades.put("jakarta.persistence.jdbc.user", user);
                    propriedades.put("jakarta.persistence.jdbc.password", pass);

                    managerFactory = Persistence.createEntityManagerFactory("mod32DB", propriedades);
                }
            }
        }
        return managerFactory.createEntityManager();
    }
}
