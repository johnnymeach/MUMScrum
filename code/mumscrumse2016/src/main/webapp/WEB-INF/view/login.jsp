<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login MUM Scrum System</title>
<link href="<c:url value="/resources/bootstrap-3.3.6/css/bootstrap.min.css" />" rel="stylesheet" >
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" >
<script src="<c:url value="/resources/js/jquery-1.11.3.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/bootstrap-3.3.6/jsbootstrap.min.js"/>" type="text/javascript"></script>
</head>
<body>
	<form name="loginForm" action="/login" method="post">
		<div class="container" style="margin-top: 100px;">
	        <div class="row">
	            <div class="col-md-6 col-md-offset-3">
	                <div class="panel panel-default">
	                    <div class="panel-heading">
	                        <h3 class="panel-title">Sign in</h3>
	                    </div>
	                    <div class="panel-body">
	                            <fieldset>
	                                <div class="form-group">
	                                	<input type="text" name="email" class="form-control" placeholder="Email" autofocus />
	                                    <p class="errorLabel"></p>
	                                </div>
	                                <div class="form-group">
	                                	<input type="password" class="form-control" name="password" placeholder="password" />
	                                    <p class="errorLabel"></p>
	                                    <small class="text-muted text-center">Note: Password is case sensitive</small>
	                                </div>
	                                <p id="forgotPassword"><a href="#">Forgot your password?</a></p>
	                                <input type="submit" class="btn btn-lg btn-success btn-block" value="Login" />
	                            </fieldset>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	</form>
</body>
</html>