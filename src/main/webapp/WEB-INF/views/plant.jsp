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
    <h2>Edit available amount</h2>
    
    <c:if test="${plant != null}">
    
                <form action="${pageContext.servletContext.contextPath}/plantNursery/plant/edit" method="post">
                <input type="hidden" name="id" value="${plant.id}"/>
                <p>Title: ${plant.title}</p>
                <p>Type: ${plant.type}</p>
                <p>Description: ${plant.description}</p>
                Amount: <input type="text" name="newAmount" value=${plant.amount} class="form-control"/> <br>
                <br>
                <input type="submit" value="Submit changes" />
            </form>
            <br>
            <a href="/plantNursery">Cancel</a>
    
    
    </c:if>
    <c:if test="${plant == null}">
    	Error: Please go back and choose plant to edit!
    </c:if> 


</body>
</html>