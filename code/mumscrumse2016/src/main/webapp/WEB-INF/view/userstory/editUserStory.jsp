<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<div class="content-panel">
	<div>
		<h1>Backlogs</h1>
	</div>

	<fieldset class="form-border">
		<legend class="form-border">Edit User Story</legend>
		<hr>
		<div>
			<form:form class="form-horizontal" role="form" commandName="userstory" action="" method="post">
				<div class="form-group">
					<label class="control-label col-sm-2" for="project">Project:</label>
					<div class="col-sm-8">
						<form:select path="project.id" items="${projects}" itemValue="id" id="projectFilter"
							itemLabel="name" cssClass="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="sprint">Sprint:</label>
					<div class="col-sm-8">
						<form:select path="sprint.id" items="${sprints}" itemValue="id" id="sprintFilter"
							itemLabel="name" cssClass="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="user">Users (email):</label>
					<div class="col-sm-8">
						<form:select path="user.id" items="${users}" itemValue="id" id="userFilter"
							itemLabel="email" cssClass="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="name">User Story Title:</label>
					<div class="col-sm-8">
						<form:input path="name" cssClass="form-control"
							htmlEscape="true" placeholder="Enter title" required="true" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="name">Estimated Time (hours):</label>
					<div class="col-sm-8">
						<form:input path="estimatedTime" cssClass="form-control"
							htmlEscape="true" placeholder="Enter Days"/>
					</div>
				</div>	
				<div class="form-group">
					<label class="control-label col-sm-2" for="description">Description:</label>
					<div class="col-sm-8">
						<form:textarea path="description" cssClass="form-control" rows="6" style="resize:none"
							htmlEscape="true" placeholder="Enter description" required="true" />
					</div>
				</div>
				<input id="projectId" name="projectId" type="hidden" value="" />
				<form:input id="completedTime" path="completedTime" type="hidden" value="" />
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

<script type="text/javascript" charset="utf-8">
    $(document).ready(function() {
    	UpdateSprint();
       $('#projectFilter').change(function()
        {   
    	   UpdateSprint();
        });
       
       function UpdateSprint()
       {
    	   $("#projectId").val($('#projectFilter').val());
			var projectId = $("#projectId").val();
			console.log("Pid: "+projectId);
			var data = {
				"projectId" : projectId
			};
			var url = "<c:url value='/sprint/'/>";
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : url + projectId,
				data : JSON.stringify(data),
				success : function(data) {
					var html = '';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].id + '">'
								+ data[i].name + '</option>';
					}
					html += '</option>';
	 
					$('#sprintFilter').html(html);
				},
				error : function(xhr, status, exception) {
					console.log(xhr, status, exception);
				},
				done : function(e) {
					console.log("DONE");
				}
			});
       }
    });
</script>
