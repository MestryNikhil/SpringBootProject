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
      <form id="logoutForm" method = "post" action="${contextPath}/logout">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>      
	
      </form>
      <ul class="nav navbar-nav">
        <li class="active"><a href="${contextPath}/adminHome">Home</a></li>
        <li><a href="${contextPath}/admin/addLibrarian">Add Librarian</a></li>
        <li><a href="${contextPath}/admin/viewLibrarian">View Librarian</a></li>
     	
      </ul>
      <ul class="nav navbar-nav navbar-right">
      
      	<li><a onclick="document.forms['logoutForm'].submit()"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </ul>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>