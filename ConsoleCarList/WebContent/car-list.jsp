<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of cars</title>
</head>
<body>
<table>
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
	<td><input type="radio" name="id" value="${currentitem.id}"></td>
	<td>${currentitem.make}</td>
	<td>${currentitem.model}</td>
	<td>${currentitem.year}</td>
</tr>
</c:forEach>
</table>
<a href="index">Return to homepage</a>
</body>
</html>