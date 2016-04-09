<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<div class="content-panel">
	<form class="form-horizontal" role="form" name="createuserform" action="" method="post">
		<div class="form-group">
			<label class="control-label col-sm-2" for="firstname">First Name:</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="firstname" name="firstname"
					placeholder="Enter first name">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="lastname">Last Name:</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="lastname" name="lastname"
					placeholder="Enter last name">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">Email:</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="email" name="email"
					placeholder="Enter email" required>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="password">Password:</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="password" name="password"
					placeholder="Enter password" required>
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
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-default btn-lg btn-block btn-success" value="Save">
			</div>
		</div>
	</form>
</div>