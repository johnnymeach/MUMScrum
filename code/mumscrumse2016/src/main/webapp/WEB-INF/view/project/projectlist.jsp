<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<div class="content-panel">

	<h2>Projects</h2><hr>
	<table id="projectListTable"
		class="table table-striped table-advance table-hover table-bordered table-fixed">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Scrum Master</th>
				<th width="10%">Action</th>
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
	<span class="navbar-btn"> <a
		href="<c:url value="/createproject"/>"
		class="glyphicon glyphicon-plus btn btn-primary"> Add New Project</a>
	</span>
</div>