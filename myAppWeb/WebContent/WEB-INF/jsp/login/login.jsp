<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <%
	String orderNo = request.getParameter("orderNo");
	String orderId = request.getParameter("orderId");
	String path = request.getContextPath();
	
%>
<html>
<head>
    <title>用户登录</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
<script type="text/javascript"  src="<%=path%>/static/js/comment/jquery/jquery-2.0.3.min.js"></script>
<link  rel="stylesheet" type="text/css"  href="<%=path%>/static/css/bootstrap/css/bootstrap.min.css">
<script type="text/javascript"  src="<%=path%>/static/js/comment/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript"  src="<%=path%>/static/js/comment/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<div class='container'>
	<sf:form method="post" modelAttribute="user" class='form-signin' role='form'>
	        <h4 class='form-signin-heading'>用户登录</h4>
	        <sf:input path="username" id="userName" class='form-control' placeholder='请输入用户名'  />
	            <div style='height:10px;clear:both;display:block'></div>
	        <sf:input path="password" id="password" class='form-control' placeholder='请输入密码'  />
	        <div class='checkbox'>
	          <label>
	            <input type='checkbox' value='remember-me' /> 记住登录状态</label>
	        </div>
	        <button class='btn btn-lg btn-primary btn-block'  type='submit'>登录</button>
	      </sf:form>
    </div> 
</body>
</html>