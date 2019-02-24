<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PlantNursery</title>
</head>
<body>
    <h3>List of Books</h3>
    <c:if test="${empty param.personName && not empty param.status}">
        Show books with status = <b>${param.status}</b><br>
    </c:if>
    <c:forEach var="book" items="${books}">
        <b>Book:</b> ${book} <br>
    </c:forEach>

</body>
</html>