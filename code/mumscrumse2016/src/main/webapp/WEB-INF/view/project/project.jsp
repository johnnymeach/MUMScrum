<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<div class="content-panel">
	<fieldset class="form-border">
		<legend class="form-border">Project</legend>
		<form:form class="form-horizontal" role="form" commandName="project"
			action="" method="post">
			<div class="form-group">
				<label class="control-label col-sm-4" for="name"> Name:</label>
				<div class="col-sm-6">
					<form:input path="name" cssClass="form-control" htmlEscape="true"
						placeholder="Enter project name" required="true" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-4" for="scrummaster">Scrum
					Master:</label>
				<div class="col-sm-6">
					<select id="user.id" name="user.id" class="form-control"> ${project.user == NULL  ? '<option >None-Scrum Master</option>' : ''}
						<c:forEach items="${users}" var="u">
							<option value="${u.id}"
								${u.id == project.user.id ? 'selected="selected"' : ''}>${u.firstName}
								(${u.email})</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="description">Project
					Description:</label>
				<div class="col-sm-6">
					<form:textarea path="description" rows="5" cssClass="form-control"
						required="true" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-6">
					<div class="col-sm-offset-8 col-sm-4">
						<input type="submit"
							class="btn btn-default btn-lg btn-block btn-primary" value="Save">
					</div>
				</div>
			</div>
		</form:form>
	</fieldset>
</div>