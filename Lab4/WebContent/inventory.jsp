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

	<tag:Aheader />

	<main>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
	<table>
		<thead>
			<th>Item</th>
			<th>Description</th>
			<th>Price</th>
			<th>Edit</th>
			<th>Remove</th>
		</thead>
		<tbody>
			<c:forEach items="${inventory}" var="item">
				<tr>
					<td><p class="title">${item.getName()}</p></td>
					<td>${item.getDescription()}</td>
					<td>${item.getPrice()}</td>
					<td><a href="<c:url value='/foods/edit?id=${item.getId()}' />"
						class="button">Edit</a></td>
					<td><a
						href="<c:url value='/foods/delete?id=${item.getId()}' />"
						class="button">Delete</a></td>

					</li>
			</c:forEach>
		</tbody>
	</table>
	<a href="<c:url value='http://localhost:8080/Lab4/foods/create' />"
		class="button">Add new Food</a> </main>

	<footer> © 2017 Tom's #1 World Famous Chiliburgers Inc.,All Rights Reserved 
	</footer>
</body>
</html>