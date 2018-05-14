<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<c:choose>
	
	<c:when test="${mode == 'Admin_Home'}">
		<%@ include file="/WEB-INF/views/navadmin.jsp" %>
		<h1>Welcome Admin</h1>
		
	</c:when>
	
	<c:when test="${mode == 'Librarian_Home'}">
	<%@ include file="/WEB-INF/views/navlibrarian.jsp" %>
	<h1>Welcome Librarian</h1>
	
	</c:when>
</c:choose>
<%@ include file="/WEB-INF/views/footer.jsp"  %>