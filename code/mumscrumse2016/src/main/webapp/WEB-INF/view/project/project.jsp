<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<div class="content-panel">
<div class="form-group">
			<label class="control-label col-sm-2" for="pwd">Projects:</label>
			<div class="col-sm-10">
			<select class="form-control">
				<c:forEach items="${projects}" var="p">
				<option value="${p.id}" selected>${p.name}</option>
				<br />
				</c:forEach>
				</select>
			</div>
		</div>
	Project<hr>
	<form class="form-horizontal" role="form" name="project" action="" method="post">
		<div class="form-group">
			<label class="control-label col-sm-2" for="firstname">Project Name:</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="firstname" name="firstname"
					placeholder="Enter first name">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="pwd">Role:</label>
			<div class="col-sm-10">
				<select class="form-control">
					<option value="1" selected>Developer</option>
					<option value="2">Scrum Master</option>
					<option value="3">System Admin</option>
					<option value="4">Product Owner</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="lastname">Project Description:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="lastname" name="lastname"
					placeholder="Enter last name">
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-default btn-lg btn-block btn-success" value="Submit">
			</div>
		</div>
	</form>
</div>