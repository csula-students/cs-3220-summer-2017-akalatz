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
	<h2> Admin Order Status</h2>
<br/>
       <table>
                <thead>
                    <th>Item </th>
                    <th>Customer Name</th>
                    <th>Status</th>
                    <th>Edit</th>
                </thead>
                <tbody>
                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td><ul>
                                <c:forEach items="${order.getFood()}" var="item">
                                     ${item.getName()} 
                                </c:forEach>  
                            </td>
                            <td>${order.getName()}</td>
                            <td>${order.getStatus()}</td>
                            <td><a href="<c:url value='http://localhost:8080/Lab4/orders/edit?id=${order.getId()}' />" class="button">Edit</a>
                                </td>
                    </c:forEach> 
                </tbody>
            </table>
        </main>
        <footer>
        © 2017 Tom's #1 World Famous Chiliburgers Inc.,All Rights Reserved
        </footer>
    </body>
</html>