<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>data</title>
</head>
<body>
<h3>${message}</h3>

<c:forEach items="${list}" var="pat">
<table border="2">
<tr>
<th>Patient name</th>
<td>${p.name}</td>
</tr>
<tr>
<th>Patient age</th>
<td>${p.age}</td>
</tr>
<tr>
<th>Patient mobile</th>
<td>${p.mobileNo}</td>
</tr>
<tr>
<th>Patient emailId</th>
<td>${p.emailId}</td>
</tr>
<tr>
<th>Patient Address</th>
<td>${p.address}</td>
</tr>
<tr>
<th>Patient State</th>
<td>${p.state}</td>
</tr>
<tr>
<th>Patient Result</th>
<td>${p.result}</td>
</tr>

</table>
</c:forEach>
</body>
</html>