<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Army Interface</title>
</head>
<body>
<h1>This is your army interface.</h1>
Here you will see the overview of all the warriors in your army with links to edit different units.
<br>
These are your starting units. Feel free to add or delete.<br><hr>
<c:forEach var="army" items="${army }">
Warriors Name: ${army.id} ${army.name} Rank: ${army.rank}  Weapon: ${army.weapon} Class: ${army.wClass }
<form method="post" action="delete.do">
<input type="submit" value="Delete">
<input type="hidden" name="id" value="${army.id}">
<br>
</form>
<form method="post" action="update.do">
<input type="submit" value="Update">
<input type="hidden" name="id" value="${army.id}">
<br>
</form>
<br>
</c:forEach>

</body>
</html>