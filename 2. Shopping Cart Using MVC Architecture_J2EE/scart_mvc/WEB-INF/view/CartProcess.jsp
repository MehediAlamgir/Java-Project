<%@ page import="model.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>

<% 
	  Connection conn = null;
	  Statement stmt = null;
	
		ResultSet rs = null;
	
		String s="";
	
	try
	{
		String sql = "SELECT * from cartlist";
		rs = DatabaseTable.query(sql);
	}
	
	catch(Exception e)
	{
		out.println(e.getMessage() );
	}
	
	ArrayList list = (ArrayList)session.getAttribute("cart");
			
	int count = 0;
	if(list != null)
	{
		count = list.size();
	}
	
%>

<html>

	<head>
		<title>Cart Process</title>
	</head>
	
	<body>
	
		<% out.println("["); %>
		<a href='logout' align='left'>logout</a>
		<% out.println("]"); %>
		<center><b> Total Item In Cart: <% out.println(count); %>
		
		<table border="0"  align="center">
		<tr>
			<td>
				<fieldset>
					<legend align ="center" >Select Item</legend>
					<form method="POST" action="">
						<table border="0" width="500">
							<tr><td><b><u>Id</u><b></td><td><b><u>Product Name</u><b></td><td><b><u>Price</u><b></td></tr>
							
							<%
								
								try
								{
									while(rs.next() )
									{
							%>
									<tr><td><% out.println(rs.getInt("id")); %>
									</td><td><% out.println(rs.getString("ProductName")); %>
									</td><td><% out.println(rs.getInt("Price")); %>
									
									<a href='check?pname=<% out.println(rs.getString("ProductName")); %> '> <input type= 'button' value='Add To Cart'></a>
									
									</td></tr>
									
								<%
									}							
								
								}
								
								catch(Exception e)
								{
				
								}
								
								%>
								
								</table></br></br></br></br></br>
								Done ? <b><a href='cartList'>Click Here to Finish </a><b>
								<% count=0; %> 
							
							
	</body>
</html>