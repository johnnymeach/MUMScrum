<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<div class="content-panel">
	<div>
		<h1>Backlogs</h1>
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