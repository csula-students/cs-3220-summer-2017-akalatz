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
	<h2>Shopping Cart</h2>
	 <table>
                <thead>
                    <th>Item</th>
                    <th>Name</th>
                    <th>Action</th>
                </thead>
                <tbody> 
                    <c:forEach items="${cart}" var="item">
                        <tr>
                            <td>${item.getFoodName()}</td>
                            <td>${item.getPrice()}</td>
                            <td><a href="<c:url value='/cart/delete?id=${item.getId()}' />" class="button">Remove item from cart</a>    </td>
                        </tr>
                    </c:forEach> 
                    <c:if test="${cart.size() > 0}">
                        <tr>
                            <td colspan="3"><a href="<c:url value='/cart/orders' />" class="button">Place your order</a></td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </main>
        