<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Login</title>
</head>
<body>
<h1>Provide Login Details</h1>
<h4><span style="color:red">${errorMessage}</span></h4>
<form action="login.dos" method="post">
<pre>
UserName:<input type="text" name="username"/>
Password:<input type="password" name="password"/>
<input type="submit" value="Login"/>
<br>
<br>
<a href="product.jsp">ProductList</a>
</pre>
</form>

</body>
</html>