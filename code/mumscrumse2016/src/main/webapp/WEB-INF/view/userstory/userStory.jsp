<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<div class="content-panel">
	<div>
		<h1>Backlogs</h1>
	</div>

	<table id="userStoryListTable"
			class="table table-striped table-advance table-hover table-bordered table-fixed">
			<colgroup>
		       <col span="1" style="width: 5%;">
		       <col span="1" style="width: 25%;">
		       <col span="1" style="width: 60%;">
		       <col span="1" style="width: 10%;">
    		</colgroup>
			<thead>
				<tr>
					<th>No</th>
					<th>User story Title</th>
					<th>Description</th>
					<th>Action</th>
				</tr>
			</thead>
			<c:set var="id" value="${1}"/>
			<tbody>
				<c:forEach items="${userstories}" var="userstory">
					<tr>
						<td>${id}</td>
						<c:set var="id" value="${id+1}"/>					
						<td><c:out value="${userstory.name}" /></td>
						<td><c:out value="${userstory.description}" /></td>
						<td><a href="<c:url value="/backlogs/${userstory.id}/edit"/>"
						class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></a>
						<button data-target="#deleteuserstory" data-toggle="modal"
							class="btn btn-primary btn-xs" name="userstory" value="${userstory.id}">
							<i class="fa fa-remove text-danger"></i></button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<span class="navbar-btn"> 
		<a href="<c:url value="/createuserstory"/>" class="glyphicon glyphicon-plus btn btn-primary"> Add User Story</a>
	</span>
	
		<!-- Modal For Delete User story -->
	<div class="modal fade" id="deleteuserstory" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Do you want to delete this user story?</h4>
				</div>
				<div class="modal-body">
					<form id="formDeleteUserStory" method="post"
						action="<spring:url value="backlogs/deleteUserStory" />" class="form-horizontal">
						
						<input id="userStoryId" name="userStoryId" type="hidden" value="" /> 
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
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
		$("button[name = 'userstory']").click(function(){
			$("#userStoryId").val($(this).val());
			console.log("Value of button : "+$("#userStoryId").val());
			
		});
	});
</script>