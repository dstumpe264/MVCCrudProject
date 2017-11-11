<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome General ${sesssionScope.general}</title>
</head>
<body>
Your name
<h1>${sessionScope.general}</h1>
<h1>Welcome to my army General</h1>
Are you ready to begin?
<form:form action="buildArmy.do" method="get">
<input type="submit" value="Yes"/>
</form:form>
</body>
</html>