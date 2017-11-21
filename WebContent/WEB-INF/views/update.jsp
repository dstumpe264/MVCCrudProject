<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
  <link rel="stylesheet" href="css/warrior.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Warrior Interface</title>
</head>
<body>
<h1>Warrior Interface</h1>
<p><a href="buildArmy.do">Return to Army Interface</a>
<div class="container-fluid">
<div class="row">
<div class="col-6 image">
<img alt="stumperella" src="images/stumperella.png">
</div>
<form:form action="updateWarrior.do" method="post" modelAttribute="warrior">
	<div class = "row">
	<div class="col">
	Name: <form:input path="name" element="br"/><br> <form:errors path="name"/><br> 
	<input type="submit" value="Update Warrior"/>
	<input type="hidden" name="id" value="${warrior.id }">
	</div>
	<div class="col">
	Rank: <form:radiobuttons path="rank" element="br"/><br> <form:errors path="rank"/><br>
	</div>
	<div class="col">
	Weapon: <form:radiobuttons path="weapon" element="br"/><br> <form:errors path="weapon"/><br>
	</div>
	<div class="col">
	Class: <form:radiobuttons path="wClass" element="br"/><br> <form:errors path="wClass"/><br>
	</div>
	
	</div>
</form:form>
</div>
</div>
</body>
</html>