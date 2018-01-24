<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/24 0024
  Time: 下午 5:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="<%=request.getContextPath()%>/admin/sayHi">查看管理员信息（您需要具有管理员权限）</a>
    <a href="<%=request.getContextPath()%>/user/sayHi">查看管理员信息（您需要具有用户）</a>
    <a href="<%=request.getContextPath()%>/logout">登出</a>
</body>
</html>
