package model;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;

public class Function
{
	 HttpServletRequest request;
	public static ArrayList <String> product = new ArrayList<String>();
	HttpSession session =  request.getSession();
	
	public static void addProduct(String cartName)
	{				
		if(cartName != null)
		{
			product.add(cartName);
		}
	} 
	
	public  void addToSession(ArrayList <String> p)
	{
		session.setAttribute("cart", p);
	}

}