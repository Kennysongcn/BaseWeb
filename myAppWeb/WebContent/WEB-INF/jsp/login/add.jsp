<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>用户登录</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->

</head>
<body>
<!-- 没有写action， 直接提交给自己/add， -->
	<sf:form method="post" modelAttribute="user">
		用户名：<sf:input path="username"/>
		密码：<sf:input path="password"/>
		<input type="submit"  value="添加用户"/>
	</sf:form>
</body>
</html>