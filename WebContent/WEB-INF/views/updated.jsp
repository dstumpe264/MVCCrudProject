<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
  <link rel="stylesheet" href="css/added.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Warrior Added</title>
</head>
<body>
<h1>${warrior.name} has been updated.</h1>
<h3>${warrior.name} rank is now ${warrior.rank}</h3>
<h3>${warrior.name} is now equipped with a ${warrior.weapon}.</h3>
<h3>${warrior.name} is now a ${warrior.wClass}.</h3>
<p><a href="buildArmy.do">Return to your Army's Interface</a>
</body>
</html>