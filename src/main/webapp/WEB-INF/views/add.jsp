<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>SignUp</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="resources/styles/sign-in-up.css">
	<link rel="stylesheet" type="text/css" href="resources/styles/add.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <script src='resources/scripts/add.js'></script>
	
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">BookShelf</a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/logout" />">Logout</a>
    </li>
    
     <li class="nav-item">
      <a class="nav-link" href="admin">Back to previous page</a>
    </li>
    
  </ul>
</nav>

	<div class="container-fluid">
		
				<div class="row row-1">
							<div class="col-sm-4 col-md-4 col-lg-4 col-xl-4 "></div>
							<div class="col-sm-4 col-md-4 col-lg-4 col-xl-4 heading">Add a 'Books Purchase'</div>
				</div>
				
				<div class="row row-2">
							<div class="col-sm-4 col-md-4 col-lg-4 col-xl-4"></div>
							<div class="col-sm-4 col-md-4 col-lg-4 col-xl-4 form">
								<form:form action="add" commandName="userForm" name="myForm">
									<div class="form-group">
										<label for="bookName">Book Name : </label>
										<form:input path="bookName" id="bookName" name="bookName" cssClass="form-control"/>
										<form:errors path="bookName" cssClass="error-feedback"/>
									</div>
									
									<div class="form-group authors">
										<label for="author" id="plus">Author : </label>
										<i class="fa fa-plus-square plus" style="font-size:2em;color:#ffb366" ></i>
										<form:input path="author" id="author" name="author" cssClass="form-control"/>
										<form:errors path="author" cssClass="error-feedback"/>
									</div>
									
									<div class="form-group box">
									</div>
									
									<div class="form-group">
										<label for="date">Date : </label>
										<form:input type="date" path="date" id="date" name="date" cssClass="form-control"/>
										<form:errors path="date" cssClass="error-feedback"/>
									</div>
									
									<div class="form-group">
										<label for="amount">Amount : </label>
										<form:input type="number" min="0"  path="amount" id="amount" name="amount" cssClass="form-control"/>
										<form:errors path="amount" cssClass="error-feedback"/>
									</div>
									
									<div class="form-group">
										<label for="price">Price : </label>
										<form:input type="number" step="0.01" min="0.0" path="price" id="price" name="price" cssClass="form-control"/>
										<form:errors path="price" cssClass="error-feedback"/>
									</div>
									
									<div class="form-group">
										<label for="genre">Genre : </label>
										<form:input path="genre" id="address" name="address" cssClass="form-control"/>
										<form:errors path="genre" cssClass="error-feedback"/>
									</div>
									
									<div class="form-group message">
										${result}
									</div>
									
									<div class="form-group button">
										<button type="submit" class="btn btn-primary">Submit</button>
									</div>
								</form:form>
							</div>
						</div>
				
				
			</div>
	</body>
</html>