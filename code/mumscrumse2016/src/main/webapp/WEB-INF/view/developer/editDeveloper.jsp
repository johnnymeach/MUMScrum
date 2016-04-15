<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<div class="content-panel">
	<div>
		<h1>My User Story</h1>
	</div>

	<fieldset class="form-border">
		<legend class="form-border">Add Time Log</legend>
		<hr>
		<div>
			<form:form class="form-horizontal" role="form" commandName="timelog" action="" method="post">
			
				<div class="form-group">
					<label class="control-label col-sm-2" for="name">User Story Title:</label>
					<div class="col-sm-8">
						<form:input path="userstory.name" cssClass="form-control" readonly="true"
							htmlEscape="true" placeholder="Enter title"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="name">Estimated Time (hours):</label>
					<div class="col-sm-8">
						<form:input path="userstory.estimatedTime" cssClass="form-control" readonly="true"
							htmlEscape="true" placeholder="Enter title" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="name">Completed Time (hours):</label>
					<div class="col-sm-8">
						 <form:input path="userstory.completedTime" cssClass="form-control" readonly="true"
							htmlEscape="true" placeholder="0" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="name">Today Completed Time (hours):</label>
					<div class="col-sm-8">
						<form:input path="duration" cssClass="form-control"
							htmlEscape="true" placeholder="Enter today's time log (override if already entered)" required="true" />
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