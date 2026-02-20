package br.com.fabioperettig.designpatterns.jakarta;

import jakarta.inject.Inject;

/**
 * On the "market way" a Jakarta Class doesn't have a 'new' protocole,
 * just state that you need it, and Jakarta delivers.
 */
public class HealthController {

    @Inject
    private SystemHealthMonitorSTUDYFORM monitor;

    public void executeCheckup(){
        monitor.updateStatus("Data bank", "OPERATIONAL");
        monitor.printReport();
    }
}
