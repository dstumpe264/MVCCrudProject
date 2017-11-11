<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Warrior Interface</title>
</head>
<body>
<h1>Welcome to the Warrior Interface</h1>
<form:form action="addWarrior.do" method="post" modelAttribute="warrior">
	Name: <form:input path="name"/> <form:errors path="name"/><br> 
	Rank: <form:radiobuttons path="rank"/><br>
	Weapon: <form:radiobuttons path="weapon"/><br>
	Class: <form:radiobuttons path="wClass"/>
	
	<input type="submit" value="Add Warrior"/>
</form:form>
</body>
</html>