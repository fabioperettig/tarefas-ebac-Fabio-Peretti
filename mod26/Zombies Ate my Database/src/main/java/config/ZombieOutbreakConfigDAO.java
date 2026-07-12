package config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ZombieOutbreakConfigDAO {

    private final Connection connection;

    public ZombieOutbreakConfigDAO(Connection connection) {
        this.connection = connection;
    }

    public void updateCureCredentials(CureCredentials credentials) {
        String sql = """
                UPDATE zombie_outbreak_config
                SET doctor_name = ?,
                    credential_number = ?
                WHERE config_id = 1
                """;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,credentials.doctorName());
            statement.setInt(2,credentials.credentialNumber());
            statement.executeUpdate();

        } catch (SQLException exception){
            throw new RuntimeException("Could not update cure credentials.", exception);
        }
    }
}
