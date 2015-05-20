package controller.login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import model.*;

public class LoginController extends HttpServlet
{
		
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		try
		{	
		
			String btn_login = request.getParameter("submit_login");
			String code = request.getParameter("code");
			String cap = (String) session.getAttribute("captcha");
			String login_un = request.getParameter("un");
			String login_pass = request.getParameter("pass");
			
		//	System.out.println("Login Button: "+btn_login);
		//	System.out.println("User Name: "+login_un);
		//	System.out.println("Password: "+login_pass);
		//	System.out.println("Captcha: "+code);
			
			
			if(login_un.equals("") || login_pass.equals("") || code.equals(""))
			{
				//System.out.println("In Null Block");
				out.println("Empty User Name or Password !! ");
				//RequestDispatcher rd = request.getRequestDispatcher("/index");
				//rd.forward(request, response);
				response.sendRedirect("/index");
			}
			
			else
			{
				//out.println("In else Block");
				if (cap.equals(code))
				{
					if(btn_login.equals("LOGIN"))
					{
					
							session.setAttribute("Login_userName",login_un);
							session.setAttribute("Login_password",login_pass);
						
							
							boolean chk = DatabaseTable.check(login_un,login_pass);
							
							if(chk)
							{
								//out.println("Check OK");
								response.sendRedirect("lastAccessTime");
							}
							else
							{
								
								out.println("User Name or Password Doesn't Exists");
								response.sendRedirect("index"); 
							}				
						
					}
				}
				
				else
				{
					out.println("Invalid Captcha ,,, try  again");
					response.sendRedirect("/index");
				}
			}	

		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		doGet(request,response);
	}
}