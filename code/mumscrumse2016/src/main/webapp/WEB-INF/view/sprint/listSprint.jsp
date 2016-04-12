<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<div class="content-panel">
	<table id="userListTable"
		class="table table-striped table-advance table-hover table-bordered table-fixed">
		<thead>
			<tr>
				<th>No</th>
				<th>Name</th>
				<th>Description</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:set var="id" value="${1}"/>
		<tbody>
			<c:forEach items="${sprints}" var="sprint">
				<tr>
					<td>${id}</td>
					<c:set var="id" value="${id+1}"/>					
					<td><c:out value="${sprint.name}" /></td>
					<td><c:out value="${sprint.description}" /></td>
					<td><c:out value="${sprint.startDate}" /></td>
					<td><c:out value="${sprint.endDate}" /></td>
					<td><a href="<c:url value="/sprint/${sprint.id}/edit"/>"
						class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i> </a>
						<button data-target="#deleteuser" data-toggle="modal"
							class="btn btn-primary btn-xs" name="sprint" value="${sprint.id}"><i class="fa fa-remove text-danger"></i></button>
						</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<span class="navbar-btn"> <a
		href="<c:url value="/createsprint"/>"
		class="glyphicon glyphicon-plus btn btn-primary"> Add Sprint</a>
	</span>
	
	<!-- Modal For Delete Sprint -->
	<div class="modal fade" id="deletesprint" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Do you want to delete this user?</h4>
				</div>
				<div class="modal-body">
					<form id="formDeleteSprint" method="post"
						action="<spring:url value="/deletesprint" />" class="form-horizontal">
						
						<input id="sprintId" name="sprintId" type="hidden" value="" /> <input
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
	$(document).ready(function(){
		$("button[name = 'sprint']").click(function(){
			//console.log("Value of button : "+$(this).val());
			$("#sprintId").val($(this).val());
			console.log("Value of button : "+$("#sprintId").val());
			
		});
	});
</script>