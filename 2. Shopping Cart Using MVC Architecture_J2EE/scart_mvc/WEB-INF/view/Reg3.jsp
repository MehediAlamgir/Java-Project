<html>
	<head>
		<title>Reg Page 3</title>		
	</head>
	
	<body>
		<center><h2>Registration</h2></center>
		<form action='con' method='post'>
			<table border='0' align='center' cellspacing='5' cellpadding='5'>
				<tr>
					<td>Qualification</td>
					<td>
						<select name='quali' id='quali'>
							<option>Select Qualification</option>
							<option>SSC</option>
							<option>HSC</option>
							<option>UnderGraduate</option>
							<option>Graduate</option>
						</select>
					</td>					
				</tr>
				<tr>
					<td>Password</td>
					<td><input type='password' name='pass'  id='pass' /><td>					
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><input type='password' name='conpass'  id='conpass'  /></td>
				</tr>
				<tr>
					<td><input type='submit' name='submit' id='submit' value='Register' /></td>
				</tr>
			</table>
		</form>
	</body>
</html>