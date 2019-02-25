<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PlantNursery</title>

<link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/css/nursery.css">

</head>
<body>
    <h3>Status of PlantNursery</h3>

    <table>
        <c:forEach var="plant" items="${plantNursery.getPlants()}">
            <tr><td align="right">
                <form action="${pageContext.servletContext.contextPath}/plantNursery/plant/remove" method="post">
                    <b>Plant:</b> ${plant}
                    <input type="hidden" name="id" value="${plant.id}"/>
                    <input type="submit" value="Remove" />
                </form>
            </td><td>
                <form action="${pageContext.servletContext.contextPath}/edit-plant" method="get">
                    <input type="hidden" name="id" value="${plant.id}"/>
                    <input type="submit" value="Change amount" />
                </form>
            </td></tr>
        </c:forEach>
    </table>
    <br>

    <table>
        <tr><th>Add plant</th><tr>
        <tr><td>
            <form action="${pageContext.servletContext.contextPath}/plantNursery/plant/add" method="post">
                Title: <input type="text" name="title" /> <br>
                Amount: <input type="text" name="amount" /> <br>
                Type: <select name="type"><br>
	                <c:forEach var="pType" items="${plantTypes}"><option value="${pType}">${pType}</option></c:forEach>
                </select>
                Description: <input type="text" name="description" /> <br>                
                <input type="submit" value="Add plant" />
            </form>
        </td>
        <tr>
    </table>
</body>
</html>