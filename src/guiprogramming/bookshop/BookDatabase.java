package guiprogramming.bookshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookDatabase {
	
	private String jdbcURL= "jdbc:mysql://localhost:3306/dbbookshop?useSSL=false";
	private String jdbUserName="root";
	private String jdbcPassword="1234";
	private String jdbcDriver="com.mysql.jdbc.Driver";
	
	public BookDatabase() {
		
	}
	
	
	
	protected Connection getDatabseConnection() {
		
		Connection con = null;
		
		try {
			Class.forName(jdbcDriver);
			try {
				con = DriverManager.getConnection(jdbcURL,jdbUserName, jdbcPassword);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		}
		return con;
	}

}
