<%@ page import="com.BarShelf.entities.User" %>  
  <%User user = ((User)session.getAttribute("user"));
  	Boolean loggedIn = false;
  	if(user!=null && user.getEmail()!=null){
  		loggedIn = true;
  	}
  
  %>
  <header>
      <nav class="navbar">
        <a href ="index" style= "text-decoration: none; color:white"><div class="brand-title">BarShelf</div></a>
        <a href="#" class="toggle-button">
          <span class="bar"></span>
          <span class="bar"></span>
          <span class="bar"></span>
        </a>
        <div class="navbar-links">
          <ul>
            <li><a href="searchCocktailByIngredient">Home </a></li>
            
            <%if(loggedIn){ %>
            	<li><a href="barshelf">My Shelf</a></li>
            <%}else{ %>
            <li><a href="login">Login</a></li>
            <li><a href="register">Register</a></li>
            <%}%>
          </ul>
        </div>
      </nav>
          <script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
    </header>