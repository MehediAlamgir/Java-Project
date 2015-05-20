    <%@ page import="model.*" %>
    <%@ page import="java.sql.*" %>
    <%@ page import="java.io.*" %>
    <%@ page import="java.util.*" %>
     
    <%
     
    Connection conn = null;
    Statement stmt = null;	
    ResultSet rs = null;
    String s;
    int pid;
     
     
    String s1 = request.getParameter("pname");
    ArrayList<String> pro ;
    if (session.getAttribute("cart") == null)
    {
		pro = new ArrayList<String>();
		session.setAttribute("cart" , pro);
    }
     
    if (s1 != null)
	 {
	  pro=(ArrayList)session.getAttribute("cart");
	  pro.add(s1);
	  session.setAttribute("cart" , pro);
	}
    
     
    %>
     
    <html>
     
    <head>
    <title>Selected Product</title>
    </head>
     
    <body>
     
    <table border="0" align="center">
    <tr>
    <td>
    <fieldset>
    <legend align="center">Select Items</legend>
    <form method="POST" action="">
    <table border="0" width="500">
     
     
     
    <%
    try
    {
    while(rs.next())
    {
    %>	
    <tr><td><% out.println(rs.getInt("id")); %>
    <td><td><% out.println(rs.getString("ProductName") ); %>
    <td><td><% out.println(rs.getInt("Price") ); %>
    <font color='green'><b>Added To Your Cart</b></font>
    <%	
    }
     
    }
     
    catch(Exception e)
    {
     
    }
     
     
    %>
     
    <a href='cart'>Click Here to Continue Shopping</a>
    <br><br><font color='green'><b><u>Your Cart List</u></b></font>
     
    <%
     
     
    ArrayList list = (ArrayList)session.getAttribute("cart");
     
    // out.println("Product Quantity: "+product.size());
    // out.println("list Quantity: "+list.size());
     
	 
    for(int i=0; i<list.size(); i++)
    {

    %>
    <br>
    <%
    out.println(list.get(i));
    }
     
    %>
     
    </body>
     
     
    </html>
