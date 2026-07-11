package services;
import io.github.cdimascio.dotenv.Dotenv;
import model.Character;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ZombieDAO {

    String SQL_LANGUAGE = "INSERT INTO character (name, hp) VALUES (?, ?)";

    Dotenv dotenv = Dotenv.load();

    private final String URL = "jdbc:postgresql://localhost:5432/zombiesatemyneighbors";
    private final String USER = dotenv.get("USER");
    private final String PASS = dotenv.get("PASS");

    public void create (Character character) {

        try (Connection connection = DriverManager.getConnection(URL,USER,PASS);
             PreparedStatement statement = connection.prepareStatement(SQL_LANGUAGE)) {

            statement.setString(1, character.getName());
            statement.setInt(2, character.getHP());
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
