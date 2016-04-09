<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>404 Page Not Found</title>
</head>
<body>
<h2>${item.item}</h2>
<c:forEach items="${item.itemitems}" var="itemitem">
<p>${itemitem.itemLatin}</p>
</c:forEach>
<div class="centerImage"><img src="<c:url value="/resources/img/404.png"/>" alt="404 Page Not Found" title="404 Page Not Found"></div>
</body>
</html>
 