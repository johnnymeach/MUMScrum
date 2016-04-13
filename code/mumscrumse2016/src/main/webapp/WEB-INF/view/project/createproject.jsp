<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<div class="content-panel">
	<fieldset class="form-border">
		<legend class="form-border">Create Project</legend>
	<form:form class="form-horizontal" role="form" commandName="project"
			action="" method="post">
		<div class="form-group">
				<label class="control-label col-sm-4" for="name">First
					Name:</label>
				<div class="col-sm-6">
					<form:input path="name" cssClass="form-control"
						htmlEscape="true" placeholder="Enter project name" required="true" />
				</div>
		</div>
			
		<div class="form-group">
			<label class="control-label col-sm-2" for="scrummaster">Scrum Master:</label>
			<div class="col-sm-10">
				
				<form:select path="user.id" items="${users}" itemValue="id"
						itemLabel="name" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="description">Project Description:</label>
			<div class="col-sm-10">
			<form:textarea path="description" rows="5" cols="80" required="true" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-default btn-lg btn-block btn-success" value="Submit">
			</div>
		</div>
	</form:form>
	</fieldset>
</div>