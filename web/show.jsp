<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="util.JsonUtil" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/7
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>用户名</th>
            <th>姓名</th>
            <th>工资</th>
            <th>手机号</th>
            <th>头像</th>
            <th>权限</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${UserList}" var="user">
            <tr>
                <form action="updateUser" method="post">
                    <input type="hidden" name="id" value="${user.id}">
                    <td><input type="text" name="username" value="${user.username}"></td>
                    <td><input type="text" name="name" value="${user.name}"></td>
                    <td><input type="text" name="salary" value="${user.salary}"></td>
                    <td><input type="text" name="telephone" value="${user.telephone}"></td>
                    <td><img src="${user.icon}"></td>
                    <td>${user.permission}</td>
                    <td>${user.state}</td>
                    <td>
                        <input type="submit" value="修改">
                        <input type="hidden" value="${error}" id = "error">
                        <a href="deleteUser?id=${user.id}">删除</a>
                    </td>
                </form>
            </tr>
        </c:forEach>
    </table>

<script>
    window.download = function () {
        var error = document.getElementById("error");
        if (error.value != null){
            alert(error.value);
        }
    }
</script>
</body>
</html>
