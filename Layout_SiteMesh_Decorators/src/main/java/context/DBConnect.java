package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private final String serverName = "localhost";
	private final String dbName = "ShopOnline";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "NewSA";
	private final String password = "123456";

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ":" + 
				portNumber + "\\" + instance + ";databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber
			+ ";databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true";
		// Windows Authentication
			//url = "jdbc:sqlserver://" + serverName + ":" + portNumber + 
				//";integratedSecurity=true;databaseName=" + dbName;

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
		//return DriverManager.getConnection(url);
	}
	// Chua chay duoc
	public Connection getConnectionW() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ":" + 
				portNumber + "\\" + instance + ";databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			//url = "jdbc:sqlserver://" + serverName + ":" + portNumber
			//+ ";databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true";
		// Windows Authentication
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + 
				";integratedSecurity=true;databaseName=" + dbName+ ";encrypt=true;trustServerCertificate=true";

		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//return DriverManager.getConnection(url, userID, password);
		return DriverManager.getConnection(url);
	}
}
