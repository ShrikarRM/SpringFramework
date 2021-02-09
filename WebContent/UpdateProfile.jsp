<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>       
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Update details</title>
</head>
<body>
<form name="Update Profile" action="update.do" method="post">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<div class="navbar-header">
    <span class="navbar-brand mb-0 h1">E-Commerce</span>
    
		</div>
		<ul class="nav justify-content-end">
		<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="Home.jsp">Home</a></li>
	
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="Login.jsp">LogOut</a></li>
		</ul>
	</div>
	</nav>
		<div class="container">	
		 <p class="text-danger text-center font-weight-bold">${nameupdate}</p>
		
			<div class="row">
				<div class="col-sm-3 mt-3">
					<label for="firstName">First name:</label>
				</div>
				<div class="col-sm-6">
					<input type="text" class="form-control mt-3" name="firstName" value="${details.firstName}">													
<%--  					<c:forEach items="${list}" var="li">${li.firstName}</c:forEach>
 --%> 
					<span id="err_fname" class="text-danger font-weight-bold"></span>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-3 mt-3">
					<label for="lastName">Last name:</label>
				</div>
				<div class="col-sm-6">
					<input type="text" class="form-control mt-3" name="lastName" value="${details.lastName}">
					<span id="err_lname" class="text-danger font-weight-bold"></span>
				</div>
			</div>

			<div class="row">
				<!-- <div class="col-sm-3 mt-3">
					<label for="email">Email:</label>
				</div> -->
				<div class="col-sm-6">
					<input type="hidden" class="form-control mt-3" name="email" value="${details.email}">
					<span id="err_email" class="text-danger font-weight-bold"></span>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12 mt-3">
					<a href="Reset.jsp">Update Password</a>
					<button type="submit" class="btn btn-success" name="update">Update Details</button>					
				</div>
			</div>
		</div>
		</form>

	<nav class="navbar fixed-bottom navbar-dark bg-primary justify-content-center">
	<a class="navbar-brand" href="#"> &copy x-workz.in 2021</a>
	</nav>
</body>
</html>