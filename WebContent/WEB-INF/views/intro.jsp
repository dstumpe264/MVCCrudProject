<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome General</title>
</head>
<body>
<div class="container">
<div class="row">
<div class="col">
<img alt="Stumpicus" src="images/Stumpicus.png">
</div>
<div class="col">
<p>Humanity is corrupt. Everyone is a sinner. No one is pure. No one is innocent. I can save them all. Purge the wicked.<p>
<p>For me to save humanity I must conquer humanity. For humanity to be saved it must be purged of evil.
I can do this. The world can be saved under my rule. General with your help we can do this.
If I ruled over the world, if I acsend above all, this can be done. I will change the laws of the land.
I will change what it means to be 
Are you ready to begin?
<form:form action="buildArmy.do" method="get">
<input type="submit" value="Yes"/>
</form:form>
</div>
</div>
</div>
</body>
</html>