<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>
</head>
<body>
	<sec:authorize access="hasAnyRole('System Admin')">
		<h2>This is the system admin dashboard</h2>
		<%@ include file="/WEB-INF/view/user/listUser.jsp" %>
	</sec:authorize>
	<sec:authorize access="hasAnyRole('Scrum Master')">
		<h2>This is the scrum master dashboard</h2>
	</sec:authorize>
</body>
</html>
