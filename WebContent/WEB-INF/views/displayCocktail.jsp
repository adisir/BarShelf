<%@ page language="java" contentType="text/html;  charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.LinkedHashMap,com.BarShelf.entities.Cocktail, com.BarShelf.entities.Ingredient" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/displayCocktail.css" />
    <title>Cocktail | BarShelf</title>
  </head>

 <%@ include file = "headerNavBar.jsp" %>
	<% Cocktail cocktail = (Cocktail) request.getAttribute("cocktail"); 
	   LinkedHashMap<Ingredient, String> im = (LinkedHashMap<Ingredient, String>) request.getAttribute("im");
	%>

		
  <body>
    <div class="main-container">
      <div class="left-column">
        <img
          src=<%=cocktail.getImage() %>
          class="cocktail-img"
        />
      </div>
      <div class="right-column">
        <div class="cocktail-description">
        <h1><%=cocktail.getName() %></h1>
          <span><%
			if(cocktail.getAlcoholic()){
				out.print("Alcoholic");
			}else {
				out.print("Non-Alcoholic");
			}		          
          %></span>
          
          <p>
            <%=cocktail.getInstructions()%>
          </p>
        </div>

        <div class="ingredients-container">
          <span>Ingredients</span>
			
          <div class="ingredients">
          	<form action = "displayCocktail?cocktailName=<%=cocktail.getName() %>" method="post">
             <c:forEach items="${im}" var="entry">
			    <button name = "ingredient" value = "${entry.key.getName()}"> <c:out value="${entry.value}"/> <c:out value="${entry.key.getName()}"/>    </button> 
			    
			 </c:forEach> 
			 <input type="hidden" name="cname" value= <%=cocktail.getName() %>>
			 </form>
          </div>
          <div style="color:red; margin-top: 20px; text-decoration:none;">
          <% if(request.getAttribute("message")!=null){
        	out.print(request.getAttribute("message"));
       			 }; %>
          </div>
          
        </div>
      </div>
    </div>
   <script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
  </body>
</html>
