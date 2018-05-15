<nav class="navbar navbar-inverse">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index">eLibrary</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
     <form id ="logout" action="${contextPath}/logout" method="post">
     	<input type ="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
     </form>
      <ul class="nav navbar-nav">
        <li><a href="${contextPath}/librarianHome">Home</a></li>
        <li><a href="${contextPath}/librarian/addBook">Add Book</a></li>
        <li><a href="${contextPath}/librarian/viewBook">View Books</a></li>
        <li><a href="${contextPath}/librarian/addStudnetForm">Add Student</a></li>
        <li><a href="${contextPath}/librarian/viewStudents">View Students</a></li>
        <li><a href="${contextPath}/librarian/issueBookForm">Issue Book</a></li>
        <li><a href="${contextPath}/librarian/viewIssueBook">View Issued Book</a></li>
        
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
      
      	<li><a onclick="document.forms['logout'].submit()"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </ul>
		
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>