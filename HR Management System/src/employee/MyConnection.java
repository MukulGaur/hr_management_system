package employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnection {
	
	static Connection con;
	
	public static Connection getMyConnection() throws IOException, SQLException {
		
		if(con == null) {
			
			Properties property = new Properties();
			
			FileInputStream fin = new FileInputStream("F:\\java\\Java\\HR Management System\\src\\employee\\db.properties");
			
			property.load(fin);
			
			String driver = property.getProperty("driver");
			String url = property.getProperty("url");
			String username = property.getProperty("username");
			String password = property.getProperty("password");
			
			con = DriverManager.getConnection(url, username, password);
			return con;
			
		}
		
		else 
			return con;
		
	}

}
