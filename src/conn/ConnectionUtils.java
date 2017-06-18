package conn;

import java.sql.Connection;

public class ConnectionUtils {
	public static Connection getConnection () {
		try {
			return SQLServerConnection.getSQLServerConnection();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main (String[] args) {
		System.out.println(ConnectionUtils.getConnection());
	}
}
