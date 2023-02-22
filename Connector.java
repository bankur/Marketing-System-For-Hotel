package ConLib;

import java.sql.Connection;
import java.sql.DriverManager;



public class Connector {
	final String DRIVER = "com.mysql.cj.jdbc.Driver";
	final String HOST = "localhost";
	final int PORT = 3306;
	final String DATABASE = "hoteldb";
	final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
	final String USER = "root";
	final String PASS = "PFH#23kgrw9";

	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASS);

		} catch (Exception ex) {
			System.out.println("Error :" + ex.getMessage());
		}
		return conn;
	}
	
	

}
