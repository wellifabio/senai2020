package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	private static String dns = "jdbc:mysql://localhost:3306/meuserver?useTimezone=true&serverTimezone=UTC";
	private static String usuario = "root";
	private static String senha = "";

	private static Connection con;

	public static Connection getConnection() {		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(dns, usuario, senha);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
