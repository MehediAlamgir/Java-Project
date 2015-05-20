package controller.registration;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import model.*;

public class FinalRegistration extends HttpServlet
{
	private String firstName;
	private String lastName;
	private String userName;
	private String gender;
	private String presentAddress;
	private String permanentAddress;
	private String contact;
	private String qualification;
	private String password;
	private String conPassword;
	private String status;
	
	
	public void init() throws ServletException
	{
		
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();	
		
		try
		{
			HttpSession session = request.getSession();
			
			firstName = (String)session.getAttribute("FirstName");
			lastName = (String)session.getAttribute("LastName");
			userName = (String)session.getAttribute("UserName");
			gender = (String)session.getAttribute("Gender");
			presentAddress = (String)session.getAttribute("Present_Address");
			permanentAddress = (String)session.getAttribute("Permanent_Address");
			contact = (String)session.getAttribute("Contact");
			qualification = (String)session.getAttribute("quali");
			password = (String)session.getAttribute("pass");
			conPassword = (String)session.getAttribute("con_pass");
			status=(String)"0";
			
		/*	
			if(firstName.equals("") || lastName.equals("") || userName.equals("") || gender.equals("") || presentAddress.equals("") || permanentAddress.equals("") || contact.equals("") || qualification.equals("") || password.equals("") || conPassword.equals("") )
			{
				out.println("You Have to Fill up All Information");
			}
			
		*/	
	
			//	session.invalidate();
	
				boolean reg = DatabaseTable.signup(firstName,lastName,userName,gender,presentAddress,permanentAddress,contact,qualification,password,status);
				
				
				if(reg)
				{
					out.println("Registration Successfull.");
					//response.sendRedirect("finalReg");
					out.println("<h2> Click <a href='index'>here</a> here for SignIn </h2>");
					
				}
				
				else
				{
					out.println("Registration Failed. User Name Exists");
					out.println("<h2> Click <a href='index'>here</a> here for SignIn </h2>");
				}	
				
				out.close();
			
		
			
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
			
		finally
		{	
			
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request,response);
	}
}