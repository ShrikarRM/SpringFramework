<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Login details</title>

</head>
<body>
<form name="home" action="welcome.do" method="post">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<div class="navbar-header">
    <span class="navbar-brand mb-0 h1">E-Commerce</span>
    
		</div>
		<ul class="nav justify-content-end">
		<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="welcome/${list.email}">Edit Profile</a></li>
	
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="Login.jsp">LogOut</a></li>
		</ul>
	</div>
	</nav>
	<div class="container">
			 <p class="text-danger text-center font-weight-bold">${nameupdate}</p>
	
	<h4>WelCome ${name},</h4>
	<P>You are on Home page now</P>
<!-- 	${list.firstName}
	<a href="">Edit</a>
 -->	</div>
	</form>
	<nav class="navbar fixed-bottom navbar-dark bg-primary justify-content-center">
	<a class="navbar-brand" href="#"> &copy x-workz.in 2021</a>
	</nav>
</body>
</html>