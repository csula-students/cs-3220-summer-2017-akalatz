<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="WEB-INF/Admin-Header.tld" prefix="tag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tom's #1 World Famous Chiliburgers</title>
<link rel="stylesheet" href="app.css">

</head>
<body bgcolor="#E6E6FA">

	<tag:Aheader />

	<main>
            <table>
                <thead>
                    <th> </th>
                    <th>Name</th>
                    <th>Status</th>
                    <th>Edit</th>
                </thead>
                <tbody>
                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td> </td>
                            <td>${order.getName()}</td>
                            <td>${order.getStatus()}</td>
                            <td><a href="<c:url value='/orders/edit?id=${order.getId()}' />" class="button">Edit</a>
                                </td>
                    </c:forEach> 
                </tbody>
            </table>
        </main>
        <footer>
        � 2017 Tom's #1 World Famous Chiliburgers Inc.,All Rights Reserved
        </footer>
    </body>
</html>