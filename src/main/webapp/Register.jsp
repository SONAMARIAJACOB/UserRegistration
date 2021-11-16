<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
 <div class="container">
<center><h2>Java Registration application using MVC and SQL </h2></center>
    <form name="form" action="RegisterServlet" method="post" >
        <table align="center">
        <tr>
				<td>User ID</td>
				<td><input type="number" name="userid" required/></td>
			</tr>
         <tr>
         <td>First Name</td>
         <td><input type="text" name="fname"  pattern="[A-Za-z\-]+"
            maxlength="20"
            required /></td>
         </tr>
         <tr>
         <td>Last Name</td>
         <td><input type="text" name="lname"  pattern="[A-Za-z\-]+"
            maxlength="20"
            required/></td>
         </tr>
         <tr>
         <td>Phone Number</td>
         <td><input type="text" name="phoneno" pattern="[6-9]{1}[0-9]{9}"
            title="Must be 10 digits numbers starting with 6 to 9"
            required /></td>
         </tr>
         <tr>
         <td>Email</td>
         <td><input type="email" name="email"
            pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-z]{2,}$"
            title="like:example@exam.com"
            required/></td>
         </tr>   
         <tr>
         <td>Password</td>
         <td><input type="password" name="password" 
            pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
            title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
            required/></td>
         </tr>
         <tr>
         <td>Confirm Password</td>
         <td><input type="password" name="conpassword" 
            pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
            title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
            required/></td>
         </tr>
         <tr>
         <td><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></td>
         </tr>
         <tr>
        
         <td><input type="submit" value="Register"></input></td><td><input
         type="reset" value="Reset"></input></td>
         </tr>
        </table>
        </div>
    </form>
    </div>
    <script text="text/javascript" src="passvalidate.js"></script>
</body>
</html>