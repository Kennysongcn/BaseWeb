<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户添加</title>
</head>
<body>
<sf:form method="post" modelAttribute="user">
<table width="700" align="center" border="1">
	<tr>
	<td>用户名:</td><td><sf:input path="username"/><sf:errors path="username"/></td>
	</tr>
	<tr>
	<td>用户密码:</td><td><sf:password path="password"/><sf:errors path="password"/></td>
	</tr>
	<tr>
	<td colspan="2">
		<input type="submit" value="用户添加"/>
	</td>
	</tr>
</table>
</sf:form>
</body>
</html>