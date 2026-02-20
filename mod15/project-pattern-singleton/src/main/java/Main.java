import br.com.fabioperettig.designpatterns.jakarta.HealthController;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class Main {

    public static void main(String[] args) {
        String service = "default value";
        String status = "offline";

        System.out.println("––– INIT –––");

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()){
            HealthController c1 = container.select(HealthController.class).get();
            HealthController c2 = container.select(HealthController.class).get();

            c1.executeCheckup();
            c2.executeCheckup();

        }

        System.out.println("––– END –––");

        /*
        SystemHealthMonitor monitor = SystemHealthMonitor.getInstance();
        monitor.updateStatus(service,status);

        monitor.printReport();*/
    }

}