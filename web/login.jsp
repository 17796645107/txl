<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/7
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="login">
        <div>
            ${error}
        </div>
        用户名：<input type="text" name = "username">
        密码：<input type="text" name = "password">
        <input type="submit" value="登录">
    </form>
</body>
</html>
