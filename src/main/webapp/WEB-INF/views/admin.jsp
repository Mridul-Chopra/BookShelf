<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="resources/styles/admin.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="resources/scripts/admin.js"></script>
	<script src="resources/scripts/cart.js"></script>
	<title>Welcome Admin</title>
</head>

<body>
	<div class="container-fluid">
		<div class="row row-1">
				<div class="col-sm-4 col-md-4 col-lg-4 col-xl-4 "></div>
				<div class="col-sm-4 col-md-4 col-lg-4 col-xl-4 heading">Welcome Admin</div>
		</div>
		
		<div class ="row row-2">
			<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 "></div>
			<div class="col-sm-6 col-md-6 col-lg-6 col-xl-6">
			<div class="row">
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 ">
						<form action="all" method="get">
							<input type="submit" value="Show all books" class="option">
						</form>
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 ">
						<form action="purchases" method="get">
							<input type="submit" value="Show all purchases" class="option">
						</form>
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 ">
						<form action="orders" method="get">
							<input type="submit" value="Show all orders" class="option">
						</form>
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 ">
						<form action="add" method="get">
							<input type="submit" value="Add a book purchase" class="option">
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class ="row row-3">
			<div class="col-sm-2 col-md-2 col-lg-2 col-xl-2 "></div>
			<div class="col-sm-8 col-md-8 col-lg-8 col-xl-8 table responsive">
				<table class="table table-hover table-bordered">
						<c:if test = "${option == 1}">	
							<thead class="thead-dark">
								<tr>
									<th>Book Name</th>
									<th>Stock</th>
									<th> Genre </th>
									<th> Price </th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="book" items="${booksList}">
									<tr>
										<td>${book.bookName}</td>
										<td> ${book.genre}</td>
										<td> ${book.stock}</td>
										<td> ${book.price}</td>
									</tr>
								</c:forEach>
							</tbody>
						</c:if>
			
			
					 <c:if test = "${option == 2}">	
						<thead class="thead-dark">
							<tr>
								<th>Book Name</th>
								<th>Amount</th>
								<th> Date of Purchase </th>
							</tr>
						</thead>
					
						<tbody>
							<c:forEach var="book" items="${booksList}">
								<tr>
									<td>${book.bookName}</td>
									<td> ${book.amount}</td>
									<td> ${book.date}</td>
								</tr>
							</c:forEach>
						</tbody>
					</c:if>
						
					<c:if test = "${option == 3}">	
						<thead class="thead-dark">
							<tr>
								<th>Order ID</th>
								<th>Customer's Email</th>
								<th> Book Name </th>
								<th>Amount</th>
								<th>Date of Order</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="order" items="${ordersList}">
								<tr>
									<td>${order.orderID}</td>
									<td>${order.email}</td>
									<td>${order.bookName}</td>
									<td>${order.amount}</td>
									<td>${order.date}</td>
								</tr>
							</c:forEach>
						</tbody>
					</c:if>
				</table>
			</div>
		</div>
	</div>
	

	
	</body>
</html>