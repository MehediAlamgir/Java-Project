package helper;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
   
public class Logout extends HttpServlet 
{       
		
		public void init() throws ServletException
		{
		  // Do required initialization
		 
		}
       
       public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException 
       {	
			
           response.setContentType("text/html");
           
           HttpSession session = request.getSession();
           String last_page = (String) session.getAttribute("last_page");
           //session.removeAttribute("last_page");
           session.setAttribute("last_page",last_page);
           session.invalidate();
           response.sendRedirect("index");
	   }
	   
	    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException 
	   {
			doGet(request,response);
	   }
	  
}




   
