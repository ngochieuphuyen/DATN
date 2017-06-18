

<%@page import="model.bean.Account"%>
<% Account accountLogin = (Account) session.getAttribute("account"); %>
<header class="main-header">
    <!-- Logo -->
    <a href="Home" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>A</b>LT</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg">P.CTSV</span>
    </a>
    <!-- ----- ending Logo -->
       <!-- Header Navbar: style can be found in header.less -->
       
    
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
     <div class = "pull-right">
     <br>
					  <div class="row">
						 <div class="col-md-4"> <input type ="text" value="Wellcom <%=accountLogin.getUsername()%>" id ="account" class="btn btn-primary"/></div>
						 <div class="col-md-2"></div>
						 <div class="col-md-4"><a href="DoLogout"><input type ="button" value="Logout" id ="logout" class="btn btn-default"/></a></div>
					  </div>
			   </div>
		<br>	   
      </nav>   
   </header>