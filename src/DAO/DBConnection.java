package DAO;

import java.sql.*;

public class DBConnection {
	
	// Parametres de la connexion a la base de données medoc
		private static String url = "jdbc:mysql://localhost:3306/medoc";
		private static String user = "root";
		private static String password = "";
		
		
		// Creation de la connexion
		public static Connection getConnection()
		{
			Connection connection = null;
			
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url,user, password);
				
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
			return connection;
		}
}
