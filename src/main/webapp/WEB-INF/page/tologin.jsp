<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/22 0022
  Time: 下午 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form action="/j_spring_security_check" method="post">
        id:<input type="text" name="j_username">
        password:<input type="text" name="j_password">
        <input type="submit" value="提交">
    </form>
</body>
</html>
