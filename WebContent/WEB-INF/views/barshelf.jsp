<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List, com.BarShelf.entities.Ingredient" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/barshelf.css" />
    <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>My Shelf | BarShelf</title>
</head>
 <%@ include file = "headerNavBar.jsp" %>
<body>
<% 
List<Ingredient> barshelf = (List<Ingredient>) request.getAttribute("barshelf"); %>
<div id ="list_container">

  <ul>
  <%for(Ingredient i : barshelf){ %>
    <li>
      <span><i class= "fa fa-trash fa-lg"></i></span> 
      <img src= "<%=i.getImage() %>" >
      <div class="text">
         <h3><%=i.getName() %></h3>
     	 <p><%String[] descriptionarr = i.getDescription().split("(?<=[a-z])\\.\\s+");
      		
       	 if(descriptionarr.length >2){
      	  	for(int j = 0; j<2; j++){ out.print(descriptionarr[j]);}
      		 
      	  }
      %></p>
      </div>
     
    </li>
    <%} %>
  </ul>
</div>

<script
  src="https://code.jquery.com/jquery-3.5.1.min.js"
  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
  crossorigin="anonymous"></script>
<script>
//Click on X to delete Todo

$("li").on("click", "span",function(event){
	$(this).parent().fadeOut(500,function(){
		value=$(this).find('h3').html();
		$.ajax({
	        type: "POST",
	        url: "barshelf",//just example
	        data: "deleteIngredientName=" +  value,
	        error: function(XMLHttpRequest, textStatus, errorThrown) {
	            alert("some error");
	         }
	       });
	 
		$(this).remove();
		
	});


})

	$("li").on("click", "div",function(event){

		value=$(this).find('h3').html();
		$.ajax({
	        type: "POST",
	        url: "searchCocktailByIngredient",//just example
	        data: "ingredient=" +  value,
	        error: function(XMLHttpRequest, textStatus, errorThrown) {
	            alert("some error");
	        },
	        success: function(response, data){
	           
	                 window.location.replace('searchCocktailByIngredient');
	           
	      }
	       });

})

</script>

</body>
</html>