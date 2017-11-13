<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
  <link rel="stylesheet" href="css/interface.css">
<title>Army Interface</title>
</head>
<body>
<h1>Army Interface</h1>
<h3>Manage your troops.</h3>
<br>

<div class="container">
<div class="row">
<div class="col troops scrollbar" id="style-13">
<h6>I have provided you with some of my very best warriors.</h6><hr>
<c:forEach var="army" items="${army }">
Warriors Name: ${army.name} <br> Rank: ${army.rank} <br> Weapon: ${army.weapon} <br> Class: ${army.wClass }
<div class="button">
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
</div>
<br>
</c:forEach>
<p><a class="link" href="add.do">Add a new Warrior</a></p>
<div class="row">
</div>
</div>
<div class="col">
<img alt="Stumpicus" src="images/stumpzilla.png">
</div>
</div>
</div>

</body>
</html>