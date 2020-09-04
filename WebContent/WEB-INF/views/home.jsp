<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.List, com.BarShelf.entities.Cocktail" %>  

  
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css" />
    <title>Home | BarShelf</title>
  </head>
  <%@ include file = "headerNavBar.jsp" %>
  <body>
  	
    
     <% List<Cocktail> cocktails = (List) request.getAttribute("cocktails"); %>
	<div id="main-container">    
    <div id="cocktails-container">
    
    <% for(Cocktail c: cocktails) { %>
      <a class="cocktail" href="displayCocktail?cocktailName=<%=c.getName()%>">
        <div >
          <img
            src=<%= c.getImage() %>
            class="cocktail-img"
          />
          <div class="cocktail-text"><%= c.getName() %></div>
        </div>
      </a>
      <%} %>
    </div>
    </div>

  </body>
</html>