package service;
import io.github.cdimascio.dotenv.Dotenv;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    Dotenv dotenv = Dotenv.load();

    private final String URL = "jdbc:postgresql://localhost:5432/firstPostgre";
    private final String USER = dotenv.get("USER");
    private final String PASS = dotenv.get("PASS");


    public void save (User user) {
        String sql = "INSERT INTO users (name, mail) VALUES (?, ?)";

        try(Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getName());
            statement.setString(2, user.getMail());
            statement.executeUpdate();

            System.out.printf("\nUser %s add.", user.getName());

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> list() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try(Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {

            while(resultSet.next()) {
                String name = resultSet.getString("name");
                String mail = resultSet.getString("mail");

                User user = new User(name, mail);
                userList.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }

    public void delete(String name) {
        String sql = "DELETE FROM users WHERE NAME = ?";

        try(Connection connection = DriverManager.getConnection(URL, USER, PASS);
        PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.executeUpdate();

            System.out.printf("\nUser %s deleted.", name);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
