import config.ClinicalReportReader;
import config.CureCredentials;
import config.DatabaseInitializer;
import config.ZombieOutbreakConfigDAO;
import io.github.cdimascio.dotenv.Dotenv;
import services.Controller;
import services.ZombieDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {

        DatabaseInitializer initializer = new DatabaseInitializer();
        initializer.initialize();

        try (Connection connection = openConnection()) {
            ClinicalReportReader reader = new ClinicalReportReader();
            CureCredentials credentials = reader.read();

            ZombieOutbreakConfigDAO configDAO = new ZombieOutbreakConfigDAO(connection);
            configDAO.updateCureCredentials(credentials);

            Controller input = new Controller();
            ZombieDAO zDAO = new ZombieDAO();

            zDAO.create(input.add());
        } catch (SQLException exception) {
            throw new RuntimeException(
                    "Could not connect to the PostgreSQL database.",
                    exception
            );
        }
    }

    private static Connection openConnection() throws SQLException {
        Dotenv dotenv = Dotenv.load();

        return DriverManager.getConnection(
                dotenv.get("URL"),
                dotenv.get("USER"),
                dotenv.get("PASS")
        );
    }
}
