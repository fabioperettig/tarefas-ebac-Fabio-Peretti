package config;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseInitializer {

    private final Dotenv dotenv = Dotenv.load();
    private final String url =dotenv.get("URL");
    private final String user = dotenv.get("USER");
    private final String password = dotenv.get("PASS");

    public void initialize() {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            executeScript(connection, "/sql/001_create_character_table.sql");
            executeScript(connection,"/sql/002_create_zombie_trigger.sql");

            System.out.println("Database initialized successfully.");

        } catch (SQLException | IOException exception) {
            throw new RuntimeException(
                    "Could not initialize the database.",
                    exception
            );
        }
    }

    private void executeScript(Connection connection,String resourcePath) throws IOException, SQLException {
        String sql = readResource(resourcePath);

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    private String readResource(String resourcePath)
            throws IOException {

        try (InputStream inputStream = getClass().getResourceAsStream(resourcePath)) {

            if (inputStream == null) {
                throw new IllegalStateException("SQL file not found: " + resourcePath);
            }

            return new String(
                    inputStream.
                    readAllBytes(),
                    StandardCharsets.UTF_8
            );
        }
    }
}
