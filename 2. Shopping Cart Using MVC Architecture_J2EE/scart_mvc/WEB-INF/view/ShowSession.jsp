<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>

<html>

	<head>
		<title>Show Session</title>
	</head>
	
	<body bgcolor="#FDF5E6">
	<br>
	<a href="logout">Logout!</a>
	
		<%
			String userName = (String) session.getAttribute("Login_userName");
						
			String heading;
			Integer accessCount =(Integer)session.getAttribute("accessCount");
			if (accessCount == null) 
			{
				accessCount = new Integer(0);
				heading = "Welcome, Newcomer";
			}
			else 
			{
				heading = "Welcome Back";
				accessCount = new Integer(accessCount.intValue() + 1);
			}
			
			session.setAttribute("accessCount", accessCount);
			
			String title = "Access Information ";		
			
		%>
		
		<center>
			<H1>
				<% out.println(heading);%>
			</H1>
			<H2>Your Access Information:</H2>
			<TABLE border=1>
				<TR bgcolor="#FFAD00">
					<TH>Info Type</TH>
					<th>Value</th>
					<TR>
						<TD>ID
						<TD><% out.println(userName); %>
					<TR>
					

				<td>Number of Previous Accesses<td>
				<% out.println(accessCount); %>
			</table>
			
			<label>
				<center>
					<h1>To See Product List Click <a href='cart'>here</a> </h1>
				</center>
			</label>
			
		</center>		
	
	
	</body>
	
</html>