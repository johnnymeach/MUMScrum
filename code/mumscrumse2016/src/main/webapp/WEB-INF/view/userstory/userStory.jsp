<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<div class="content-panel">
	<div>
		<h1>Backlogs</h1>
	</div>
	<form:form class="form-horizontal" role="form" commandName="userstory"
		action="" method="post" id="formProjectList">
		<div class="form-group">
			<label class="col-sm-offset-6 control-label col-sm-2" for="projectFilter">Filter By Project:</label>
			<div class="col-sm-4">
				<form:select path="project.id"  itemValue="id"
					itemLabel="name" cssClass="form-control" id="projectFilter" >
					<option value="zero">All</option>
					<c:forEach items="${projects}" var="p">
						<option value="${p.name}">${p.name}</option>
					</c:forEach>
				</form:select>
			</div>
		</div>
	</form:form>
	<table id="userStoryListTable"
			class="table table-striped table-advance table-hover table-bordered table-fixed">
			<colgroup>
		       <col span="1" style="width: 5%;">
		       <col span="1" style="width: 30%;">
		       <col span="1" style="width: 20%;">
		       <col span="1" style="width: 10%;">
		       <col span="1" style="width: 10%;">
		       <col span="1" style="width: 5%;">
		       <col span="1" style="width: 5%;">
		       <col span="1" style="width: 10%;">
    		</colgroup>
			<thead>
				<tr>
					<th>ID</th>
					<th>User story Title</th>
					<th>Project Name</th>
					<th>Developer</th>
					<th>Sprint</th>
					<th>Estimated Time</th>
					<th>Completed Time</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userstories}" var="userstory">
					<tr class="${userstory.project.name}">	
						<td><c:out value="${userstory.id}" /></td>			
						<td><c:out value="${userstory.name}" /></td>
						<td><c:out value="${userstory.project.name}" /></td>
						<td><c:out value="${userstory.user.email}" /></td>
						<td><c:out value="${userstory.sprint.name}" /></td>
						<td><c:out value="" />${userstory.estimatedTime}</td>
						<td><c:out value="" />${userstory.completedTime}</td>
						<td>
							<div class="buttonAction">
								<a href="<c:url value="/backlogs/${userstory.id}/${userstory.project.id}/edit"/>" 
								class="btn btn-primary btn-sm">
								<i class="fa fa-pencil"></i></a>
							</div>
							<button data-target="#deleteuserstory" data-toggle="modal"
								class="btn btn-danger btn-sm" name="userstory" value="${userstory.id}">
								<i class="fa fa-remove"></i>
							</button>
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
					<h4 class="modal-title" id="myModalLabel">Do you want to delete this user story?
					All the time logs associated with the user story will also be deleted.</h4>
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
		});
		$("#projectFilter").on("change", function(){
		    var opt = $(this).val();
		    $("tr", "tbody").each(function(){
		      var tr = $(this);
		      tr.show();
		      
		      if (opt == "zero"){
		        tr.show();
		      } else if (! tr.hasClass(opt)){
		        tr.hide();
		      }
		    });
		  });
	});
</script>