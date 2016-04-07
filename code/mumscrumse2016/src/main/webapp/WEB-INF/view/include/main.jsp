<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<%              
  response.setHeader("pragma", "no-cache");              
  response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");             
  response.setHeader("Expires", "0");  
%> 
<title><tiles:getAsString name="title" /></title>
<tilesx:useAttribute name="current" scope="request"/>
<tilesx:useAttribute name="tab" scope="request"/>
<tiles:insertAttribute name="head" />
</head>
<body>
<div id="wrapper">
    <!-- Page Content -->
    <div id="page-content-wrapper">
    	<div id="header-wrapper">
    		<tiles:insertAttribute name="header" />
    	</div>
    	<div id="content-wrapper">
	        <div class="container-fluid">
	            <div class="row">
	                <div class="col-lg-12">
	                	<tiles:insertAttribute name="body" />      
	                </div>
	            </div>
	        </div>
        </div>
    </div>
    <!-- /#page-content-wrapper -->
</div>
<!-- /#wrapper -->
<div id="pushit-overlay" style="${sessionScope.desktopmode=='true'?'z-index=-1;position:relative':''}"></div>
<div class="modal fade" data-backdrop="false" id="message-box">
   <div class="modal-dialog"> 
     <div class="modal-content">
       <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
         <h4 id="message-box-title" class="modal-title"></h4>
       </div>
       <div id="message-box-body" class="modal-body"></div>
       <div class="modal-footer">
         <a id="message-box-url" class="btn btn-primary"></a>
         <button id="message-box-btnOK" type="button" class="btn btn-default" data-dismiss="modal">OK</button>
       </div>                        
     </div>
   </div>                    
</div>

</body>
</html>