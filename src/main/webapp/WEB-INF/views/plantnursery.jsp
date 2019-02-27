<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PlantNursery</title>

<link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/css/nursery.css">

</head>
<body>

	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">My Plant Nursery</h1>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3">
				<h3>Flowers</h3>

				<c:forEach var="plant" items="${flowers}">
					<div class="card bg-light mb-3" style="width: 100%;">
						<div class="card-header">${plant.title}</div>
						<div class="card-body">
							<p class="card-text">${plant.description}</p>
							<p class="card-text">Available amount: ${plant.amount}</p>

							<form
								action="${pageContext.servletContext.contextPath}/plantNursery/plant/remove"
								method="post">
								<input type="hidden" name="id" value="${plant.id}" /> <input
									type="submit" value="Delete" />
							</form>

							<form
								action="${pageContext.servletContext.contextPath}/edit-plant"
								method="get">
								<input type="hidden" name="id" value="${plant.id}" /> <input
									type="submit" value="Change amount" />
							</form>
						</div>
					</div>
				</c:forEach>

			</div>
			<div class="col-sm-3">
				<h3>Herbs</h3>

				<c:forEach var="plant" items="${herbs}">
					<div class="card bg-light mb-3" style="width: 100%;">
					<div class="card-header">${plant.title}</div>
						<div class="card-body">
							<p class="card-text">${plant.description}</p>
							<p class="card-text">Available amount: ${plant.amount}</p>

							<form
								action="${pageContext.servletContext.contextPath}/plantNursery/plant/remove"
								method="post">
								<input type="hidden" name="id" value="${plant.id}" /> <input
									type="submit" value="Delete" />
							</form>

							<form
								action="${pageContext.servletContext.contextPath}/edit-plant"
								method="get">
								<input type="hidden" name="id" value="${plant.id}" /> <input
									type="submit" value="Change amount" />
							</form>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="col-sm-3">
				<h3>Vegetables</h3>

				<c:forEach var="plant" items="${vegetables}">
					<div class="card bg-light mb-3" style="width: 100%;">
					<div class="card-header">${plant.title}</div>
						<div class="card-body">
							<p class="card-text">${plant.description}</p>
							<p class="card-text">Available amount: ${plant.amount}</p>

							<form
								action="${pageContext.servletContext.contextPath}/plantNursery/plant/remove"
								method="post">
								<input type="hidden" name="id" value="${plant.id}" /> <input
									type="submit" value="Delete" />
							</form>

							<form
								action="${pageContext.servletContext.contextPath}/edit-plant"
								method="get">
								<input type="hidden" name="id" value="${plant.id}" /> <input
									type="submit" value="Change amount" />
							</form>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="col-sm-3">
				<h3>Add new plant</h3>
				<form
					action="${pageContext.servletContext.contextPath}/plantNursery/plant/add"
					method="post">
					Title: <input type="text" name="title" class="form-control"/> <br> Amount: <input
						type="text" name="amount" class="form-control" /> <br> Type: <select name="type" class="form-control">
						<c:forEach var="pType" items="${plantTypes}">
							<option value="${pType}">${pType}</option>
						</c:forEach>
					</select><br> Description:
					<textarea rows="4" name="description" class="form-control"></textarea>
					<br> <input type="submit" value="Add plant"/>
				</form>
			</div>
		</div>
	</div>

</body>
</html>