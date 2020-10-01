<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit car from database</title>
</head>
<body>
<form action = "editCarServlet" method = "post">
	Make: <input type = "text" name = "make" value = "${carToEdit.make}">
	Model: <input type = "text" name = "model" value = "${carToEdit.model}">
	Year: <input type = "text" name = "year" value = "${carToEdit.year}">
	<input type = "hidden" name = "id" value = "${carToEdit.id}">
	<input type = "submit" value = "Save edited car">
</form>
</body>
</html>