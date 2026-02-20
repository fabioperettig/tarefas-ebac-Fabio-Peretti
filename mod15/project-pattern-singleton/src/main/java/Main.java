import br.com.fabioperettig.designpatterns.singleton.SystemHealthMonitor;

public class Main {

    public static void main(String[] args) {
        String service = "default value";
        String status = "offline";

        SystemHealthMonitor monitor = SystemHealthMonitor.getInstance();
        monitor.updateStatus(service,status);

        monitor.printReport();
    }

}