<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="WEB-INF/Admin-Header.tld" prefix="tag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Food</title>
<link rel="stylesheet"type="text/css" href="<c:url value='/app.css'/>">
</head>
<body bgcolor="#E6E6FA">
	<tag:Aheader />

	<main>
	<h2>Edit Item</h2>


	<<form method="post">
	        Name:<br> <input type="text" name="name"
			value="${editorder.getName()}"><br>
                Order Status:<br>
                <select name="status">
                    <option value="IN_QUEUE">In Queue</option>
                    <option value="IN_PROGRESS">In Progress</option>
                    <option value="COMPLETED">Completed</option>
                </select>
                <input type="submit" value="Edit order">
            </form>

	</main>

	<footer> © 2017 Tom's #1 World Famous Chiliburgers Inc.,All
	Rights Reserved </footer>
</body>
</html>