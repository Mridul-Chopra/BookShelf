<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="../../resources/styles/order.css">
  <script src="../../resources/scripts/order.js"></script>


<title>Insert title here</title>
</head>
<body>

<p name="email" class="hide">${email}</p>
<p name="page" class="hide">${page}</p>

<div class ="container-fluid">
	<div class="row row-1">
		<div class="col-sm-4 col-md-4 col-lg-4 col-xl-4 "></div>
		<div class="col-sm-4 col-md-4 col-lg-4 col-xl-4 heading">Place an Order</div>
		<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 cart-col"><i class="material-icons cart-icon">local_grocery_store</i>
</div>
	</div>
	<div class="row row-2">
		<div class="col-sm-4 col-md-4 col-lg-4 col-xl-4 "></div>
		<div class="col-sm-5 col-md-5 col-lg-5 col-xl-5 ">
			<div class="row">
				<div class="col-sm-6 col-md-6 col-lg-6 col-xl-6 ">
						<select name="author">
							<option value="All">All</option>
							<c:forEach var="author" items="${authorsList}">
								<c:choose>
									<c:when test="${author==authorName}">
										<option selected>${author}</option>
									</c:when>

									<c:otherwise>
										<option>${author}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
				</div>
				
				<div class="col-sm-6 col-md-6 col-lg-6 col-xl-6 ">
						<select name="genre">
							<option value="All">All</option>
							<c:forEach var="genre" items="${genresList}">
								<c:choose>
									<c:when test="${genre==genreType}">
										<option selected>${genre}</option>
									</c:when>
									<c:otherwise>
										<option>${genre}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
				</div>	
			</div>	
			
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 ">
					<button id="apply" class="btn btn-secondary filter" myContextPath="${pageContext.request.contextPath}">
						Apply Filter
					</button>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-10 col-md-10 col-lg-10 col-xl-10 message">
					${message}
				</div>
			</div>
		</div>
	</div>
	
	<div class = "row row-3">
		<div class="col-sm-2 col-md-2 col-lg-2 col-xl-2 "></div>
		<div class="col-sm-8 col-md-8 col-lg-8 col-xl-8 table responsive">
			<table class="table table-hover table-bordered all">
				<thead class="thead-dark">	
					<tr>
						<th>Book Name</th>
						<th>Authors</th>
						<th>Genre</th>
						<th>Price</th>
						<th></th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="book" items="${booksList}">
						<tr class="books-row">
							<td>${book.bookName}</td>
							<td>
								<c:forEach var="author" items="${book.authors}">
										<ul>
											<li>${author}</li>
										</ul>
								</c:forEach>
							</td>
							<td>${book.genre}</td>
							<td>Rs . ${book.price}</td>
							<td class="cart-button">
								<button class="add-to-cart">Add to 'Cart'
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				
			</table>
		</div>
	</div>
	
</div>

<div class="jumbotron cart" id="cart-box">
	<i class="material-icons cross-icon">clear</i>
<div class="container">
<div class="row">
	<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 cart-heading ">Your Cart</div>
</div>
	<table class="table table-bordered table-hover orders" id="cart">
			<thead class="thead-dark">
			<tr>
				<th>Book Name</th>
				<th> Quantity </th>
				<th></th>
			</tr>
			</thead>
			<tbody>
			</tbody>
	</table>
	<div class="row">
		<div class="col-sm-4 col-md-4 col-lg-4 col-xl-4 ">
		</div>
		<div class="col-sm-5 col-md-5 col-lg-5 col-xl-5 ">
			<p class = "text-primary order-message"></p>
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-5 col-md-5 col-lg-5 col-xl-5 "></div>
		<div class="col-sm-4 col-md-4 col-lg-4 col-xl-4 ">
			<button class="btn btn-success place-order" myContextPath="${pageContext.request.contextPath}">Place Order</button>
		</div>
	</div>
</div>
</div>



</body>
</html>