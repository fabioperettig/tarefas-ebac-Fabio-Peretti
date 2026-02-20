package br.com.fabioperettig.designpatterns.jakarta;


import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.Map;


/**
 * When it's using Jakarta, @ApplicationScoped determine
 * an instance as @Singleton form.
 */
@ApplicationScoped
public class SystemHealthMonitorSTUDYFORM {

    private Map<String, String> serviceStatues;

    @PostConstruct
    public void init() {
        this.serviceStatues = new HashMap<>();
        System.out.println("[INFO] Health monitor initialized CDI.");
    }

    public void updateStatus(String service, String status) {
        serviceStatues.put(service, status);
    }

    public void printReport() {
        System.out.println("\n––– HEALTH SYSTEM JAKARTA REPORT –––");
        serviceStatues.forEach((service, status) ->
                System.out.println("> " + service + ": " + status));
    }

}