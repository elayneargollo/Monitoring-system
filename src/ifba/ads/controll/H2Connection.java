package ifba.ads.controll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {

	public Connection getConnection() throws SQLException {

		System.out.println("Conectando ao banco de dados");

		Connection conn = DriverManager.getConnection("jdbc:h2:~/test\"", "root", "password");
		return conn;
	}

}
