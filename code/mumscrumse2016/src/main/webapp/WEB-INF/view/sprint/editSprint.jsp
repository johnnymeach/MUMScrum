<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<div class="content-panel">
	<fieldset class="form-border">
		<legend class="form-border">Edit User</legend>
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
				<label class="control-label col-sm-4" for="role">Role:</label>
				<div class="col-sm-6">
					<form:select path="role.id" items="${roles}" itemValue="id"
						itemLabel="name" cssClass="form-control" />
				</div>
			</div>
			<!-- Check for validation -->
			<c:if test="${errors != null}">
				<div class="alert alert-danger col-sm-offset-4 col-sm-6"
					role="alert">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<form:errors path="*" />
				</div>
			</c:if>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-6">
					<div class="col-sm-5">
						<!-- <button class="col-sm-3 btn btn-default btn-lg btn-block btn-primary">Reset Password</button> -->
						<a href="#" data-target="#resetpassword" data-toggle="modal"
							class="btn btn-lg btn-primary">Reset Password</a>
					</div>
					<div class="col-sm-offset-3 col-sm-4">
						<input type="submit"
							class="btn btn-default btn-lg btn-block btn-primary" value="Save">
					</div>
				</div>
			</div>
		</form:form>
	</fieldset>

	<!-- Modal For Reset Password -->
	<div class="modal fade" id="resetpassword" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Reset Password</h4>
				</div>
				<div class="modal-body">
					<form id="formResetPwd" method="post"
						action="<spring:url value="/resetpassword" />" class="form-horizontal">
						<div class="form-group">
							<label class="col-md-4 control-label">Enter New Password</label>
							<div class="col-md-8">
								<input type="password" class="form-control" id="newpwd"
									name="newpassword" placeholder="New Password" autocomplete="off" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Re-enter New
								Password</label>
							<div class="col-md-8">
								<input type="password" class="form-control" id="confirmnewpwd"
									name="confirmnewpassword" placeholder="Re-enter New Password"
									autocomplete="off" />
							</div>
						</div>
						<input id="userId" name="userId" type="hidden" value="" /> <input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<div class="form-group">
							<div class="col-md-offset-4 col-md-4">
								<button type="submit" id="btnNew" class="btn btn-primary ">Save</button>
								<button class="btn " data-dismiss="modal" aria-hidden="true">Close</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	$("#userId").val('${id}');
	
	$.validator.addMethod(
        "regex",
        function(value, element, regexp) {
            var re = new RegExp(regexp);
            return this.optional(element) || re.test(value);
        },
        "Please check your input."
	);
	
	//Validate password
	var validate=$('#formResetPwd').validate({
		errorClass: "text-danger",
		rules: {			    
			newpassword: {
			      required: true,
			      regex: "((?=.*\\d).{5,20})" ,				      
			},
			confirmnewpassword: {
			      required: true,
			      equalTo: "#newpwd"
			}
		},
		messages: {				
			newpassword:{
				required:"New password is required!",
				regex:"Password must be at least 5 characters",					
			},
			confirmnewpassword:"Confirm password again!"
		},			
		highlight:function(element){				
			$(element).closest('.form-group').removeClass('has-success').addClass('has-error');				
			
		},
		unhighlight:function(element){
			$(element).closest('.form-group').removeClass('has-error').addClass('has-success');				
		}							
	});
});

</script>