<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
		<header class="header">
				<div class="header-title">MUM Scrum Project Management Tool</div>
				<div id="menu-toggle" class="btnMenu" >
					<i class="navbar-btn"><a class="glyphicon glyphicon-home btn btn-default btnMenuHeader" href="<c:url value="/"/>">  Home</a></i>
					<sec:authorize access="hasAnyRole('System Admin')">					
					<%-- <i class="fa"><a href="<c:url value="/createuser"/>">Create New User</a></i> --%>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('Scrum Master')">
					<i class="navbar-btn"><a class="glyphicon glyphicon-list btn btn-default btnMenuHeader" href="<c:url value="/sprint"/>">  Sprint</a></i>
					<i class="navbar-btn"><a class="glyphicon glyphicon-th-list btn btn-default btnMenuHeader" href="<c:url value="projectlist"/>">  Project</a></i>
					<i class="navbar-btn"><a class="glyphicon glyphicon-stats btn btn-default btnMenuHeader" href="<c:url value="/burndownchart"/>">  Report</a></i>
					<i class="navbar-btn"><a class="glyphicon glyphicon-file btn btn-default btnMenuHeader" href="<c:url value="/backlogs"/>">  Backlogs</a></i>
					</sec:authorize>
					
				</div>
				<div class="dropdown-slide-animate">
					<div class="dropdown navbar-right no-link">
						<div class="user-role-setting">
							<sec:authorize access="hasAnyRole('Scrum Master')">
							Scrum Master
							</sec:authorize>
							<sec:authorize access="hasAnyRole('System Admin')">
							System Administrator
							</sec:authorize>
							<sec:authorize access="hasAnyRole('Product Owner')">
							Product Owner
							</sec:authorize>
							<sec:authorize access="hasAnyRole('Developer')">
							Developer
							</sec:authorize>
						</div>
					  	<a data-toggle="dropdown" href="#">
					  		<span class="glyphicon glyphicon-user color-white"></span>
					  		<span class="name color-white">${pageContext.request.userPrincipal.name} </span> &nbsp;<i class="fa fa-angle-down color-white"></i>
					  	</a>
					  	<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
					   	 	<!-- <li><a href="#"><i class="fa fa-credit-card"></i> <span>Profile</span></a></li>
					   	 	<li><a href="#"><i class="fa fa-cogs"></i> <span>Change Password</span></a></li>				   	 	
					   	 	<li class="divider"></li> -->
					   	 	<li>
					   	 	<c:url value="/logout" var="logoutUrl" />
							<form action="${logoutUrl}" method="post" id="logoutForm">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
							<script>
								function formSubmit() {
									document.getElementById("logoutForm").submit();
								}
							</script>
					
							<c:if test="${pageContext.request.userPrincipal.name != null}">
								<a href="javascript:formSubmit()"><i class="fa fa-sign-out"></i> <span>Log Out</span></a>
							</c:if>					   	 	
					   	 	</li>
					  	</ul>
					</div>
				</div>
		</header>