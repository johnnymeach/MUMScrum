<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<div class="content-panel">
	<table id="userListTable"
		class="table table-striped table-advance table-hover">
		<thead>
			<tr>
				<th></th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Role</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td></td>
					<td><c:out value="${user.firstName}" /></td>
					<td><c:out value="${user.lastName}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><c:out value="${user.role.name}" /></td>
					<td>
						<a href="<c:url value="/user/${user.id}/edit"/>"
						class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>