<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Drink Search</title>
</head>
<body>
	<div class="container">
	
		<div class="row">
		
			<form action="/">
				
				<label for="mainAlch">Choose a main Alch:</label>
					<select name="mainAlch" id="mainAlch">
					  <option value="vodka">Vodka</option>
					  <option value="gin">Gin</option>
					 </select>
				
				<input type="hidden" name="search" value="search" />
				
				<button type="submit">Search</button>			
			</form>
		
		</div>
		
		<div class="row">
		
			<c:forEach items="${drinkList}" var="drink">
				
				<div class="row">
					<div class="col text-end">
				<img src="${drink.strDrinkThumb}" width="100px" alt="" />
					</div>
					<div class="col">
				<p>Name: ${drink.strDrink}</p>
				
				<p>Drink ID: ${drink.idDrink}</p>
					</div>
				</div>
			</c:forEach>
		
		</div>
	
	
	
	</div>
</body>
</html>