package CONTACTBOOK;

import java.sql.*;

import javax.swing.JOptionPane;

public class DatabaseConnection {
	
	private final static String URL = "com.mysql.jdbc.Driver";
	private final static String DB_URL = "jdbc:mysql://localhost:3306/contactbook";
	private final static String USER = "root";
	private final static String PASS  ="";
	private static Connection conn = null;
	
	public static Connection getDatabaseConnection()
	{
		try
		{
			Class.forName(URL);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			//JOptionPane.showMessageDialog(null, "Sucessfully Connected to Database!");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally 
		{
			return conn;
		}
	}
	
	public static void main(String[] args) {
		DatabaseConnection.getDatabaseConnection();
	
	}
}
