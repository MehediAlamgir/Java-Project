package controller.registration;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class RegController extends HttpServlet
{
	
	private String html_code1;
	private String html_code2;
	private String html_code3;
	
	public void init() throws ServletException
	{
		
	}
	
	   public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException 
       {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();		

			try
			{
				String btn = request.getParameter("submit");
				
				if(btn==null )
				{
					
					RequestDispatcher rd1 = request.getRequestDispatcher("/r1");
					rd1.forward(request , response);
				}
		
				//Reg1 Servlet
				
				else if(btn.equals("Next1") )
				{
					String fn = request.getParameter("fn");
			
					String ln = request.getParameter("ln");
					String un = request.getParameter("un");						
					String gender = request.getParameter("gender");	
					
					if(fn.equals("") || ln.equals("")|| un.equals("") || gender.equals(""))
					{
						out.println("You have to Fill up all Field");
						RequestDispatcher rd1 = request.getRequestDispatcher("/r1");
						rd1.forward(request , response);
					}
					
					else
					{					
						HttpSession session = request.getSession();
					
						session.setAttribute("FirstName",fn);
						session.setAttribute("LastName",ln);
						session.setAttribute("UserName",un);
						session.setAttribute("Gender",gender);
						
						
						RequestDispatcher rd1 = request.getRequestDispatcher("/r2");
						rd1.forward(request , response);
					}
					
				}
				
				//Reg2 Servlet
				
				else if(btn.equals("Next2"))
				{
					
					String present_add = request.getParameter("present_add");
					String permanent_add = request.getParameter("permanent_add");
					String contact = request.getParameter("contact");	
					
					if(present_add.equals("") || permanent_add.equals("")|| contact.equals(""))
					{
						out.println("You have to Fill up all Field");
						RequestDispatcher rd1 = request.getRequestDispatcher("/r2");
						rd1.forward(request , response);
					}
				
					else
					{
						HttpSession session = request.getSession();
						
						session.setAttribute("Present_Address",present_add);
						session.setAttribute("Permanent_Address",permanent_add);
						session.setAttribute("Contact",contact);
						
						RequestDispatcher rd2 = request.getRequestDispatcher("/r3");
						rd2.forward(request , response);
					}
						
				}
				
				//Reg3 Servlet
				
				else if(btn.equals("Register") )
				{
					String qualification = request.getParameter("quali");
					String password = request.getParameter("pass");
					String con_password = request.getParameter("conpass");
					
					if(qualification.equals("") || password.equals("")|| con_password.equals("") )
					{
						out.println("You have to Fill up all Field");
						RequestDispatcher rd1 = request.getRequestDispatcher("/r3");
						rd1.forward(request , response);
					}
					
				/*	else if(password != con_password)
					{
						out.println("Password Doesn't Match");
						RequestDispatcher rd1 = request.getRequestDispatcher("/r3");
						rd1.forward(request , response);
					}
				*/	
					else
					{
				
						HttpSession session = request.getSession();

						session.setAttribute("quali",qualification);
						session.setAttribute("pass",password);
						session.setAttribute("con_pass",con_password);	
					
						response.sendRedirect("finalReg");
					}
				
				}
				
			}
			
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			finally
			{	
			
			}
			   
       }
	   
	   public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException 
	   {
			doGet(request,response);
	   }
}
