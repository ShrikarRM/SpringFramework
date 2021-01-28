<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script type="text/javascript" src="validate-login.js">
	
</script>
	
<title>Forget password details</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<div class="navbar-header">
    <span class="navbar-brand mb-0 h1">E-Commerce</span>
    
		</div>
		<ul class="nav justify-content-end">
			<li class="nav-item"><a class="navbar-brand mb-0 h1"
				 href="Login.jsp">Login</a></li>
		</ul>
	</div>
	</nav>
	<div class="container">
		<form name="ForgotPassword" action="updatePassword.do" method="post"
			onsubmit="return validateForgotPassword()">
			 	<p class="text-danger text-center font-weight-bold">${OTP}</p>

			<div class="row">
				<div class="col-sm-3 mt-3">
					<label for="email">Temporary Password:</label>
				</div>
				<div class="col-sm-6">
					<input type="password" class="form-control mt-3"
						placeholder="Enter Temporary Password" name="tempPassword">
						 <span id="err_tempPassword" class="text-danger"></span>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-3 mt-3">
					<label for="email">New Password:</label>
				</div>
				<div class="col-sm-6">
					<input type="password" class="form-control mt-3"
						placeholder="Enter new Password" name="newPassword">
						 <span id="err_newPassword" class="text-danger"></span>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-3 mt-3">
					<label for="email">Confirm new Password:</label>
				</div>
				<div class="col-sm-6">
					<input type="password" class="form-control mt-3"
						placeholder="Re-Enter your new Password" name="confirmPassword">
						 <span id="err_confirmPassword" class="text-danger"></span>
				</div>
			</div>
				<button type="submit" class="btn btn-primary mt-3" name="reset">Reset</button>
				<button type="reset" class="btn btn-primary mt-3" name="cancel-resetting">ClearAll</button>

		</form>
	</div>
	<nav class="navbar fixed-bottom navbar-dark bg-primary justify-content-center">
	<a class="navbar-brand" href="#"> &copy x-workz.in 2021</a>
	</nav>
</body>
</html>