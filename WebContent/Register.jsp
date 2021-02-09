<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page errorPage="Error.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 <script type="text/javascript" src="validate-register.js"></script>
 
<title>Registration details</title>
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
		<form name="module" action="register.do" method="post" onsubmit="return validate()">
			<p class="text-danger text-center font-weight-bold">${save_err}</p>
			<p class="text-danger text-center font-weight-bold">${save}</p>
			
			<p class="text-danger text-center font-weight-bold">${success}</p>
				<p class="text-success text-right font-weight-bold">${name}</p>
			
			<div class="row">
				<div class="col-sm-3 mt-3">
					<label for="firstName">First name:</label>
				</div>
				<div class="col-sm-6">
					<input type="text" class="form-control mt-3"
						placeholder="Enter First Name" name="firstName">
						 <span id="err_fname" class="text-danger font-weight-bold"></span>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-3 mt-3">
					<label for="lastName">Last name:</label>
				</div>
				<div class="col-sm-6">
					<input type="text" class="form-control mt-3"
						placeholder="Enter Last Name" name="lastName">
						<span id="err_lname" class="text-danger"></span>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-3 mt-3">
					<label for="email">Email:</label>
				</div>
				<div class="col-sm-6">
					<input type="text" class="form-control mt-3"
						placeholder="Enter your email" name="email"> <span
						id="err_email" class="text-danger" text-weight="bold"></span>

				</div>
			</div>

			<div class="row">
				<div class="col-sm-3 mt-3">
					<label for="password">Password:</label>
				</div>
				<div class="col-sm-6">
					<input type="password" class="form-control mt-3"
						placeholder="Enter password" name="password"> <span
						id="err_password" class="text-danger" font-weight="bold"></span>

				</div>
			</div>

			<div class="row">
				<div class="col-sm-3 mt-3">
					<label for="confirmPassword">Confirm Password:</label>
				</div>
				<div class="col-sm-6">
					<input type="password" class="form-control mt-3"
						placeholder="Re-Enter the password" name="confirmPassword">
					<span id="err_match" class="text-danger" text-weight="bold"></span>
				</div>
			</div>
			<button type="submit" class="btn btn-success mt-3" name="register">Register</button>
			<button type="reset" class="btn btn-danger mt-3" name="cancel-register">Cancel</button>
		</form>
	</div>
	<nav
		class="navbar fixed-bottom navbar-dark bg-primary justify-content-center">
	<a class="navbar-brand" href="#"> &copy x-workz.in 2021</a> </nav>
</body>
</html>