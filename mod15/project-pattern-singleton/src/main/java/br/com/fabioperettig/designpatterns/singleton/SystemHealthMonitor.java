package br.com.fabioperettig.designpatterns.singleton;

import java.util.HashMap;
import java.util.Map;


/**
 * A GoF-based project, made to compare coding with pure Singleton
 * pattern creation vs using Jakarta protocol.
 */
public class SystemHealthMonitor {

    //unics instance and data storage
    private static volatile SystemHealthMonitor systemHealthMonitor;
    private final Map<String, String> serviceStatues;

    //private constructor to prevent instantiation outside of this class
    private SystemHealthMonitor(){
        this.serviceStatues = new HashMap<>();

        System.out.println("[INFO] Health monitor initialized.");
    }

    //global access point which creates a final instance once
    public static SystemHealthMonitor getInstance(){
        if (systemHealthMonitor == null) {
            synchronized (SystemHealthMonitor.class) {
                if (systemHealthMonitor == null) {
                    systemHealthMonitor = new SystemHealthMonitor();
                }
            }
        }

        return systemHealthMonitor;

    }

    //access method
    public void updateStatus (String service, String status){
        serviceStatues.put(service, status);
        System.out.println("[LOG] Update " + service + "service to: " + status);
    }

    public void printReport() {
        System.out.println("\n––– HEALTH SYSTEM REPORT –––");
        serviceStatues.forEach((service, status) ->
                System.out.println("> " + service + ": " + status));
    }

}
