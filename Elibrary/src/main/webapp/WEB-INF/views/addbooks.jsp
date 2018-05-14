<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ include file="/WEB-INF/views/navlibrarian.jsp" %>
<c:choose>
	<c:when test="${mode =='NewBook' || mode =='EditBook'}">
<form action="${contextPath}/librarian/saveBook" method="post" style="width:600px">
	
      <input type="hidden" class="form-control" id="bid" name="bid" value="${Book.bid}">
    <div class="form-group">
      <label for="bcode">Book Code:</label>
      <input type="text" class="form-control" id="bcode" value="${Book.bcode}" name="bcode">
    </div>
	<div class="form-group">
      <label for="name">Book Name:</label>
      <input type="text" class="form-control" id="bname" name="bname" value="${Book.bname }">
    </div>
    <div class="form-group">
      <label for="author">Author:</label>
      <input type="text" class="form-control" id="author" value="${Book.author }" name="author">
    </div>
	<div class="form-group">
      <label for="publisher">Publisher:</label>
      <input type="text" class="form-control" id="publisher" value="${Book.publisher }" name="publisher">
    </div>
    <div class="form-group">
      <label for="quantity">Quantity:</label>
      <input type="text" class="form-control" id="quantity" value="${Book.quantity }" name="quantity">
    </div>
    <div class="form-group">
      <label for="issued">Issued:</label>
      <input type="text" class="form-control" id="issued" value="${Book.issued }" name="issued">
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
</c:when>


<c:when test="${mode =='ViewBook'}"> 
	<table class="table table-striped table-hover table-bordered">
			    <thead>
			      <tr>
			        <th>Book Id</th>
			        <th>Book Code</th>
			        <th>Book Name</th>
			        <th>Author</th>
			        <th>Publisher</th>
			        <th>Quantity</th>
			        <th>Issued</th>
			        
			      </tr>
			    </thead>
				    <tbody>
				    	<c:forEach items="${Books}" var="book">
				      		<tr>
				      			<td>${book.bid}</td>
				      			<td>${book.bcode}</td>
				      			<td>${book.bname}</td>
				      			<td>${book.author}</td>
				      			<td>${book.publisher}</td>
				      			<td>${book.quantity}</td>
				      			<td>${book.issued}</td>
				      	
				      		 	<td><a href="editBook?id=${book.bid}" class="btn btn-info btn-sm"> <span class="glyphicon glyphicon-pencil"></span> </a></td>
				      			<td><a href="deleteBook?id=${book.bid}" class="btn btn-info btn-sm"> <span class="glyphicon glyphicon-trash"></span> </a></td> 
				      	 	
				      		</tr>	
				      	</c:forEach>		
				    </tbody>
	  		</table>
</c:when>
</c:choose>		
		
<%@ include file="/WEB-INF/views/footer.jsp"%>