<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Reset Password</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<div class="navbar-header">
    <span class="navbar-brand mb-0 h1">E-Commerce</span>
    
		</div>
		<ul class="nav justify-content-end">
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="Register.jsp">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="Login.jsp">Login</a></li>
		</ul>
	</div>
	</nav>
	<div class="container">
		<form>
			<div class="row">
				<div class="col-sm-3 mt-3">
					<label for="email">Email:</label>
				</div>
				<div class="col-sm-6">
					<input type="text" class="form-control mt-3" placeholder="Enter your email" name="email">
				</div>
			</div>
			<button type="submit" class="btn btn-primary mt-3" name="reset">Reset</button>

		</form>
	</div>
	<nav class="navbar fixed-bottom navbar-dark bg-primary justify-content-center">
	<a class="navbar-brand" href="#"> &copy x-workz.in 2021</a>
	 </nav>
</body>
</html>