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
            }

            option = JOptionPane.showInputDialog(null,
                    "Enter 1 to create, 2 to read, 3 to update," +
                            "4 to delete, or 5 to exit.",
                    "Register", JOptionPane.INFORMATION_MESSAGE);
        }

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

    private static void check


    private static boolean isValidOption(String option){
        return "1".equals(option) || "2".equals(option) || "3".equals(option) ||
                "4".equals(option)|| "5".equals(option);
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
