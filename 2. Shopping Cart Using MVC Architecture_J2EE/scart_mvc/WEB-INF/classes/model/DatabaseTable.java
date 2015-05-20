package model;

import java.sql.*;

public class DatabaseTable
{
	private static Connection conn = null;
	private static Statement stmt = null;
	private static String query = "";
	
	public static boolean signup(String fn,String ln,String un,String gender,String present_add,String permanent_add,String contact,String qualification,String pass,String status)
	{
		query="INSERT INTO login(firstname,lastname,username,gender,present_address,permanent_address,contact,qualification,password,status) VALUES ('"+fn+"','"+ln+"','"+un+"','"+gender+"','"+present_add+"','"+permanent_add+"','"+contact+"','"+qualification+"','"+pass+"','"+status+"')";
	
		if(check(un) == false)
		{
		
			try
			{
				
				conn = Database.getDatabaseConnection();
				stmt = conn.createStatement();
				stmt.execute(query);
			
				stmt.close();
				conn.close();
				return true;
			}
			
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		return false;
		
	}
	
	private static  boolean check(String un)
	{
		boolean flag = false;
		String userCheck = "Select username from login";
	
		try
		{			
			conn = Database.getDatabaseConnection();
			stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(userCheck);
				
			while (rs.next())
			{
				String uname = rs.getString("username");
		
				if (uname.equals(un))
				{
					flag = true;
					rs.close();
					stmt.close();
					conn.close();
					break;
					
				}
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			return flag;
		}
	}
	
	public static  boolean check(String un,String pass)
	{
		boolean flag = false;
		String userCheck = "Select username,password from login";
	
		try
		{			
			conn = Database.getDatabaseConnection();
			stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(userCheck);
			
		//	System.out.println("after try block__function check()");
			
			while (rs.next())			
			{
				String uname = rs.getString("username");
				String passWord = rs.getString("password");
				
				//	System.out.println("after while block__function check()__ userName: "+uname+"password: "+passWord);
		
				if (uname.equals(un) && passWord.equals(pass))
				{
				//	System.out.println("after if block__function check()");
					flag = true;
					rs.close();
					stmt.close();
					conn.close();
					break;
					
				}
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			return flag;
		}
	}
	
	public static  boolean insert(String ProductName,int  Price)
	{
		boolean flag = false;
		query="INSERT INTO cartlist(ProductName,Price) VALUES ('"+ProductName+"','"+Price+"')";
		
			try
			{				
				conn = Database.getDatabaseConnection();
				stmt = conn.createStatement();
				stmt.execute(query);
			
				stmt.close();
				conn.close();
				return true;
			}
			
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		return flag;
	}
	
	
	public static  ResultSet query(String query) throws Exception
	{
		String sql = query;
		ResultSet rs=null;
		try
		{				
			conn = Database.getDatabaseConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
		//	stmt.close();
		//	conn.close();
		}	

		catch(Exception ex)
		{
			ex.printStackTrace();
		}		
		
		return rs;
	} 
}

