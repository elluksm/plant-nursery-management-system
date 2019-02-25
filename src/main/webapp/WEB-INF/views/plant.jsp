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
    <h3>Edit plant ammount</h3>
    
    <c:if test="${plant != null}">
    
    
    
                <form action="${pageContext.servletContext.contextPath}/plantNursery/plant/edit" method="post">
                <input type="hidden" name="id" value="${plant.id}"/>
                Title: <input type="text" name="newTitle" value=${plant.title} /> <br>
                Amount: <input type="text" name="newAmount" value=${plant.amount} /> <br>
                Type: <select name="newType"><br>
	                <c:forEach var="pType" items="${plantTypes}"><option ${pType == plant.type?"selected":""} value="${pType}">${pType}</option></c:forEach>
                </select>
                Description: <input type="text" name="newDescription"  value=${plant.description} /> <br>                
                <input type="submit" value="Submit changes" />
            </form>
            <a href="/plantNursery">Cancel</a>
    
    
    </c:if>
    <c:if test="${plant == null}">
    	Error: Please go back and choose plant to edit!
    </c:if> 
    
    
    <c:if test="${empty param.personName && not empty param.status}">
        Show books with status = <b>${param.status}</b><br>
    </c:if>
    <c:forEach var="book" items="${books}">
        <b>Book:</b> ${book} <br>
    </c:forEach>

</body>
</html>