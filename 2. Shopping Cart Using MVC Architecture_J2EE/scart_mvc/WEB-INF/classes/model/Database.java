package model;

import java.sql.*;
import javax.swing.JOptionPane;


public class Database
{
	private final static String url = "com.mysql.jdbc.Driver";
	private final static String db_url = "jdbc:mysql://localhost/reg";
	private final static String user = "root";
	private final static String pass = "";
	private  static Connection conn = null;
	
	
	public static Connection getDatabaseConnection()
	{
		try
		{
			Class.forName(url);
			conn = DriverManager.getConnection(db_url, user, pass);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			//System.err.println("Exception__: "+ex.getMessage());
		}
		finally 
		{
			return conn;
		}
	}
	
	public static void main(String[] args) 	{
		
		Database.getDatabaseConnection();
	
	}
}