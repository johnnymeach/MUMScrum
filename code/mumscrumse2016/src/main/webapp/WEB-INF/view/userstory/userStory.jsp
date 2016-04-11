<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<div class="content-panel">
	<div>
		<h1>Backlogs</h1>
	</div>

	<div style="height: 200px; overflow:auto;">
		<table id="userStoryListTable"
			class="table table-striped table-advance table-hover table-bordered table-fixed">
			<colgroup>
		       <col span="1" style="width: 5%;">
		       <col span="1" style="width: 25%;">
		       <col span="1" style="width: 70%;">
    		</colgroup>
			<thead>
				<tr>
					<th>No</th>
					<th>User story Title</th>
					<th>Description</th>
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
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

		<fieldset class="form-border">
						<legend class="form-border">Create User Story</legend>
		<hr>
	<div>
		<form:form class="form-horizontal" role="form" commandName="userstory" action="" method="post">
		
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">User Story Title:</label>
				<div class="col-sm-8">
					<form:input path="name" cssClass="form-control"
						htmlEscape="true" placeholder="Enter title" required="true" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="description">Description:</label>
				<div class="col-sm-8">
					<form:textarea path="description" cssClass="form-control"
						htmlEscape="true" placeholder="Enter description" required="true" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-8">
					<input type="submit"
						class="btn btn-default btn-lg btn-block btn-success" value="Save">
				</div>
			</div>
		</form:form>
	</div>
	</fieldset>
</div>