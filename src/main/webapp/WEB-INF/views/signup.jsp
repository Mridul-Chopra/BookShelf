<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>SignUp</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="resources/styles/sign-in-up.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	</head>
	
	<body>
		
		
		<div class="container-fluid">
			<div class="row row-1">
						<div class="col-sm-4 col-md-4 col-lg-4 col-xl-4 "></div>
						<div class="col-sm-4 col-md-4 col-lg-4 col-xl-4 heading">Sign Up</div>
			</div>
			
			<div class="row row-2">
						<div class="col-sm-4 col-md-4 col-lg-4 col-xl-4"></div>
						<div class="col-sm-4 col-md-4 col-lg-4 col-xl-4 form">
							<form:form action="signup" commandName="userForm" name="myForm">
								<div class="form-group">
									<label for="email">Email : </label>
									<form:input path="email" id="email" name="email" cssClass="form-control"/>
									<form:errors path="email" cssClass="error-feedback"/>
								</div>
								
								<div class="form-group">
									<label for="password">Password : </label>
									<form:input path="password" id="password" name="password" cssClass="form-control"/>
									<form:errors path="password" cssClass="error-feedback"/>
								</div>
								
								<div class="form-group">
									<label for="address">Address : </label>
									<form:input path="address" id="address" name="address" cssClass="form-control"/>
									<form:errors path="address" cssClass="error-feedback"/>
								</div>
								
								<div class="form-group message">
									${message}
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