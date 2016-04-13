<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<div class="content-panel">
	Create Project<hr>
	<form id="formproject" class="form-horizontal" role="form" name="createproject" action="" method="post">
		<div class="form-group">
			<label class="control-label col-sm-2" for="projectname">Project Name:</label>
			<div class="col-sm-10">
				<input class="form-control" id="projectname" name="projectname"
					placeholder="Enter first name">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="scrummaster">Scrum Master:</label>
			<div class="col-sm-10">
				<select class="form-control">
					<c:forEach items="${users}" var="p">
					<option value="${p.id}">${p.email}</option>
					<br />
				</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="lastname">Project Description:</label>
			<div class="col-sm-10">
			<textarea form="formproject" rows="5" cols="80"></textarea>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-default btn-lg btn-block btn-success" value="Submit">
			</div>
		</div>
	</form>
</div>