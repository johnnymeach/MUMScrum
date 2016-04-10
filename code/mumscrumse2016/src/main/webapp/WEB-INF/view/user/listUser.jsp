<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<div class="content-panel">
	<table id="userListTable"
		class="table table-striped table-advance table-hover table-bordered table-fixed">
		<thead>
			<tr>
				<th>No</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Role</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:set var="id" value="${1}"/>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${id}</td>
					<c:set var="id" value="${id+1}"/>					
					<td><c:out value="${user.firstName}" /></td>
					<td><c:out value="${user.lastName}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><c:out value="${user.role.name}" /></td>
					<td><a href="<c:url value="/user/${user.id}/edit"/>"
						class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i> </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<span class="navbar-btn"> <a
		href="<c:url value="/createuser"/>"
		class="glyphicon glyphicon-plus btn btn-default custom-button"> Add User</a>
	</span>
</div>