<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<div class="content-panel">
	<fieldset class="form-border">
		<legend class="form-border">Create Sprint</legend>
		<form:form class="form-horizontal" role="form" commandName="sprint"
			action="" method="post">
			<div class="form-group">
				<label class="control-label col-sm-4" for="firstname">Name</label>
				<div class="col-sm-6">
					<form:input path="name" cssClass="form-control"
						htmlEscape="true" placeholder="Enter sprint name" required="true" />
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
						class="btn btn-default btn-lg btn-block btn-primary" value="Save">
				</div>
			</div>
		</form:form>
	</fieldset>
</div>