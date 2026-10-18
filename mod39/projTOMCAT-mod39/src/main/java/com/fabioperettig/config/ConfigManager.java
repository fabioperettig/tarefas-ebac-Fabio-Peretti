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

        if (emFactory==null) {
            synchronized (ConfigManager.class) {
                if (emFactory==null) {

                    /// O Compose fornece variáveis de ambiente e não copia o .env para a imagem,
                    /// então este é o metodo necessário;
                    Dotenv env = Dotenv.configure().ignoreIfMissing().load();

                    String url = env.get("DB_URL");
                    String user = env.get("POSTGRES_USER");
                    String pass = env.get("POSTGRES_PASSWORD");

                    Map<String, String> prop = new HashMap<>();
                    prop.put("jakarta.persistence.jdbc.url", url);
                    prop.put("jakarta.persistence.jdbc.user", user);
                    prop.put("jakarta.persistence.jdbc.password", pass);

                    emFactory = Persistence.createEntityManagerFactory("postgresbookdb", prop);
                }
            }
        }
        return emFactory.createEntityManager();
    }
}
