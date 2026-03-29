import com.fabioperettig.crud.dao.ClientDAO;
import com.fabioperettig.crud.dao.IClientDAO;
import com.fabioperettig.crud.domain.Client;

import javax.swing.*;

public class Main2 {

    private static IClientDAO iClientDAO;

    public static void main(String[] args) {

        iClientDAO = new ClientDAO();

        String option = JOptionPane.showInputDialog(null,
                "Enter 1 to create, 2 to read, 3 to update," +
                        "4 to delete, or 5 to exit.",
                "Register", JOptionPane.INFORMATION_MESSAGE);

        while (!isValidOption(option)) {
            if ("".equals(option)) {
                exit();
            }
            option = JOptionPane.showInputDialog(null,
                    "Invalid option. Enter 1 to create, 2 to read," +
                            "3 to update, 4 to delete, or 5 to exit.", "Green Dinner",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        while (isValidOption(option)){
            if (isExitOption(option)){
                exit();
            } else if (isCreate(option)) {
                String data = JOptionPane.showInputDialog(null,
                        "Enter the user's information separated by commas, as in the example: Name, ID, Country.",
                        "Register", JOptionPane.INFORMATION_MESSAGE);
                register(data);

            } else if (isRead(option)) {
                String data = JOptionPane.showInputDialog(null,
                "Enter the code", "Search", JOptionPane.INFORMATION_MESSAGE);
                check(data);

            } else if (isUpdate(option)) {
                String data = JOptionPane.showInputDialog(null,
                        "Enter the code", "Search", JOptionPane.INFORMATION_MESSAGE);
                update(data);

            } else if (isDelete(option)) {
                String data = JOptionPane.showInputDialog(null,
                        "Enter the code", "Search", JOptionPane.INFORMATION_MESSAGE);
                delete(data);
            }

            option = JOptionPane.showInputDialog(null,
                    "Enter 1 to create, 2 to read, 3 to update," +
                            "4 to delete, or 5 to exit.",
                    "Register", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static boolean isValidOption(String option){
        return "1".equals(option) || "2".equals(option) || "3".equals(option) ||
                "4".equals(option)|| "5".equals(option);
    }


    /**
     * Checks if the provided option corresponds to the 'create' action.
     *
     * <p>This implementation uses a direct return of the boolean expression
     * to simplify the logic and remove redundant conditional branches.</p>
     *
     * @param option The string input representing the user's choice.
     * @return {@code true} if the option equals "1"; {@code false} otherwise.
     */
    private static boolean isCreate(String option) {
        return "1".equals(option);
    }

    private static void register(String data){
        String[] arrayData = data.split(",");
        Client client = new Client(arrayData[0], Long.valueOf(arrayData[1]), arrayData[2]);
        Boolean isRegistered = iClientDAO.create(client);

        if (isRegistered) {
            JOptionPane.showMessageDialog(null, "Client created with success!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Client is already registered.",
                    "Failure", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static boolean isRead(String option) {
        return "2".equals(option);
    }

    private static void check (String data){
        Client client = iClientDAO.read(Long.parseLong(data));
        if (client != null) {
            JOptionPane.showMessageDialog(null, "Client found: "
                    + client.toString(),"Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Client not found.",
                    "Failure", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isUpdate(String option){
        return "3".equals(option);
    }

    private static void update (String option){
        String data = JOptionPane.showInputDialog(null,
                "Enter the user's information separated by commas, as in the example: Name, ID, Country.",
                "Update", JOptionPane.INFORMATION_MESSAGE);

        String[] arrayData = data.split(",");
        Client client = new Client(arrayData[0], Long.valueOf(arrayData[1]), arrayData[2]);

        iClientDAO.update(client);
        JOptionPane.showMessageDialog(null, "Client updated with success!",
                "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private static boolean isDelete(String option){
        return "4".equals(option);
    }

    private static void delete(String data){
        Client client = iClientDAO.read(Long.parseLong(data));
        if (client != null) {

        }
    }

    private static void check (String data){
        Client client = iClientDAO.read(Long.parseLong(data));
        if (client != null) {
            JOptionPane.showMessageDialog(null, "Client found: "
                    + client.toString(),"Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Client not found.",
                    "Failure", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isExitOption(String option) {
        return "5".equals(option);
    }

    private static void exit() {
        JOptionPane.showMessageDialog(null, "Goodbye:",
                "Exit", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

}
