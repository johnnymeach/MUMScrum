<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<div class="content-panel">
<div class="col-sm-2">
	Sprint List:<select id="sprint" name="sprint" class="form-control">
					<c:forEach items="${sprints}" var="u">
							<option value="${u.id}"
								${u.id == selectedId ? 'selected="selected"' : ''}>${u.name}
							</option>
						</c:forEach>
					</select>
					</div>
<div class="col-sm-10">
 <div id="container"></div>
    			</div>

</div>

<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>

<script type="text/javascript">
$(function () {
	
    $('#container').highcharts({
    	colors :['#0066ff', '#f7a35c'],
        title: {
            text: 'Burn Down Chart',
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
                text: 'Effort'
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

<script type="text/javascript">
	$(document).ready(function() {
		$("#sprint").on("change", function(){
		    var opt = $(this).val();
		    location.href = "<c:url value="/burndownchart"/>/" + opt;
		  }); 
	});
</script>