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
	<h2>Inventory</h2>
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
			<c:forEach items="${list}" var="item">
				<tr>
					<td><p class="title">${item.getName()}</p></td>
					<td>${item.getDescription()}</td>
					<td>${item.getPrice()}</td>
					<td><a href="<c:url value='/admin/foods/edit?id=${item.getId()}' />"
						class="button">Edit</a></td>
					<td><a href="<c:url value='/admin/foods/delete?id=${item.getId()}' />"
						class="button">Delete</a></td>
					</li>
			</c:forEach>
		</tbody>
	</table>
	<a href="<c:url value='http://localhost:8080/practice/admin/foods/create' />"
	
		class="button">Add new Food</a> </main>
		</br>
		
		<a href="<c:url value='http://localhost:8080/practice/admin/orders' />"
	
		class="button">Manage the order</a> </main>
		</br>
		
	
		<a href="<c:url value='http://localhost:8080/practice/menu' />"
	
		class="button">check your menu</a> </main>

	<footer> © 2017 Tom's #1 World Famous Chiliburgers Inc.,All Rights Reserved 
	</footer>
</body>
</html>