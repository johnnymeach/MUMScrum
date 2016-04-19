<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<div class="content-panel">
<h2>Sprints</h2>
	<form:form class="form-horizontal" role="form" commandName="sprint"
		action="" method="post" id="formProjectList">
		<div class="form-group">
			<label class="col-sm-offset-6 control-label col-sm-2" for="project">Filter By Project:</label>
			<div class="col-sm-4">
				<form:select path="project.id"  itemValue="id"
					itemLabel="name" cssClass="form-control" id="projectFilter" >
					<%-- <option value="0">All</option>
					<c:forEach items="${projects}" var="p">
						<option value="${p.id}">${p.name }</option>
					</c:forEach> --%>
					<option value="zero">All</option>
					<c:forEach items="${projects}" var="p">
						<option value="${p.name}">${p.name}</option>
					</c:forEach>
				</form:select>
			</div>
		</div>
		<input id="projectId" name="projectId" type="hidden" value="" />
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form:form>
	<div id="tableSprint">
		<table id="sprintListTable"
			class="table table-striped table-advance table-hover table-bordered table-fixed">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Description</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Project Name</th>
					<th width="10%">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sprints}" var="sprint">
					<tr class="${sprint.project.name}">
						<td><c:out value="${sprint.id}" /></td>
						<td><c:out value="${sprint.name}" /></td>
						<td><c:out value="${sprint.description}" /></td>
						<td><c:out value="${sprint.startDate}" /></td>
						<td><c:out value="${sprint.endDate}" /></td>
						<td><c:out value="${sprint.project.name}" /></td>
						<td>
							<div class="buttonAction">
								<a href="<c:url value="/sprint/${sprint.id}/edit"/>" class="btn btn-primary btn-sm" title="Edit"><i class="fa fa-pencil"></i></a>
							</div>
							<div>
								<button data-target="#deletesprint" data-toggle="modal" class="btn btn-danger btn-sm" name="sprint" value="${sprint.id}" title="Delete">
								<i class="fa fa-remove"></i>
							</button>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

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
					<h4 class="modal-title" id="myModalLabel">Do you want to
						delete this user?</h4>
				</div>
				<div class="modal-body">
					<form id="formDeleteSprint" method="post"
						action="<spring:url value="/deletesprint" />"
						class="form-horizontal">

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
	$(document).ready(function() {
		$("button[name = 'sprint']").click(function() {
			$("#sprintId").val($(this).val());

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

		/* $('#projectFilter').on('change', function() {
			$("#projectId").val($('#projectFilter').val());
			var projectId = $("#projectId").val();
			var data = {
				"projectId" : projectId
			};
			
			var url = "<c:url value='/sprint/'/>";
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : url + projectId,
				data : JSON.stringify(data),
				success : function(result) {
					console.log(result);
					$.each(result, function(index, value) {
						console.log("SprintID:" + index + " : Sprint Name:"+value.name);
					}); 
				},
				error : function(xhr, status, exception) {
					console.log(xhr, status, exception);
				},
				done : function(e) {
					console.log("DONE");
				}
			});
		}); */
	});
</script>