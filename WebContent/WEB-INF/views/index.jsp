<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stumpicus' Web App</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
  <link rel="stylesheet" href="css/welcome.css">
  
</head>
<body >
<h1>Welcome to Lord Stumpicus' Army</h1>
<div class="jumbotron vertical-center">
<div class="container-fluid intro">


<h2>Enter your name general</h2>
<form:form action="general.do" method="post" modelAttribute="general">
<input type="text" name="userName"/>
<input type="submit" value="Enter"/>
</form:form>
</div>

</div>
</div>
</body>
</html>