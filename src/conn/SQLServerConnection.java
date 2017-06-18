package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection { //config sqlServer
	public static Connection getSQLServerConnection () throws SQLException, ClassNotFoundException{
		String hostname = "localhost";
		String sqlInstanceName = "..\\SQLEXPRESS";
		String database = "DATN";
		String username = "sa";
		String password = "123456";
		
		return getSQLServerConnection(hostname, sqlInstanceName, database, username, password); 
	}
	
	public static Connection getSQLServerConnection (String hostname, String sqlInstanceName, String database,
			String username, String password) throws ClassNotFoundException, SQLException {
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 
		 String connectionURL = "jdbc:sqlserver://" + hostname + ":1433"
	             + ";instance=" + sqlInstanceName + ";databaseName=" + database;
		 
		 Connection conn = DriverManager.getConnection(connectionURL, username, password);
		 
		 return conn;
	}
}
