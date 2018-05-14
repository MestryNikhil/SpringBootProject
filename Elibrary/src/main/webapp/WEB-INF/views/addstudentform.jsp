<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ include file="/WEB-INF/views/navlibrarian.jsp" %>
<c:choose> 
<c:when test="${mode == 'NewStudent' || mode == 'EditStudent'}">
<form action="saveStudent" method="post" style="width:600px">
    

    <input type="hidden" class="form-control" value="${Stud.sid }" id="sid" name="sid" >
    
    <div class="form-group">
      <label for="sname">Student Name:</label>
      <input type="text" class="form-control" value="${Stud.sname }" id="sname"  name="sname">
    </div>
    <div class="form-group">
      <label for="smobile">Mobile:</label>
      <input type="text" class="form-control" value="${Stud.smobile }" id="smobile"  name="smobile">
    </div>
   
    <div>
    	<label for="department">Department:</label>
    </div>
    
	<select name="department" >
		<option>EXTC</option>
		<option>MECHANICAL</option>
		<option>CSE</option>
		<option>IT</option>
		<option>CIVIL</option>
		<option>ISTRUMENTATION</option>
	</select>
    
     <div>
    	<label for="division">Division:</label>
    </div>
    
    <label class="radio-inline">
      <input type="radio" name="division" value="A">A
    </label>
    <label class="radio-inline">
      <input type="radio" name="division" value="B">B
    </label>
    
    <div class="form-group">
      <label for="rollNo">Roll No:</label>
      <input type="text" class="form-control" value="${Stud.rollNo }" id="rollNo"  name="rollNo">
    </div>
   
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    
    <button type="submit" class="btn btn-default">Submit</button>
</form>
</c:when>
<c:when test="${mode == 'ViewStudent'}">
<table class="table table-striped table-hover table-bordered">
			    <thead>
			      <tr>
			        <th>Student Id:</th>
			        <th>Student Name:</th>
			        <th>Mobile:</th>
			        <th>Department:</th>
			        <th>Division:</th>
			        <th>Roll No:</th>
			        
			        
			      </tr>
			    </thead>
				    <tbody>
				    	<c:forEach items="${Studs}" var="stud">
				      		<tr>
				      			<td>${stud.sid}</td>
				      			<td>${stud.sname}</td>
				      			<td>${stud.smobile}</td>
				      			<td>${stud.department}</td>
				      			<td>${stud.division}</td>
				      			<td>${stud.rollNo}</td>
				      			
				      	
				      		 	<td><a href="editStud?id=${stud.sid}" class="btn btn-info btn-sm"> <span class="glyphicon glyphicon-pencil"></span> </a></td>
				      			<td><a href="deleteStud?id=${stud.sid}" class="btn btn-info btn-sm"> <span class="glyphicon glyphicon-trash"></span> </a></td> 
				      	 	
				      		</tr>	
				      	</c:forEach>		
				    </tbody>
	  		</table>

</c:when>

</c:choose>
<%@ include file="/WEB-INF/views/footer.jsp"%>