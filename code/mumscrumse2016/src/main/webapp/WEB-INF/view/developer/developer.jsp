<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<div class="content-panel">
	<div>
		<h1>My User Stories</h1>
	</div>
	<form:form class="form-horizontal" role="form" commandName="userstory"
		action="" method="post" id="formProjectList">
		<div class="form-group">
			<label class="col-sm-offset-6 control-label col-sm-2" for="project">Filter By Project:</label>
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
		       <col span="1" style="width: 25%;">
		       <col span="1" style="width: 15%;">
		       <col span="1" style="width: 10%;">
		       <col span="1" style="width: 10%;">
		       <col span="1" style="width: 5%;">
		       <col span="1" style="width: 5%;">
		       <col span="1" style="width: 5%;">
		       <col span="1" style="width: 10%;">
    		</colgroup>
			<thead>
				<tr>
					<th>ID</th>
					<th>User story</th>
					<th>Project</th>
					<th>Sprint</th>
					<th>Estimated Time (hours)</th>
					<th>Completed Time (hours)</th>
					<th>Status</th>
					<th>Add Time Log</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userstories}" var="userstory">
					<tr class="${userstory.project.name}">
						<td><c:out value="${userstory.id}" /></td>				
						<td><c:out value="${userstory.name}" /></td>
						<td><c:out value="${userstory.project.name}" /></td>
						<td><c:out value="${userstory.sprint.name}" /></td>
						<td><c:out value="" />${userstory.estimatedTime}</td>
						<td><c:out value="" />${userstory.completedTime}</td>
						<td><c:out value="" /></td>
						<td><a href="<c:url value="/developerUS/${userstory.id}/edit"/>"
						class="btn btn-primary btn-xs"><i class="fa fa-plus"></i></a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
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