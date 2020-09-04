<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/signup.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Sign Up | BarShelf</title>
  </head>
  <%@ include file = "headerNavBar.jsp" %>
  
  <body>
    <div class="main-container">
      <div class="form-container">
        <div class="title">
          Register Here
        </div>
       <div style = "color:red"> <% if(request.getAttribute("message")!=null){
        	out.print(request.getAttribute("message"));
        }; %></div>
        <br>
        <form:form action = "register" method="post" modelattribute="user">
          <div class="form" >
            <div class="input_field">
              <input type="text" placeholder="Name" class="input" name = "name" required="required"/>
              <i class="fas fa-user"></i>
            </div>
            <div class="input_field">
              <input type="email" placeholder="Email" class="input" name = "email"  required="required" />
              <i class="far fa-envelope"></i>
            </div>
            <div class="input_field">
              <input type="password" placeholder="Password" class="input"  name = "password" required="required"/>
              <i class="fas fa-lock"></i>
            </div>
            <div class="btn">
              <input type = "submit" value="Register" name = "submit"/>
            </div>
        </div>
      </form:form>
        
      </div>
  </div>
  </body>
   <script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
</html>
