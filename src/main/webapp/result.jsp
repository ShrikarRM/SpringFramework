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
<h1>Record added successfully</h1>
Name:${dto.name}
Age:${dto.age}
Email:${dto.email}
Mobile:${dto.mobile}
Address:${dto.address}
State:${dto.state}
Result:${dto.result}


</body>
</html>