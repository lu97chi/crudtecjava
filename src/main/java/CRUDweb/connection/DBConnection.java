package CRUDweb.connection;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBConnection {
    public static Connection connect() {
		final String url = "jdbc:postgresql://localhost/CRUDWeb";
		final String user = "postgres";
		final String password = "eagle1997";
		Connection conn = null;
		try {
            conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected!");
		} catch (final SQLException e) {
			System.out.println("Cannot connect to database");
			System.out.println(e.getMessage());
		}
		return conn;
	}
}