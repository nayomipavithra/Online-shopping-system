import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Simple DB connection helper. Reads DB_URL, DB_USER, DB_PASS from environment variables
 * and falls back to sensible defaults. Change the defaults or set env vars as needed.
 */
public class DBConnection {
    private static final String URL = System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost:3306/onlineShopping?useSSL=false&serverTimezone=UTC");
    private static final String USER = System.getenv().getOrDefault("DB_USER", "root");
    private static final String PASS = System.getenv().getOrDefault("DB_PASS", "password");

    public static Connection getConnection() throws SQLException {
        try {
            // Ensure the driver class is loaded - modern JDBC drivers auto-register but this is safe
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found. Make sure the connector JAR is on the classpath.", e);
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
