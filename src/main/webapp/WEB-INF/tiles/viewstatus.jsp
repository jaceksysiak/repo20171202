<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="jwp" %>

<c:url var="url" value="/viewstatus" />

<div class="row">
  <div class="col-md-8 col-md-offset-2">
  
       <jwp:pagination url="${url}"  page="${page}" size="3"/>
	
<c:forEach var="statusUpdate" items="${page.content}">

        <c:url var="editLink" value="/editstatus?id=${statusUpdate.id}" />
        <c:url var="deleteLink" value="/deletestatus?id=${statusUpdate.id}" />

		<div class="panel panel-default">
		
			<div class="panel-heading">
				<div class="panel-title">Status update added on: <fmt:formatDate pattern="EEEE d MMMM y 'at' H:mm:ss" value="${statusUpdate.added}" /></div>
			</div>
			
			<div class="panel-body">
			
				 <div>${statusUpdate.text}</div> 
				 
				 <div class="edit-links pull-right">
				   <a href="${editLink}">edit</a> | <a onclick="return confirm('Really delete this status update ?');" href="${deleteLink}">delete</a>
				 </div>
			
			</div>
		
		
		</div>

</c:forEach>

 </div>
</div>










































