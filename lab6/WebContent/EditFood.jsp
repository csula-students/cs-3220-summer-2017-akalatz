<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="WEB-INF/Admin-Header.tld" prefix="tag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tom's #1 World Famous Chiliburgers</title>
<link rel="stylesheet"type="text/css" href="<c:url value='/app.css'/>">

</head>
<body bgcolor="#E6E6FA">

	<tag:Admin-Header />

	<main>
	<h2>Edit Item</h2>


	<form method="post">
		Food Name:<br> <input type="text" name="name"
		value="${edititem.getName()}"><br> Food Description:<br>
		<input type="text" name="description"
		value="${edititem.getDescription()}"><br> Food Price:<br>
		<input type="number" name="price" value="${edititem.getPrice()}"><br>
		<br> <input type="submit" value="Edit food">
	</form>
	</main>
	<footer> © 2017 Tom's #1 World Famous Chiliburgers Inc.,All
	Rights Reserved </footer>
</body>
</html>