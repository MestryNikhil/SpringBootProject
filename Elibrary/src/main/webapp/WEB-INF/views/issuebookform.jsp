<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/commons/header.jsp" %>
<%@ include file="/WEB-INF/views/commons/navlibrarian.jsp" %>


<c:choose> 
<c:when test="${mode == 'IssueBook' }">
<form action="issueBook" method="post" style="width:600px">
    
	<div class="form-group">
      <label for="bid">Book ID:</label>
      <input type="text" class="form-control" id="bid" name="bid">
    </div>
   
	<div class="form-group">
      <label for="sid">Student ID:</label>
      <input type="text" class="form-control" id="sid" name="sid">
    </div>
    <div class="form-group">
      <label for="issueDate">Issue Date:</label>
      <input type="date" class="form-control" id="issueDate" name="issueDate">
    </div>
    <div class="form-group">
      <label for="returnDate">Return Date:</label>
      <input type="date" class="form-control" id="returnDate" name="returnDate">
    </div>
    <div class="form-group">
      <label for="status">Status:</label>
      <input type="text" class="form-control" id="status" name="status">
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
</c:when>
<c:when test="${mode == 'ViewIssuedBook' }">
<table class="table table-striped table-hover table-bordered">
			    <thead>
			      <tr>
			      	<th>Book Id:</th>
			        <th>Student Id:</th>
			        <th>Issue Date:</th>
			        <th>Return Date:</th>

			        <th>Status:</th>
			        <th>Return?</th>
			      </tr>
			    </thead>
				    <tbody>
				    	<c:forEach items="${Issues}" var="issue">
				      		<tr>
				      			<td>${issue.bid}</td>
				      			<td>${issue.sid}</td>
				      			<td>${issue.issueDate}</td>
				      			<td>${issue.returnDate}</td>
				      			<td>${issue.status}</td>
				      			<td><a href="returnBook?id=${issue.id }&bid=${issue.bid}" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-repeat"></span></a>
				      			
				      		 
				      	 	
				      		</tr>	
				      	</c:forEach>		
				    </tbody>
	  		</table>
</c:when>
<c:when test="${mode == 'BookIssued' }">
<h1> Book Issued Successfully!!</h1>

</c:when>
<c:when test="${mode == 'OutOfStock' }">

<h1> Book is out of stock</h1>
</c:when>
</c:choose>
<%@ include file="/WEB-INF/views/commons/footer.jsp"%>