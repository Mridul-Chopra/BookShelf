<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>SignUp</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="resources/styles/sign-in-up.css">
	<link rel="stylesheet" type="text/css" href="resources/styles/add.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
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
									
									<div class="form-group">
										<label for="author">Author : </label>
										<form:input path="author" id="password" name="author" cssClass="form-control"/>
										<form:errors path="author" cssClass="error-feedback"/>
									</div>
									
									<div class="form-group">
										<label for="date">Date : </label>
										<form:input path="date" id="date" name="date" cssClass="form-control"/>
										<form:errors path="date" cssClass="error-feedback"/>
									</div>
									
									<div class="form-group">
										<label for="amount">Amount : </label>
										<form:input path="amount" id="amount" name="amount" cssClass="form-control"/>
										<form:errors path="amount" cssClass="error-feedback"/>
									</div>
									
									<div class="form-group">
										<label for="price">Price : </label>
										<form:input path="price" id="price" name="price" cssClass="form-control"/>
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