<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title>Patient details</title>
</head>

<h3>Patient details</h3>
<div class="container">
  <form action="save.do" method="post">
  <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" name="name" placeholder="Enter name">
    </div>
    <div class="form-group">
      <label for="age">Age:</label>
      <input type="text" class="form-control" name="age" placeholder="Enter page">
    </div>
    <div class="form-group">
      <label for="mobile">MobileNo:</label>
      <input type="text" class="form-control" name="mobile" placeholder="Enter mobile">
    </div>
    
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" placeholder="Enter email" name="email">
    </div>
    <div class="form-group">
      <label for="address">Address:</label>
      <input type="text" class="form-control" placeholder="Enter password" name="address">
    </div>
    <div class="form-group">
    <label>
      Result Yes:<input type="checkbox" value="yes" name="result">
             No:<input type="checkbox" value="no" name="result" > 
    </label>
    
    </div>
    
    <div class="form-group">
      <label for="state">Select state:</label>
      <select class="form-control" name="state">
        <option>Select</option>
        <c:forEach items="${states}" var="s">
        <option>${s}</option>
        </c:forEach>
      </select>
      </div>
      
    <button type="submit" class="btn btn-primary" name="submit">Submit</button>
  </form>
</div>

