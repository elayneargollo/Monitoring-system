package ifba.ads.controll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {

	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:h2:" + "./database/unidadeMovel", "sa", "");
		return conn;
	}
	
}
