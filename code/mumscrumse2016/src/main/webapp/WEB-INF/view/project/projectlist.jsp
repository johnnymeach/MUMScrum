<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<div class="content-panel">

	Project List <a href="/mumscrum/createproject">Create Project</a><hr>
	<table id="projectListTable"
		class="table table-striped table-advance table-hover table-bordered table-fixed">
		<thead>
			<tr>
				<th>ID</th>
				<th>Project Name</th>
				<th>Project Description</th>
				<th>Scrum Master</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${projects}" var="p">
				<tr>
					<td>
					${p.id}
					
					</td>					
					<td><c:out value="${p.name}" /></td>
					<td><c:out value="${p.description}" /></td>
					<td><c:out value="${p.user.email}" /></td>
					<td><a href="<c:url value="/project/${p.id}/edit"/>"
						class="btn btn-primary btn-xs">Edit </a>
						<a href="<c:url value="/projectdelete/${p.id}"/>"
						class="btn btn-primary btn-xs">Delete </a>
						
						</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>