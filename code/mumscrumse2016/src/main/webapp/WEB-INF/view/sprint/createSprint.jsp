<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<div class="content-panel">
	<fieldset class="form-border">
		<legend class="form-border">Create Sprint</legend>
		<form:form class="form-horizontal" role="form" commandName="sprint"
			action="" method="post">
			<div class="form-group">
				<label class="control-label col-sm-4" for="project">Project:</label>
				<div class="col-sm-6">
					<form:select path="project.id" items="${projects}" itemValue="id"
						itemLabel="name" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-6">
					<form:input path="name" cssClass="form-control"
						htmlEscape="true" placeholder="Enter sprint name" required="true" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-4" for="startDate">Sprint Start Date</label>
				<div class="col-sm-6">
					<form:input path="startDate" cssClass="form-control" id="startDate"
						htmlEscape="true" placeholder="mm/dd/yyyy" required="true" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-4" for="endDate">Sprint End Date</label>
				<div class="col-sm-6">
					<form:input path="endDate" cssClass="form-control" id="endDate"
						htmlEscape="true" placeholder="mm/dd/yyyy" required="true" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-4" for="name">Sprint Description</label>
				<div class="col-sm-6">
					<form:textarea path="description" cssClass="form-control" rows="6"
						htmlEscape="true" placeholder="Enter sprint description" required="true" />
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
<script type="text/javascript">
$(document).ready(function(){
	/* $("#startDate").datepicker();
	$("#endDate").datepicker(); */
	/* $("#endDate").keydown(false);
	$("#startDate").keydown(false); */
	
	//Date validation for the startDate and endDate, endDate >= startDate
	var nowTemp = new Date();
	var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);
	 
	var startDate = $('#startDate').datepicker()
	.on('changeDate', function(ev) {
	  if (ev.date.valueOf() > endDate.date.valueOf()) {
	    var newDate = new Date(ev.date)
	    newDate.setDate(newDate.getDate() + 1);
	    endDate.setValue(newDate);
	  }
	  startDate.hide();
	  $('#endDate')[0].focus();
	}).data('datepicker');
	
	var endDate = $('#endDate').datepicker({
	  onRender: function(date) {
	    return date.valueOf() < startDate.date.valueOf() ? 'disabled' : '';
	  }
	}).on('changeDate', function(ev) {
		endDate.hide();
	}).data('datepicker');
	
});
</script>
