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
<div class="container-fluid">
<div class="row">
<div class="col">
<form:form action="addWarrior.do" method="post" modelAttribute="warrior">
	Name: <form:input path="name"/>  <form:errors path="name"/> <br> 
	Rank: <form:radiobuttons path="rank"/> <form:errors path="rank"/><br>
	Weapon: <form:radiobuttons path="weapon"/> <form:errors path="weapon"/><br>
	Class: <form:radiobuttons path="wClass"/> <form:errors path="wClass"/><br>
	
	<input type="submit" value="Add Warrior"/>
</form:form>
</div>
<div class="col-4">
<img alt="Stumpinidas" src="images/stumpinidas.png">
</div>
</div>
</div>
</body>
</html>