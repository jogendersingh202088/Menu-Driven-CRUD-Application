package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	
	// create a static connection method
	
	public static Connection getConnection () throws ClassNotFoundException, SQLException {
		
		Connection con = null;
		
		// load driver
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// make connection 
		
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","9876@zyxA");
		
		
		return con ;
		
	
	}
	
	// method to close connection 
	
	public static void CloseConnection(Connection conn ) throws SQLException {
		
		conn.close();
		
		
	}
	
	
}
