<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Shiro综合案例</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/layout-default-latest.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/css.css">
</head>
<body>
<a href="add">添加</a>
<table width="700" align="center" border="1" id="ssf">
	<tr>
	<td>用户标识:${pagers.total }</td><td>用户名</td><td>用户密码</td>
	<td>操作</td>
	</tr>
	<c:if test="${pagers.total le 0 }">
		<tr>
		<td colspan="6">目前还没有用户数据</td>
		</tr>
	</c:if>
	<c:if test="${pagers.total gt 0}">
		<c:forEach items="${pagers.datas }" var="u">
		<tr>
		<td>${u.id }</td><td><a href="addCabinet">${u.username }</a></td>
		<td>${u.password }</td>
		<td><a href="${u.id }/update">更新</a>&nbsp;<a href="${u.id }/delete">删除</a></td>
		</tr>
		</c:forEach>
		<tr>
		<td colspan="6">
			<jsp:include page="/inc/pager.jsp">
				<jsp:param value="users" name="url"/>
				<jsp:param value="${pagers.total}" name="items"/>
			</jsp:include>
		</td>
		</tr>	
	</c:if>
</table>
</html>