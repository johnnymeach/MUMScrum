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
<div id="graph">
<canvas id="myChart" width="800" height="400"></canvas>
</div>
</div>
<script type="text/javascript">
var ctx = document.getElementById("myChart").getContext("2d");
var data = {
		labels : ${timelabellist},
		datasets : [
			{
				fillColor : "rgba(151,187,205,0.5)",
				strokeColor : "rgba(151,187,205,1)",
				data : ${timelist}
			}
		]
	}
new Chart(ctx).Bar(data);
</script>