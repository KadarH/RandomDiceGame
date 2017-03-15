package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	
	
	
	
		public DbConnect() {
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				
			}catch (ClassNotFoundException e) {
				
			e.printStackTrace();
			}
		
		
		}
		
		public Connection getConnection(){
			Connection conex = null;
			
			try {
				conex = DriverManager.getConnection("jdbc:mysql://localhost/RandomGame", "root", "123");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return conex;
			
		}
		
		
		
		
}
