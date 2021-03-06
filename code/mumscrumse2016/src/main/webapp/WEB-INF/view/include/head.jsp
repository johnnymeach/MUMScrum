
<%@ include file="../include/taglib.jsp"%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<c:choose>
	<c:when test="${sessionScope.desktopmode=='true'}">
		<meta name="viewport" content="width=1024">
	</c:when>
	<c:otherwise>
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	</c:otherwise>
</c:choose>

<link
	href="<c:url value="/resources/bootstrap-3.3.6/css/bootstrap.min.css"/>"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.3.js"/>"
	type="text/javascript"></script>
<script
	src="<c:url value="/resources/bootstrap-3.3.6/js/bootstrap.min.js"/>"
	type="text/javascript"></script>
<script
	src="<c:url value="/resources/bootstrap-3.3.6/js/Chart.min.js"/>"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery.validate.min.js"/>"
	type="text/javascript"></script>
<link href="<c:url value="/resources/datepicker/css/datepicker.css"/>"
	rel="stylesheet">
<script
	src="<c:url value="/resources/datepicker/js/bootstrap-datepicker.js"/>"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/main.js"/>"
	type="text/javascript"></script>

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/user.css"/>" rel="stylesheet">

<link
	href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>"
	rel="stylesheet" />

