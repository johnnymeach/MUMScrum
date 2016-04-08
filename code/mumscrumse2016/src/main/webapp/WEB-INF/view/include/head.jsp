	<%@ include file="../include/taglib.jsp" %>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<c:choose>
	  <c:when test="${sessionScope.desktopmode=='true'}">
	    <meta name="viewport" content="width=1024">
	  </c:when>	  
	  <c:otherwise>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	  </c:otherwise>
	</c:choose>
	
	<link href="<c:url value="/resources/bootstrap-3.3.6/css/bootstrap.min.css"/>" rel="stylesheet">
	<script src="<c:url value="/resources/js/jquery-1.11.3.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/bootstrap-3.3.6/js/bootstrap.min.js"/>" type="text/javascript"></script>  
	
		
	 <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">    
    
    <!-- ChartJS -->
	<script src="<c:url value="/resources/chartjs/Chart.js"/>" type="text/javascript"></script>
    
    <!-- jquery datatables --> 
 	<link href="<c:url value="/resources/jquery_datatables/css/jquery.dataTables.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/jquery_datatables/css/dataTables.colVis.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/TableTools/css/dataTables.tableTools.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/jquery_datatables/css/dataTables.bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/jquery_datatables/css/responsive.dataTables.min.css" />" rel="stylesheet">              
   	<script type="text/javascript" src="<c:url value="/resources/jquery_datatables/js/jquery.dataTables.js"/>" charset="UTF-8"></script>
   	<script type="text/javascript" src="<c:url value="/resources/jquery_datatables/js/dataTables.colVis.js"/>" charset="UTF-8"></script>
    <script type="text/javascript" src="<c:url value="/resources/TableTools/js/dataTables.tableTools.js"/>" charset="UTF-8"></script>
    <script type="text/javascript" src="<c:url value="/resources/jquery_datatables/js/dataTables.bootstrap.js"/>" charset="UTF-8"></script>                                            
    <script type="text/javascript" src="<c:url value="/resources/jquery_datatables/js/dataTables.responsive.min.js"/>" charset="UTF-8"></script>
    
	
	

  	

	