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
							<button data-target="#deleteproject" data-toggle="modal" class="btn btn-danger btn-sm" name="project" value="${p.id}" title="Delete">
								<i class="fa fa-remove"></i>
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
<!-- Modal For Delete Project -->
	<div class="modal fade" id="deleteproject" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Do you want to
						delete this project? All the 
Sprints associated with this project will also be deleted.</h4>
				</div>
				<div class="modal-body">
					<form id="formDeleteProject" method="post"
						action="<spring:url value="/projectdelete" />"
						class="form-horizontal">

						<input id="projectId" name="projectId" type="hidden" value="" /> <input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<div class="form-group">
							<div class="col-md-offset-4 col-md-4">
								<button type="submit" id="btnDelete" class="btn btn-primary ">Yes</button>
								<button class="btn " data-dismiss="modal" aria-hidden="true">No</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$("button[name = 'project']").click(function() {
			$("#projectId").val($(this).val());

		});
	});
</script>
		