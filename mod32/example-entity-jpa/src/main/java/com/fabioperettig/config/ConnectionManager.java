package com.fabioperettig.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class ConnectionManager {

    private static EntityManagerFactory managerFactory;

    public static EntityManager getEntityManager() {
        if (managerFactory == null) {
            synchronized (EntityManager.class) {
                if (managerFactory == null) {

                    String url = System.getenv("DB_URL");
                    String user = System.getenv("DB_USER");
                    String pass = System.getenv("DB_PASS");

                    Map<String, String> properties = new HashMap<>();
                    properties.put("jakarta.persistence.jdbc.url", url);
                    properties.put("jakarta.persistence.jdbc.user", user);
                    properties.put("jakarta.persistence.jdbc.pass", pass);

                    managerFactory = Persistence.createEntityManagerFactory("firstJPA", properties);
                }
            }
        }
        return managerFactory.createEntityManager();
    }

}
