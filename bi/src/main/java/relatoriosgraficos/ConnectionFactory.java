package relatoriosgraficos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String connectionStr = "jdbc:sqlserver://DIEGO-PC:1433;databaseName=BDTESTE";
	private String usuario = "sa";
	private String senha = "123";

	public ConnectionFactory() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(connectionStr, usuario, senha);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
