import com.fabioperettig.crud.dao.ClientDAO;
import com.fabioperettig.crud.dao.IClientDAO;

import javax.swing.*;

public class Main {

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

    }

}
