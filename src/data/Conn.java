package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	static String host = "localhost", Db = "cty", user = "root", pass = "";
	static int port = 3306;
	
	public static Connection getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connectionURL = "jdbc:mysql://" + host + ":" + port + "/" + Db;
			Connection conn = DriverManager.getConnection(connectionURL, user, pass);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
