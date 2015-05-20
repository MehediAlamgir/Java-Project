<%@ page import="java.util.*" %>

<html>

	<head>
		<title>Finish</title>
	</head>
	
	<body>
	
		[<a href='logout' align="right">logout</a>]
		<table border="0"   align="center">
			<tr>
				<td>
					<fieldset>
						<legend align="center">Thank you!</legend>
						<form method="POST" action="">
							<table border="0" width="500">
							
		<% 
			ArrayList list = (ArrayList)session.getAttribute("cart");
			int count = list.size();
			
			if (count==0)
				count=0;
			
		%>
		
		<center><b>Thank You. You have buy total: <% out.println(count); %>  Items
	
	</body>

</html>