<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<div class="content-panel">
	<h2>Burndown Chart</h2>
	
	<div class="form-group">
		<form class="form-horizontal">
			<label class="col-sm-offset-6 control-label col-sm-2" for="sprint">Filter By Sprint:</label>
			<div class="col-sm-4">
				<select id="sprint" name="sprint" class="form-control">
					<c:forEach items="${sprints}" var="u">
						<option value="${u.id}"
							${u.id == selectedId ? 'selected="selected"' : ''}>${u.name}
						</option>
					</c:forEach>
				</select>
			</div>
		</form>
	</div>
	<span class="devider">&nbsp;</span>
	<div class="col-sm-12">
		<div id="container"></div>
	</div>

</div>

<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#sprint").on("change", function(){
		    var opt = $(this).val();
		    location.href = "<c:url value="/burndownchart"/>/" + opt;
		  }); 
		
		var sprintName = $("#sprint :selected").text();
		console.log("Selected Sprint: "+sprintName);
		
		// Burndown chart
		
		$('#container').highcharts({
	    	colors :['#0066ff', '#f7a35c'],
	        title: {
	            text: sprintName + ' -- Burndown Chart',
	            x: -20 //center
	        },
	        subtitle: {
	            text: '${SprintName}',
	            x: -20
	        },
	        xAxis: {
	            categories: ${timelabellist},
	        },
	        yAxis: {
	            title: {
	                text: 'Effort (hours)'
	            },
	            plotLines: [{
	                value: 0,
	                width: 1,
	                color: '#808080'
	            }]
	        },
	        tooltip: {
	            valueSuffix: 'hour(s)'
	        },
	        legend: {
	            layout: 'vertical',
	            align: 'right',
	            verticalAlign: 'middle',
	            borderWidth: 0
	        },
	        
	        series: [ {
	            name: 'Original Estimation',
	            data: ${expectedtimelist}
	        }, {
	            name: 'Remaining Time',
	            data: ${timelist}
	        }]
	    }); 
		
		
	});
</script>