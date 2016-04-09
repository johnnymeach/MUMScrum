<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<div class="content-panel">
	<fieldset class="form-border">
		<legend class="form-border">Create User</legend>
		<form class="form-horizontal" role="form" name="createuserform"
			action="" method="post">
			<div class="form-group">
				<label class="control-label col-sm-4" for="firstname">First
					Name:</label>
				<div class="col-sm-6">
					<input type="email" class="form-control" id="firstname"
						name="firstname" placeholder="Enter first name">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="lastname">Last
					Name:</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" id="lastname"
						name="lastname" placeholder="Enter last name">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="email">Email:</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" id="email" name="email"
						placeholder="Enter email" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="password">Password:</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" id="password"
						name="password" placeholder="Enter password" required>
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
					<select class="form-control" name="role">
						<option value="1" selected>Developer</option>
						<option value="2">Scrum Master</option>
						<option value="3">System Admin</option>
						<option value="4">Product Owner</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-6">
					<input type="submit"
						class="btn btn-default btn-lg btn-block btn-success" value="Save">
				</div>
			</div>
		</form>
	</fieldset>
</div>