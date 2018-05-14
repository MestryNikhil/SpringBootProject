<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ include file="/WEB-INF/views/navadmin.jsp" %>
<c:choose>
	<c:when test="${mode =='NewLib' || mode =='EditLib'}">
<form action="saveLibrarian" method="post" style="width:600px">
	
      <input type="hidden" class="form-control" id="id" name="id" value="${Lib.id}">
    
	<div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" name="name" value="${Lib.name }">
    </div>
    <div class="form-group">
      <label for="mobile">Mobile:</label>
      <input type="text" class="form-control" id="mobile" value="${Lib.mobile }" name="mobile">
    </div>
	<div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" value="${Lib.email }" name="email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="password" value="${Lib.password }" name="password">
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
</c:when>


<c:when test="${mode =='ViewLib'}"> 
	<table class="table table-striped table-hover table-bordered">
			    <thead>
			      <tr>
			        <th>Id</th>
			        <th>Librarian Name</th>
			        <th>Mobile</th>
			        <th>Email</th>
			        <th>Edit</th>
			        <th>Delete</th>
			      </tr>
			    </thead>
				    <tbody>
				    	<c:forEach items="${Libs}" var="lib">
				      		<tr>
				      			<td>${lib.id}</td>
				      			<td>${lib.name}</td>
				      			<td>${lib.mobile}</td>
				      			<td>${lib.email}</td>
				      		 	<td><a href="editLibrarian?id=${lib.id}" class="btn btn-info btn-sm"> <span class="glyphicon glyphicon-pencil"></span> </a></td>
				      			<td><a href="deleteLibrarian?id=${lib.id}" class="btn btn-info btn-sm"> <span class="glyphicon glyphicon-trash"></span> </a></td> 
				      	 	
				      		</tr>	
				      	</c:forEach>		
				    </tbody>
	  		</table>
</c:when>
</c:choose>		
		
<%@ include file="/WEB-INF/views/footer.jsp"%>