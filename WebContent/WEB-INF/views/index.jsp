<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import=" com.BarShelf.entities.User" %>  
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
    <title>Discover Cocktails | BarShelf</title>
  </head>
  
  <body>
    <div class="landing-container">
      <div class="form-wrapper">
        <div class="form-box">
        <%User user = (User) request.getAttribute("user"); %>
          <form action = "searchCocktailByIngredient" method = "post"> 
            <h1>What is on your BarShelf<% if(user.getName() != null){
            	out.print(", " +user.getName());
            }  %>?</h1> 
            <p class="pos-rel">INGREDIENT</p>
            <div class="input-container">
              <input
                type="search"
                id="landing-search"
                name="ingredient"
                placeholder="Enter an ingredient"
              />
            </div>
            <br />
            <br />
            <div class="cta-container">
              <div>
                <input
                  type="checkbox"
                  id="alc-check"
                  name="alc-check"
                  value="non-alc"
                />
                <label for="alc-check">Non-Alcoholic </label>
              </div>
              <button type="submit" class="cta-btn btn">
                Find a cocktail   
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
     <script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
  </body>
</html>
