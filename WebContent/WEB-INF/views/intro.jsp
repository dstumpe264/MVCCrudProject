<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
  <link rel="stylesheet" href="css/intro.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome General</title>
</head>
<body>
<div class="container">
<div class="row">
<div class="col-6">
<img alt="Stumpicus" src="images/Stumpicus.png">
</div>
<div class="col-6">
<p><strong>I am Lord Stumpicus</strong>, I will be the savior of humanity,<br> and you, 
good General you have been chosen to lead your own army in this fight.
<p>Humanity is corrupt. We are all sinners. No one is pure. No one is innocent. I can save us all. Purge the wicked.<p>
<p>For me to save humanity I must conquer humanity. For humanity to be saved it must be purged of evil.
I can do this. The world can be saved under my rule. General with your help we can do this.
If I ruled over the world, if I acsend above all, this can be done. I will change the laws of the land.
<br>
<strong>Are you ready to begin?</strong>
<form:form action="buildArmy.do" method="get">
<input type="submit" value="Yes"/>
</form:form>
</div>
</div>
</div>
</body>
</html>