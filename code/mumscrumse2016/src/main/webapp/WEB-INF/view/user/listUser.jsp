<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<div class="content-panel">
	<table id="userListTable"
		class="table table-striped table-advance table-hover table-bordered table-fixed">
		<thead>
			<tr>
				<th>No</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Role</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:set var="id" value="${1}"/>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${id}</td>
					<c:set var="id" value="${id+1}"/>					
					<td><c:out value="${user.firstName}" /></td>
					<td><c:out value="${user.lastName}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><c:out value="${user.role.name}" /></td>
					<td>
						<div class="buttonAction">
							<a href="<c:url value="/user/${user.id}/edit"/>" class="btn btn-primary btn-sm"><i class="fa fa-pencil"></i></a>
						</div>
						<div>
							<button data-target="#deleteuser" data-toggle="modal" class="btn btn-primary btn-sm" name="user" value="${user.id}">
							<i class="fa fa-remove text-danger"></i>
							</button>
						</div>
						</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<span class="navbar-btn"> <a
		href="<c:url value="/createuser"/>"
		class="glyphicon glyphicon-plus btn btn-primary"> Add User</a>
	</span>
	
	<!-- Modal For Delete User -->
	<div class="modal fade" id="deleteuser" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Do you want to delete this user?</h4>
				</div>
				<div class="modal-body">
					<form id="formDeleteUser" method="post"
						action="<spring:url value="/deleteuser" />" class="form-horizontal">
						
						<input id="userId" name="userId" type="hidden" value="" /> <input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<div class="form-group">
							<div class="col-md-offset-4 col-md-4">
								<button type="submit" id="btnDelete" class="btn btn-primary ">Yes</button>
								<button class="btn " data-dismiss="modal" aria-hidden="true">No</button>
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
		$("button[name = 'user']").click(function(){
			//console.log("Value of button : "+$(this).val());
			$("#userId").val($(this).val());
			console.log("Value of button : "+$("#userId").val());
			
		});
	});
</script>