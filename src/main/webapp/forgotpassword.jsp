<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ForgotPassword</title>
<style>
form {
    border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: blue;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
}
</style>
</head>
<body>
	<h1>ForgotPassword</h1>	
	<form action="GetPassword" method="post">
	  <div class="container">
	    <label><b>Email</b></label>
	    <input type="text" placeholder="Enter Email" name="email" required>
	
	    <label><b>New Password</b></label>
	    <input type="password" placeholder="Enter Password" name="newpassword" required>
	    
	    <label><b>Confirm Password</b></label>
	    <input type="password" placeholder="Enter ConfirmPassword" name="confirmpassword" required>
	    
	        
	    <button type="submit">Submit</button>
	  </div>
</form>
</body>
</html>