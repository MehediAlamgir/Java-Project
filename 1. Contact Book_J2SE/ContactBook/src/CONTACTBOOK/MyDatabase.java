package CONTACTBOOK;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class MyDatabase extends JFrame {
	
	private JLabel firstName , fname;
	private JLabel lastName , lname;
	private JLabel nickName , nname;
	private JLabel contact , cont;
	private JLabel email , mail;
	private JLabel dob , db;
	private JLabel gender , sex;
	private JLabel blood , bl;
	private Container con;
	private JFrame frame;
	private  static Connection conn = null;
	private  static Statement stmt = null;
	private  static String query = "";
	public static void signupInfo(String firstName , String lastName , String userName , String pass , String userContact , String userEmail , String bloodGroup ,String userGender , String dateOfBirth)
	{
		
		query = "INSERT INTO signupinfo (username , firstname , lastname , password , contact , email , blood , gender , dob) VALUES ('"+userName+"' ,'"+firstName+"' ,'"+lastName+"' , '"+pass+"' , '"+userContact+"' ,'"+userEmail+"' ,'"+ bloodGroup+"' , '" +userGender+"' , '"+dateOfBirth+"') " ;
		
		
		if (check(userName , userEmail ,userContact) == false)
		{
			try
			{
				conn = DatabaseConnection.getDatabaseConnection();
				stmt = conn.createStatement();
				stmt.execute(query);
				JOptionPane.showMessageDialog(null, "Congratulations! , Your account is created.");
				stmt.close();
				conn.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}

		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid  (username or email or contact No.), Choose Another One");
		}
	
	}
	
	
	private static  boolean check(String userName , String email , String contact)
	{
		boolean tof = false;
		String userCheck = "Select username , email , contact from signupinfo";
		try
		{
			
			conn = DatabaseConnection.getDatabaseConnection();
			stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(userCheck);
			while (rs.next())
			{
				String name = rs.getString("username");
				String eml = rs.getString("email");
				String con = rs.getString("contact");
				if (name.equals(userName) || eml.equals(email) || con.equals(contact))
				{
					tof = true;
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
			return tof;
		}
	}
	
	public static boolean serachUser(String userName , String password)
	{
		boolean tof = false;
		query = "Select username , password from signupinfo Where username ='"+userName+"' and password='"+password+"' " ;
		
		try
		{
			conn = DatabaseConnection.getDatabaseConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				tof = true;
				break;
			}
			rs.close();
			stmt.close();
			conn.close();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			return tof;
		}
	}


	public static void userInfo(String mee, String firstName, String lastName,String nickName ,String img, String userContact, String userEmail, String userBlood , String userGender,String userDob) 
	{

		query = "INSERT INTO userinfo (me , nickname , firstname , lastname , image , contact , email , blood , gender , dob) VALUES ('"+mee+"' , '"+nickName+"' ,'"+firstName+"' ,'"+lastName+"' , '"+img+"' , '"+userContact+"' ,'"+userEmail+"' ,'"+ userBlood+"' , '" +userGender+"' , '"+userDob+"') " ;
		
		
		if (checkUser(nickName, userEmail ,userContact) == false)
		{
			try
			{
				conn = DatabaseConnection.getDatabaseConnection();
				stmt = conn.createStatement();
				stmt.execute(query);
				JOptionPane.showMessageDialog(null, "Sucessfully Added in Your Friend list");
				stmt.close();
				conn.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}

		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid  (username or email or contact No.), Choose Another One");
		}
	}

	private static boolean checkUser(String nickName, String userEmail,String userContact) {
		boolean tof = false;
		String userCheck = "Select nickname , email , contact from userinfo";
		try
		{
			
			conn = DatabaseConnection.getDatabaseConnection();
			stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(userCheck);
			while (rs.next())
			{
				String name = rs.getString("nickname");
				String eml = rs.getString("email");
				String con = rs.getString("contact");
				if (name.equals(nickName) || eml.equals(userEmail) || con.equals(userContact))
				{
					tof = true;
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
			return tof;
		}
	}


	public static void deleteUser(String name) 
	{
		
		if (nickNameCheck(name) == true)
		{
			query = "DELETE  FROM userinfo WHERE nickname='"+name+"' AND me='"+LoginPage.USER_NAME+"'  ";
			try
			{
				conn = DatabaseConnection.getDatabaseConnection();
				stmt = conn.createStatement();
				stmt.execute(query);
				JOptionPane.showMessageDialog(null, "Successfully deleted all the imformation of " + name );
				stmt.close();
				conn.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid NickName!");
		}
	}
	
	public static boolean nickNameCheck(String name)
	{
		boolean tof = false;
		query = "Select nickname from userinfo Where nickname ='"+name+"' and me='"+LoginPage.USER_NAME+"'  ";
		
		try
		{
			conn = DatabaseConnection.getDatabaseConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				tof = true;
				rs.close();
				stmt.close();
				conn.close();
				break;
			}
		}
		catch(Exception  ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			return tof;
		}
	}


	public static void updateFirstName(String name , String fname) 
	{
		query = "UPDATE userinfo SET firstname='"+fname+"' WHERE nickname='"+name+"' AND me='"+LoginPage.USER_NAME+"'  ";
		try
		{
			conn = DatabaseConnection.getDatabaseConnection();
			stmt = conn.createStatement();
			stmt.execute(query);
			JOptionPane.showMessageDialog(null, "Successfully Updated FirstName");
			stmt.close();
			conn.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}


	public static void updateLastName(String name, String lname) 
	{
		query = "UPDATE userinfo SET lastname='"+lname+"' WHERE nickname='"+name+"' AND me='"+LoginPage.USER_NAME+"'  ";
		try
		{
			conn = DatabaseConnection.getDatabaseConnection();
			stmt = conn.createStatement();
			stmt.execute(query);
			JOptionPane.showMessageDialog(null, "Successfully Updated LastName");
			stmt.close();
			conn.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}


	public static void updateContact(String name, String con) 
	{
		query = "UPDATE userinfo SET contact='"+con+"' WHERE nickname='"+name+"' AND me='"+LoginPage.USER_NAME+"'  ";
		try
		{
			conn = DatabaseConnection.getDatabaseConnection();
			stmt = conn.createStatement();
			stmt.execute(query);
			JOptionPane.showMessageDialog(null, "Successfully Updated Contact No.");
			stmt.close();
			conn.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}


	public static void updateEmail(String name, String eml) 
	{
		query = "UPDATE userinfo SET email='"+eml+"' WHERE nickname='"+name+"' AND me='"+LoginPage.USER_NAME+"'  ";
		try
		{
			conn = DatabaseConnection.getDatabaseConnection();
			stmt = conn.createStatement();
			stmt.execute(query);
			JOptionPane.showMessageDialog(null, "Successfully Updated E-mail Adsress");
			stmt.close();
			conn.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}


	public static void updateBlood(String name, String bg) 
	{
		query = "UPDATE userinfo SET blood='"+bg+"' WHERE nickname='"+name+"' AND me='"+LoginPage.USER_NAME+"'  ";
		try
		{
			conn = DatabaseConnection.getDatabaseConnection();
			stmt = conn.createStatement();
			stmt.execute(query);
			JOptionPane.showMessageDialog(null, "Successfully Updated Blood Group");
			stmt.close();
			conn.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}


	public static void updateGender(String name, String sex) 
	{
		query = "UPDATE userinfo SET gender='"+sex+"' WHERE nickname='"+name+"' AND me='"+LoginPage.USER_NAME+"'  ";
		try
		{
			conn = DatabaseConnection.getDatabaseConnection();
			stmt = conn.createStatement();
			stmt.execute(query);
			JOptionPane.showMessageDialog(null, "Successfully Updated Gender");
			stmt.close();
			conn.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}


	public static void updateDateOfBirth(String name, String dob) 
	{
		query = "UPDATE userinfo SET dob='"+dob+"' WHERE nickname='"+name+"' AND me='"+LoginPage.USER_NAME+"'  ";
		try
		{
			conn = DatabaseConnection.getDatabaseConnection();
			stmt = conn.createStatement();
			stmt.execute(query);
			JOptionPane.showMessageDialog(null, "Successfully Updated Date Of Birth");
			stmt.close();
			conn.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}


	public static void updateImage(String name, String filename) 
	{
		query = "UPDATE userinfo SET image='"+filename+"' WHERE nickname='"+name+"' AND me='"+LoginPage.USER_NAME+"'  ";
		try
		{
			conn = DatabaseConnection.getDatabaseConnection();
			stmt = conn.createStatement();
			stmt.execute(query);
			JOptionPane.showMessageDialog(null, "Successfully Updated Image");
			stmt.close();
			conn.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	

	public void showInfo(String name)
	{
		String fn  = null;
		String ln = null;
		String phn = null;
		String bg = null;
		String bd = null;
		String eml = null;
		String sx = null;
		String img = null;
		con = this.getContentPane();
		con.setBackground(Color.WHITE);
	
		try
		{
			query = "SELECT * FROM userinfo WHERE nickname ='"+name+"' AND me='"+LoginPage.USER_NAME+"' ";
			conn = DatabaseConnection.getDatabaseConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				fn = rs.getString("firstname");
				ln = rs.getString("lastname");
				phn = rs.getString("contact");
				eml = rs.getString("email");
				bg = rs.getString("blood");
				bd = rs.getString("dob");
				sx = rs.getString("gender");
				img = rs.getString("image");
				
				
				
				firstName = new JLabel("FirstName: ");
				firstName.setBounds(15, 30, 100, 30);
				
				fname = new JLabel(fn);
				fname.setBounds(130, 30, 300, 30);
				
				lastName = new JLabel("LastName: ");
				lastName.setBounds(15, 70, 200, 30);
				
				lname = new JLabel(ln);
				lname.setBounds(130 , 70 , 300 , 30);
				
				nickName =  new JLabel("NickName: ");
				nickName.setBounds(15,110, 100, 30);
				
				nname = new JLabel(name);
				nname.setBounds(130 , 110 , 300 , 30);
				
				gender = new JLabel("Gender: ");
				gender.setBounds(15, 150, 100, 30);
				
				sex = new JLabel(sx);
				sex.setBounds(130, 150, 300, 30);
				
				dob = new JLabel("Date Of Birth: ");
				dob.setBounds(15, 190, 130, 30);
				
				db = new JLabel(bd);
				db.setBounds(130, 190, 300, 30);
				
				blood = new JLabel("Blood Group: ");
				blood.setBounds(15, 230, 120, 30);
				
				bl = new JLabel(bg);
				bl.setBounds(130, 230, 100, 30);
				
				contact = new JLabel("Contact No: ");
				contact.setBounds(15, 270, 100, 30);
				
				cont = new JLabel(phn);
				cont.setBounds(130, 270, 100, 30);
				
				email = new JLabel("E-mail: ");
				email.setBounds(15, 310, 100, 30);
				
				mail = new JLabel(eml);
				mail.setBounds(130, 310, 350, 30);
				

				con.add(firstName);
				con.add(fname);
				con.add(lastName);
				con.add(lname);
				con.add(nickName);
				con.add(nname);
				con.add(gender);
				con.add(sex);
				con.add(blood);
				con.add(bl);
				con.add(email);
				con.add(mail);
				con.add(contact);
				con.add(cont);
				con.add(dob);
				con.add(db);
				con.setLayout(null);
				
				frame = new JFrame();
				frame.add(con);
				frame.setSize(400, 400);
				//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				frame.setVisible(true);
				
				
				
			}
			rs.close();
			stmt.close();
			conn.close();			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}

