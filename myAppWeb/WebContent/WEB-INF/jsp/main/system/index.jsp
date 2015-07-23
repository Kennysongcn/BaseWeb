<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
 <%@ page import="com.kenny.app.provider.main.model.user.User"%>
<html>
<head>
    <title>Shiro综合案例</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/layout-default-latest.css">
</head>
<body>

<div class="ui-layout-north">欢迎[<shiro:principal/>]学习Shiro综合案例，<a href="${pageContext.request.contextPath}/logout">退出</a></div>
<div class="ui-layout-west">
    功能菜单<br/>
    <c:forEach items="${menus}" var="m">
        <a href="${pageContext.request.contextPath}/${m.url}" target="content">${m.name}</a><br/>
    </c:forEach>
</div>


<script src="${pageContext.request.contextPath}/static/js/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.layout-latest.min.js"></script>
<script>
    $(function () {
        $(document).ready(function () {
            $('body').layout({ applyDemoStyles: true });
        });
    });
</script>
</body>
</html>