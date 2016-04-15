<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<div class="content-panel">
	<div>
		<h1>My User Stories</h1>
	</div>

	<table id="userStoryListTable"
			class="table table-striped table-advance table-hover table-bordered table-fixed">
			<colgroup>
		       <col span="1" style="width: 5%;">
		       <col span="1" style="width: 25%;">
		       <col span="1" style="width: 10%;">
		       <col span="1" style="width: 10%;">
		       <col span="1" style="width: 10%;">
		       <col span="1" style="width: 10%;">
		       <col span="1" style="width: 10%;">
		       <col span="1" style="width: 10%;">
		       <col span="1" style="width: 10%;">
    		</colgroup>
			<thead>
				<tr>
					<th>No</th>
					<th>User story</th>
					<th>Project</th>
					<th>Sprint</th>
					<th>Estimated Time (hours)</th>
					<th>Completed Time (hours)</th>
					<th>Status</th>
					<th>Add Time Log</th>
				</tr>
			</thead>
			<c:set var="id" value="${1}"/>
			<tbody>
				<c:forEach items="${userstories}" var="userstory">
					<tr>
						<td>${id}</td>
						<c:set var="id" value="${id+1}"/>					
						<td><c:out value="${userstory.name}" /></td>
						<td><c:out value="${userstory.project.name}" /></td>
						<td><c:out value="${userstory.sprint.name}" /></td>
						<td><c:out value="" />${userstory.estimatedTime}</td>
						<td><c:out value="" />${userstory.completedTime}</td>
						<td><c:out value="" /></td>
						<td><a href="<c:url value="/developerUS/${userstory.id}/edit"/>"
						class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>