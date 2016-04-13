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
				<th>Action</th>
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
					<td>
						<div class="buttonAction">
							<a href="<c:url value="/project/${p.id}/edit"/>" class="btn btn-primary btn-sm"><i class="fa fa-pencil"></i></a>
						</div>
						<div>
							<a href="<c:url value="/projectdelete/${p.id}"/>" class="btn btn-danger btn-sm"><i class="fa fa-remove"></i></a>
						</div>
						</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>