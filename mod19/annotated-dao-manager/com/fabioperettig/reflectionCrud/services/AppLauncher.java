package com.fabioperettig.reflectionCrud.services;

import com.fabioperettig.reflectionCrud.dao.ClientDAO;
import com.fabioperettig.reflectionCrud.dao.IProductDAO;
import com.fabioperettig.reflectionCrud.dao.ProductDAO;
import com.fabioperettig.reflectionCrud.dao.IClientDAO;
import com.fabioperettig.reflectionCrud.dao.generic.IGenericDAO;
import com.fabioperettig.reflectionCrud.domain.Client;
import com.fabioperettig.reflectionCrud.domain.Persistent;
import com.fabioperettig.reflectionCrud.factory.ConcreteFactory;
import com.fabioperettig.reflectionCrud.factory.FactoryPersistent;
import com.fabioperettig.reflectionCrud.factory.IFactory;

import javax.swing.*;

public class AppLauncher {

    private static IClientDAO iClientDAO;
    private static IProductDAO iProductDAO;

    public void appLauncher(){

        String clientProductMsg = "Enter '1' for Client or '2' for Product";

        String optMenu = JOptionPane.showInputDialog(null,
                clientProductMsg,
                "Menu", JOptionPane.INFORMATION_MESSAGE);

        while (!isValidOption(optMenu)){

            if ("".equals(optMenu)){
                exit();
            }
            optMenu = JOptionPane.showInputDialog(null,
                    "Invalid option. Enter 1 to Create, 2 to Read," +
                            "3 to Update, 4 to Delete, or 5 to Exit.",
                    "Green Dinner",JOptionPane.INFORMATION_MESSAGE);
        }

        while (isValidOption(optMenu)){

            String title = optMenu.equals("1") ? "Client board" : "Product board";

            String option = JOptionPane.showInputDialog(null,
                    "Enter 1 to Create, 2 to Read, 3 to Update," +
                            "4 to Delete, or 5 to Exit.", title, JOptionPane.INFORMATION_MESSAGE);

            executeOption(option, optMenu);

            optMenu = JOptionPane.showInputDialog(null, clientProductMsg,
                    "Register", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    private static void executeOption(String option, String optMenu){

        switch (option) {
            case "1" -> createOption(optMenu);
            case "2" -> readOption(optMenu);
            case "3" -> updateOption(optMenu);
            case "4" -> deleteOption(optMenu);
            case "5" -> exit();

            default -> System.out.println("Invalid option.");
        }

    }



    private static void createOption(String optMenu){

        String message = optMenu.equals("1")
                ? "Enter the Client's information separated by commas: name,id,country."
                : "Enter the Product's information separated by commas: name,id,brand.";

        String data = JOptionPane.showInputDialog(null, message,
                "Register", JOptionPane.INFORMATION_MESSAGE);

        register(data, optMenu);
    }

    private static void register(String data, String optMenu) {

        String[] arrayData = data.split(",");
        Persistent persistent = createConcreteObj(arrayData, optMenu);
        Boolean isRegistered = registerObj(optMenu, persistent);


        String registerMsg = isRegistered
                ? "Client created with success!"
                : "Client is already registered.";

        JOptionPane.showMessageDialog(null, registerMsg,
                "Status", JOptionPane.INFORMATION_MESSAGE);
    }

    private static Persistent createConcreteObj(String[] arrayData, String optMenu){
        IFactory factory = new ConcreteFactory();
        FactoryPersistent factoryPersistent = factory.createFabric(optMenu);
        return  factoryPersistent.createObject(arrayData);
    }

    private static Boolean registerObj(String optMenu, Persistent persistent){
        return getDAO(optMenu).create(persistent);
    }



    private static void readOption(String optMenu){
        String message = optMenu.equals("1")
                ? "Enter the Client's id"
                : "Enter the Product's code";

        String data = JOptionPane.showInputDialog(null, message,
                "Consult", JOptionPane.INFORMATION_MESSAGE);

        Persistent persistent = checkObj(data, optMenu);

        String registerMsg = (persistent != null)
                ? "Data found: " + persistent.toString()
                : "Data not found.";

        JOptionPane.showMessageDialog(null, registerMsg,
                "Status", JOptionPane.INFORMATION_MESSAGE);

    }

    private static Persistent checkObj (String data, String optMenu){
        return getDAO(optMenu).read(Long.parseLong(data));
    }



    private static void updateOption(String optMenu){
        String data = JOptionPane.showInputDialog(null,
                "Enter the new information separated by commas.",
                "Update", JOptionPane.INFORMATION_MESSAGE);

        String[] arrayData = data.split(",");
        Client client = new Client(arrayData[0], Long.valueOf(arrayData[1]), arrayData[2]);
        iClientDAO.update(client);
        JOptionPane.showMessageDialog(null, "Data updated successfully.",
                "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void deleteOption(String optMenu){
        String msg = optMenu.equals("1")
                ? "Enter the Client's id"
                : "Enter the Product's code";

        String data = JOptionPane.showInputDialog(null, msg,
                "Delete", JOptionPane.INFORMATION_MESSAGE);

        getDAO(optMenu).delete(Long.parseLong(data));

        JOptionPane.showMessageDialog(null, "Record deleted.",
                "Success", JOptionPane.INFORMATION_MESSAGE);
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

    private static boolean isRead(String option) {
        return "2".equals(option);
    }

    private static boolean isUpdate(String option) {
        return "3".equals(option);
    }

    private static boolean isDelete(String option) {
        return "4".equals(option);
    }

    private static boolean isExit(String option) {
        return "4".equals(option);
    }

    private static boolean isValidOption(String option){
        return "1".equals(option) || "2".equals(option) ||
                "3".equals(option) || "4".equals(option)||
                "5".equals(option);
    }

    private static boolean isMenuValidOption(String optMenu){
        return "1".equals(optMenu)||"2".equals(optMenu);
    }

    private static void startDAO(){
        iClientDAO = new ClientDAO();
        iProductDAO = new ProductDAO();
    }

    public static IGenericDAO getDAO(String optMenu){
        return optMenu.equals("1") ? iClientDAO : iProductDAO;
    }

    private static void exit() {
        JOptionPane.showMessageDialog(null, "Goodbye:",
                "Exit", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

}
