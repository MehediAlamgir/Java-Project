<html>
	<head>
		<title>Shopping Cart</title>
			<script type="text/javascript" src="/WEB-INF/view/js/validation.js"></script>
	</head>
	
	<body>
	
		<center>
			<h1>Login Panel</h1>
		</center>
		
		<form action="loginController" method="post" align="center" onsubmit="return loginCheck();">
		

			<table border="15"  align ="center" cellspacing="10" cellpadding="10">
				<tr>
					<td><label>USER NAME </label></td>
					<td><input type="text" name="un" id=un></td>
				</tr>
				<tr>
					<td><label>PASSWORD </label></td>
					<td><input type="password" name="pass" id=pass></td>
				</tr>
				
				 <tr>
                        <td>Captcha </td>
                        <td><input type="text" name="code"></td>
                 </tr>
				
				  <br>
                        <center><img src="http://localhost:8081/scart_mvc/helper/captcha"> </center>
                        <br><br>
                            
				<tr>
					<td colspan="2"><center><input type="submit" name ="submit_login" id = " submit_login"  value="LOGIN"></center></td>
				</tr>
				
			</table>
			<br/><br/>
			<label>
			<center>	New at this site ? Click <a href="con">here</a> for Registartion  </center>
			</label>
		
		</form>
	</body>
</html>