<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<div class="content-panel">
	<fieldset class="form-border">
		<legend class="form-border">Create User</legend>
		<form:form class="form-horizontal" role="form" commandName="user"
			action="" method="post">
			<div class="form-group">
				<label class="control-label col-sm-4" for="firstname">First
					Name:</label>
				<div class="col-sm-6">
					<form:input path="firstName" cssClass="form-control"
						htmlEscape="true" placeholder="Enter first name" required="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="lastname">Last
					Name:</label>
				<div class="col-sm-6">
					<form:input path="lastName" cssClass="form-control"
						htmlEscape="true" placeholder="Enter last name" required="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="email">Email:</label>
				<div class="col-sm-6">
					<form:input type="email" path="email" cssClass="form-control"
						htmlEscape="true" placeholder="Enter email" required="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="password">Password:</label>
				<div class="col-sm-6">
					<form:input type="password" path="password" cssClass="form-control"
						htmlEscape="true" placeholder="Enter password" required="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="confirmpassword">Confirm
					Password:</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" id="confirmpassword"
						name="confirmpassword" placeholder="Re-enter password" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="role">Role:</label>
				<div class="col-sm-6">
					<form:select path="role.id" items="${roles}" itemValue="id"
						itemLabel="name" cssClass="form-control" />
				</div>
			</div>
			<!-- Check for validation -->
			<c:if test="${errors != null}">
				<div class="alert alert-danger col-sm-offset-4 col-sm-6" role="alert">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<form:errors path="*" />
				</div>
			</c:if>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-6">
					<input type="submit"
						class="btn btn-default btn-lg btn-block btn-success" value="Save">
				</div>
			</div>
		</form:form>
	</fieldset>
</div>